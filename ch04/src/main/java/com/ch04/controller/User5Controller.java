package com.ch04.controller;

import com.ch04.dto.User5DTO;
import com.ch04.service.User5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User5Controller {

    private User5Service service;

    @Autowired
    public User5Controller(User5Service service) {
        this.service = service;
    }

    @GetMapping("/user5/register")
    public String register() {
        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO dto) {

        System.out.println(dto);
        //등록
        service.insertUser5(dto);
        //리다이렉트
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/list")
    public String list(Model model){
        //조회
        List<User5DTO> users = service.selectUser5s();
        //System.out.println(users);
        
        //모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);
        return "/user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(@RequestParam("seq") String seq, Model model) {
        //System.out.println("seq " + seq);
        
        //수정 회원 조회
        User5DTO user = service.selectUser5(seq);

        //모델참조
        //model.addAttribute("user", user);
        model.addAttribute(user); //타입명으로 저장(소문자 시작 ->user5DTO)
        return "/user5/modify";
    }
    @PostMapping("/user5/modify")
    public String modify(@ModelAttribute User5DTO dto){ //@ModelAttribute 생략가능
        System.out.println(dto);

        //수정
        service.updateUser5(dto);
        //생략가능
        //model.addAttribute(dto);
        //리다이렉트
        return "redirect:/user5/list";
    }
    @GetMapping("/user5/delete")
    public String delete(@RequestParam("seq")String seq){//@RequestParam("seq") 생략하면 안됨 
        System.out.println("=seq= " + seq);
        //삭제
        service.deleteUser5(seq);
        //리다이렉트
        return "redirect:/user5/list";

    }
}
