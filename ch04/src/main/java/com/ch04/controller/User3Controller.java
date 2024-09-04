package com.ch04.controller;

import com.ch04.dto.User3DTO;
import com.ch04.service.User3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User3Controller {

    private User3Service service;

    @Autowired
    public User3Controller(User3Service service) {
        this.service = service;
    }

    @GetMapping("/user3/register")
    public String register() {
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO dto) {

        System.out.println(dto);
        //등록
        service.insertUser3(dto);
        //리다이렉트
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/list")
    public String list(Model model){
        //조회
        List<User3DTO> users = service.selectUser3s();
        //System.out.println(users);
        
        //모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);
        return "/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        //System.out.println("uid " + uid);
        
        //수정 회원 조회
        User3DTO user = service.selectUser3(uid);

        //모델참조
        //model.addAttribute("user", user);
        model.addAttribute(user); //타입명으로 저장(소문자 시작 ->user3DTO)
        return "/user3/modify";
    }
    @PostMapping("/user3/modify")
    public String modify(@ModelAttribute User3DTO dto){ //@ModelAttribute 생략가능
        System.out.println(dto);

        //수정
        service.updateUser3(dto);
        //생략가능
        //model.addAttribute(dto);
        //리다이렉트
        return "redirect:/user3/list";
    }
    @GetMapping("/user3/delete")
    public String delete(@RequestParam("uid")String uid){//@RequestParam("uid") 생략하면 안됨 
        System.out.println("=uid= " + uid);
        //삭제
        service.deleteUser3(uid);
        //리다이렉트
        return "redirect:/user3/list";

    }
}
