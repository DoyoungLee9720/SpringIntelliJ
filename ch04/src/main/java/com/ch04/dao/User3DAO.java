package com.ch04.dao;

import com.ch04.dto.User3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User3DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User3DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser3(User3DTO dto){
        String sql = "insert into `user3` values(?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAddr()
        };
        jdbcTemplate.update(sql,params);
    }
    public User3DTO selectUser3(String uid){
        String sql = "select * from user3 where uid=?";
        User3DTO dto =(User3DTO) jdbcTemplate.queryForObject(sql, new User3RowMapper(), uid);

        return dto;
    }
    public List<User3DTO> selectUser3s(){
        String sql = "select * from user3";

        return jdbcTemplate.query(sql, new User3RowMapper());
        //String sql = "select * from user3";
        //List<User3DTO> users = jdbcTemplate.query(sql, new User3RowMapper());
        //return users;
        //return jdbcTemplate.query(sql, new User3RowMapper())
    }
    public void updateUser3(User3DTO dto){
        String sql = "update user3 set name=?,birth=?,hp=?,addr=? where uid=?";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getAddr(),
                dto.getAddr(),
                dto.getUid()
        };
        jdbcTemplate.update(sql,params);
    }
    public void deleteUser3(String uid){
        String sql = "delete from user3 where uid=?";
        jdbcTemplate.update(sql,uid);

    }
}
