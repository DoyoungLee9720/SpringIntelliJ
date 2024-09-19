package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {
        User user = User.builder()
                .uid("a101")
                .name("김유신")
                .role("ADMIN")
                .build();
        String jwt = jwtProvider.createToken(user,1);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkbGVoZHVkMjI0QGdtYWlsLmNvbSIsImlhdCI6MTcyNjEyMjkwMSwiZXhwIjoxNzI2MjA5MzAxLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.KCZ5y30_PKdKDqKghg52GIuAl8AC_AocWrZqmqRjb8Y";
        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + " " + role);
    }

    @Test
    void getAuthentication() {

    }

    @Test
    void validateToken() {
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkbGVoZHVkMjI0QGdtYWlsLmNvbSIsImlhdCI6MTcyNjEyMjkwMSwiZXhwIjoxNzI2MjA5MzAxLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.KCZ5y30_PKdKDqKghg52GIuAl8AC_AocWrZqmqRjb8Y";
        String token1="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkbGVoZHVkMjI0QGdtYWlsLmNvbSIsImlhdCI6MTcyNjEyMjkwMSwiZXhwIjoxNzI2MTIyOTAxLCJ1c2VybmFtZSI6ImExMDEiLCJyb2xlIjoiQURNSU4ifQ.vRRCvWX-EIGMcyrYoVEuwaXBWvqsYGCfk2A_b5aX-nY";
        try{
            jwtProvider.validateToken(token1);
            System.out.println("토큰 이상 없음");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}