package com.ch04.dao;

import com.ch04.dto.User4DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User4DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User4DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser4(User4DTO dto){
        String sql = "insert into `user4` values(?,?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getHp(),
                dto.getAddr()
        };
        jdbcTemplate.update(sql,params);
    }
    public User4DTO selectUser4(String uid){
        String sql = "select * from user4 where uid=?";
        User4DTO dto =(User4DTO) jdbcTemplate.queryForObject(sql, new User4RowMapper(), uid);

        return dto;
    }
    public List<User4DTO> selectUser4s(){
        String sql = "select * from user4";

        return jdbcTemplate.query(sql, new User4RowMapper());
        //String sql = "select * from user4";
        //List<User4DTO> users = jdbcTemplate.query(sql, new User4RowMapper());
        //return users;
        //return jdbcTemplate.query(sql, new User4RowMapper())
    }
    public void updateUser4(User4DTO dto){
        String sql = "update user4 set name=?,gender=?,age=?,hp=?,addr=? where uid=?";
        Object[] params = {
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getHp(),
                dto.getAddr(),
                dto.getUid()
        };
        jdbcTemplate.update(sql,params);
    }
    public void deleteUser4(String uid){
        String sql = "delete from user4 where uid=?";
        jdbcTemplate.update(sql,uid);

    }
}
