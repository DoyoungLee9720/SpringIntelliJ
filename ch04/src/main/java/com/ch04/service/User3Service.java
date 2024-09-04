package com.ch04.service;

import com.ch04.dao.User3DAO;
import com.ch04.dto.User3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User3Service {

    private User3DAO dao;

    @Autowired
    public User3Service(User3DAO dao) {
        this.dao = dao;
    }

    public void insertUser3(User3DTO dto){
        dao.insertUser3(dto);
    }

    public User3DTO selectUser3(String uid){
        return dao.selectUser3(uid);
    }

    public List<User3DTO> selectUser3s(){
        return dao.selectUser3s();
    }

    public void updateUser3(User3DTO dto){
        dao.updateUser3(dto);
    }

    public void deleteUser3(String uid){
        dao.deleteUser3(uid);
    }
}
