package org.gcash.training.codes.controller;

import org.gcash.training.codes.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    @Autowired
    private JdbcTemplate jdbc;

    private Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Reservation r = new Reservation();
        r.setBid(rs.getInt("bid"));
        r.setSid(rs.getInt("sid"));
        r.setDate(rs.getDate("date"));
        return r;
    }

    @PostMapping("/add")
    public String addReservation(@RequestBody Reservation res) {
        String sql = "INSERT INTO reserve (sid, bid, date) VALUES (?, ?, ?)";
        int rows = jdbc.update(sql, res.getSid(), res.getBid(), res.getDate());
        return rows + " reservation(s) added.";
    }

    @GetMapping("/boat/{bid}")
    public List<Reservation> getReservationsByBoatId(@PathVariable("bid") int bid) {
        String sql = "SELECT * FROM reserve WHERE bid = ?";
        return jdbc.query(sql, this::mapRow, bid);
    }

    @GetMapping("/{sid}")
    public List<Reservation> getReservationsBySailorId(@PathVariable("sid") int sid) {
        String sql = "SELECT * FROM reserve WHERE sid = ?";
        return jdbc.query(sql, this::mapRow, sid);
    }
}
