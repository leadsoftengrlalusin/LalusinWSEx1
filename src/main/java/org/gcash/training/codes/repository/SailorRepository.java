package org.gcash.training.codes.repository;

import org.gcash.training.codes.model.Sailor;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SailorRepository {

    private final JdbcTemplate jdbc;

    public SailorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Sailor> findAll() {
    	return jdbc.query("SELECT * FROM sailor", new RowMapper<Sailor>() {
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
    	});

    }
}
