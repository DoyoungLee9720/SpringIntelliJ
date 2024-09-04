package com.ch04.dao;

import com.ch04.dto.User5DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User5RowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User5DTO dto = new User5DTO();
        dto.setSeq(rs.getInt(1));
        dto.setName(rs.getString(2));
        dto.setGender(rs.getString(3));
        dto.setAge(rs.getInt(4));
        dto.setAddr(rs.getString(5));
        return dto;
    }


}
