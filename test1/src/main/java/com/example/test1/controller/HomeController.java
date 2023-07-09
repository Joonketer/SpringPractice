package com.example.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/member/save")
    public  String saveForm() {
//        save.html로 이동
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@RequestParam("memberEmail") String memberEmail,
                       @RequestParam("memberPassword") String memberPassword,
                       @RequestParam("memberName") String memberName){
        System.out.println("HomeController.save");
        System.out.println("memberEmail = " + memberEmail +
                ", memberPassword = " + memberPassword +
                ", memberName = " + memberName);
//        index.html로 이동
        return "index";
    }
}
