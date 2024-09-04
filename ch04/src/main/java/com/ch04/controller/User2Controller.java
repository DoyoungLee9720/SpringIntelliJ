package com.ch04.controller;

import com.ch04.dto.User2DTO;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private User2Service service;

    @Autowired
    public User2Controller(User2Service service) {
        this.service = service;
    }

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto) {

        System.out.println(dto);
        //등록
        service.insertUser2(dto);
        //리다이렉트
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model){
        //조회
        List<User2DTO> users = service.selectUser2s();
        //System.out.println(users);
        
        //모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);
        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        //System.out.println("uid " + uid);
        
        //수정 회원 조회
        User2DTO user = service.selectUser2(uid);

        //모델참조
        //model.addAttribute("user", user);
        model.addAttribute(user); //타입명으로 저장(소문자 시작 ->user2DTO)
        return "/user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(@ModelAttribute User2DTO dto){ //@ModelAttribute 생략가능
        System.out.println(dto);

        //수정
        service.updateUser2(dto);
        //생략가능
        //model.addAttribute(dto);
        //리다이렉트
        return "redirect:/user2/list";
    }
    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid")String uid){//@RequestParam("uid") 생략하면 안됨 
        System.out.println("=uid= " + uid);
        //삭제
        service.deleteUser2(uid);
        //리다이렉트
        return "redirect:/user2/list";

    }
}
