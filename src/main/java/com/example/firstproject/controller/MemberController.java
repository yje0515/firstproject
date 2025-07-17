package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;


    //회원가입창으로 이동
    @GetMapping("/signup")
    public String signUpPage(){
        return "members/new";
    }
    //회원가입
    @PostMapping("/join")
    public String join(MemberForm memberForm){
//        System.out.println(memberForm.toString());
        log.info(memberForm.toString());
        Member member = memberForm.toEntity(); //DTO에 메소드
//        System.out.println(member.toString());
        log.info(member.toString());
        Member saved = memberRepository.save(member);
//        System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }

    //특정회원
    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("member's id : "+id);
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member",memberEntity);
        return "members/show";
    }

    //전체 회원
    @GetMapping("/members")
    public String index(Model model){
        ArrayList<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList",memberList);
        return "members/index";
    }
}
