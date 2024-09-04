package com.ch04.dao;

import com.ch04.dto.User3DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User3RowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User3DTO dto = new User3DTO();
        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setBirth(rs.getString(3));
        dto.setHp(rs.getString(4));
        dto.setAddr(rs.getString(5));
        return dto;
    }


}
