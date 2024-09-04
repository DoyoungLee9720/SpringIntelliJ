package com.ch04.dao;

import com.ch04.dto.User4DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User4RowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User4DTO dto = new User4DTO();
        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setGender(rs.getString(3));
        dto.setAge(rs.getInt(4));
        dto.setHp(rs.getString(5));
        dto.setAddr(rs.getString(6));
        return dto;
    }


}
