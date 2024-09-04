package com.ch04.dao;

import com.ch04.dto.User5DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User5DAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User5DAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser5(User5DTO dto){
        String sql = "insert into `user5` (name,gender,age,addr) values (?,?,?,?)";
        Object[] params = {
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getAddr()
        };
        jdbcTemplate.update(sql,params);
    }
    public User5DTO selectUser5(String seq){
        String sql = "select * from user5 where seq=?";
        User5DTO dto =(User5DTO) jdbcTemplate.queryForObject(sql, new User5RowMapper(), seq);

        return dto;
    }
    public List<User5DTO> selectUser5s(){
        String sql = "select * from user5";

        return jdbcTemplate.query(sql, new User5RowMapper());
        //String sql = "select * from user5";
        //List<User5DTO> users = jdbcTemplate.query(sql, new User5RowMapper());
        //return users;
        //return jdbcTemplate.query(sql, new User5RowMapper())
    }
    public void updateUser5(User5DTO dto){
        String sql = "update user5 set name=?,gender=?,age=?,addr=? where seq=?";
        Object[] params = {
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getAddr(),
                dto.getSeq()
        };
        jdbcTemplate.update(sql,params);
    }
    public void deleteUser5(String seq){
        String sql = "delete from user5 where seq=?";
        jdbcTemplate.update(sql,seq);

    }
}
