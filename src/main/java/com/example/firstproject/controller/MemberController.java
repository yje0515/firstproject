package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    //로그인
    @GetMapping("/login")
    public String memberLoginForm(){
        return "article";
    }

    //회원가입
    @GetMapping("/signup")
    public String signUpPage(){
        return "members/new";
    }
    @PostMapping("/join")
    public String join(MemberForm memberForm){
        System.out.println(memberForm.toString());
        Member member = memberForm.toEntity(); //DTO에 메소드
        System.out.println(member.toString());
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }
}
