package com.ch04.service;

import com.ch04.dao.User5DAO;
import com.ch04.dto.User5DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User5Service {

    private User5DAO dao;

    @Autowired
    public User5Service(User5DAO dao) {
        this.dao = dao;
    }

    public void insertUser5(User5DTO dto){
        dao.insertUser5(dto);
    }

    public User5DTO selectUser5(String seq){
        return dao.selectUser5(seq);
    }

    public List<User5DTO> selectUser5s(){
        return dao.selectUser5s();
    }

    public void updateUser5(User5DTO dto){
        dao.updateUser5(dto);
    }

    public void deleteUser5(String seq){
        dao.deleteUser5(seq);
    }
}
