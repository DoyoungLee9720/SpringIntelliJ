package com.ch07.repository;

import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private  User1Repository user1Repository;

    @Test
    void findUser1ByUid() {
       User1 entity = user1Repository.findUser1ByUid("A101");
        System.out.println(entity);

    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("강감찬");
        System.out.println(users);
    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("강감찬");
        System.out.println(users);
    }
//////////////////////

    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("A101", "강감찬");
        System.out.println(entity);
    }

    @Test
    void findUser1ByUidOrName() {
        List<User1> entity = user1Repository.findUser1ByUidOrName("A101","강감찬");
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThan(18);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> entity = user1Repository.findUser1ByAgeGreaterThanEqual(18);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeLessThan() {
        List<User1> entity = user1Repository.findUser1ByAgeLessThan(18);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> entity = user1Repository.findUser1ByAgeLessThanEqual(18);
        System.out.println(entity);
    }

    @Test
    void findUser1ByAgeBetween() {
        List<User1> entity = user1Repository.findUser1ByAgeBetween(18, 30);
        System.out.println(entity);
    }

    @Test
    void findUser1ByNameLike() {
        List<User1> entity = user1Repository.findUser1ByNameLike("김%");
        System.out.println(entity);
    }

    @Test
    void findUser1ByNameContains() {
        List<User1> entity = user1Repository.findUser1ByNameContains("순");
        System.out.println(entity);
    }

    @Test
    void findUser1ByNameStartsWith() {
        List<User1> entity = user1Repository.findUser1ByNameStartsWith("이");
        System.out.println(entity);
    }

    @Test
    void findUser1ByNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByName() {
    }

    @Test
    void findUser1ByOrderByNameAsc() {
    }

    @Test
    void findUser1ByOrderByNameDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void selectUser1UnderAge30() {
    }

    @Test
    void selectUser1WhereName() {
    }

    @Test
    void selectUser1WhereNameParam() {
    }

    @Test
    void selectFromParentJoinChild() {
       List<Object[]> list = user1Repository.selectFromParentJoinChild("P101");
       for(Object[] obj : list){
           Parent parent = (Parent)obj[0];
           Child child = (Child)obj[1];
           System.out.println(parent);
           System.out.println(child);
       }

    }
}