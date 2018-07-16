package com.example.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.bean.Station;

@Repository
@Component
public class StationController {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	

	class StationRowMapper implements RowMapper < Station > {
        @Override
        public Station mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Station student = new Station();
            student.setStationId(rs.getString(1));
            student.setName(rs.getString(2));
            student.setHdEnabled(rs.getBoolean(3));
            student.setCallSign(rs.getString(4));
            return student;
        }
    }
    public List < Station > findAll() {
        return jdbcTemplate.query("select * from station", new StationRowMapper());
    }
    
    public List < Station > findAllHdEnabled() {
        return jdbcTemplate.query("select * from station where HdEnabled=true", new StationRowMapper());
    }
    
    public List < Station > findByStationIdName(String id, String name) {
        return jdbcTemplate.query("select * from station where stationid=? or name=?", new Object[] {
        		id, name}, new BeanPropertyRowMapper < Station > (Station.class));
    }
    
    public int deleteByStationId(String stationId) {
        return jdbcTemplate.update("delete from station where stationid=?", new Object[] {
        		stationId
        });
    }
    public int insert(Station station) {
        return jdbcTemplate.update("insert into station values(?,  ?, ?,?)",
            new Object[] {
                station.getStationId(),station.getName(),station.isHdEnabled(),station.getCallSign()
            });
    }


}
