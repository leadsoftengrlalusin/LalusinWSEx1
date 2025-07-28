package org.gcash.training.codes.controller;

import org.gcash.training.codes.model.Sailor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/sailor")
public class SailorRestController {

    @Autowired
    private JdbcTemplate jdbc;

    private RowMapper<Sailor> sailorRowMapper = new RowMapper<>() {
        @Override
        public Sailor mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Sailor(
                rs.getLong("id"),
                rs.getInt("sid"),
                rs.getString("name"),
                rs.getInt("rating"),
                rs.getInt("age")
            );
        }
    };

    @PostMapping("/add")
    public String addSailor(@RequestBody Sailor sailor) {
        String sql = "INSERT INTO sailor (sid, name, rating, age) VALUES (?, ?, ?, ?)";
        int rows = jdbc.update(sql, sailor.getSid(), sailor.getName(), sailor.getRating(), sailor.getAge());
        return rows + " sailor(s) added.";
    }

    @PutMapping("/update/name")
    public String updateSailorName(@RequestParam("sid") int sid, @RequestParam("name") String name) {
    	String sql = "UPDATE sailor SET name = ? WHERE sid = ?";
        int rows = jdbc.update(sql, name, sid);
        return rows + " sailor(s) updated.";
    }

    @PutMapping("/update/all")
    public String updateAll(@RequestBody Sailor sailor) {
        String sql = "UPDATE sailor SET name = ?, rating = ?, age = ? WHERE sid = ?";
        int rows = jdbc.update(sql, sailor.getName(), sailor.getRating(), sailor.getAge(), sailor.getSid());
        return rows + " sailor(s) updated.";
    }

    @DeleteMapping("/delete/{sid}")
    public String deleteSailor(@PathVariable("sid") int sid) {
        String sql = "DELETE FROM sailor WHERE sid = ?";
        int rows = jdbc.update(sql, sid);
        return rows + " sailor(s) deleted.";
    }

    @GetMapping("/list/all")
    public List<Sailor> listAllSailors() {
        return jdbc.query("SELECT * FROM sailor", sailorRowMapper);
    }
}
