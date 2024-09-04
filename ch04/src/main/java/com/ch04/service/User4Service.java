package com.ch04.service;

import com.ch04.dao.User4DAO;
import com.ch04.dto.User4DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User4Service {

    private User4DAO dao;

    @Autowired
    public User4Service(User4DAO dao) {
        this.dao = dao;
    }

    public void insertUser4(User4DTO dto){
        dao.insertUser4(dto);
    }

    public User4DTO selectUser4(String uid){
        return dao.selectUser4(uid);
    }

    public List<User4DTO> selectUser4s(){
        return dao.selectUser4s();
    }

    public void updateUser4(User4DTO dto){
        dao.updateUser4(dto);
    }

    public void deleteUser4(String uid){
        dao.deleteUser4(uid);
    }
}
