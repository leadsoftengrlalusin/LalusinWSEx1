package org.gcash.training.codes.controller;

import org.gcash.training.codes.model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/boat")
public class BoatRestController {

    @Autowired
    private JdbcTemplate jdbc;
    
    private Boat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Boat boat = new Boat();
        boat.setBid(rs.getInt("bid"));
        boat.setName(rs.getString("name"));
        boat.setColor(rs.getString("color"));
        return boat;
    }

    @PostMapping("/add")
    public String addBoat(@RequestBody Boat boat) {
        String sql = "INSERT INTO bid (bid, name, color) VALUES (?, ?, ?)";
        int rows = jdbc.update(sql, boat.getBid(), boat.getName(), boat.getColor());
        return rows + " boat(s) added.";
    }

    @GetMapping("/list/all")
    public List<Boat> listAllBoats() {
        String sql = "SELECT * FROM bid";
        return jdbc.query(sql, this::mapRow);
    }
}
