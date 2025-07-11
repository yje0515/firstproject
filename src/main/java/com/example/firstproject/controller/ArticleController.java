package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    //import
    @Autowired// 스프링부트가 미리 생성해 놓은 Repository 객체 주입(DI)의존성 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    //template -> DTO -> Controller MVC패턴
    public String createArticle(ArticleForm form){
        //데이터 잘 받아왔는지 확인
        System.out.println(form);
        //1. DTO를 DB에 저장하기 위해 Entity로 변환하자!
        Article article = form.toEntity();
        System.out.println(article.toString());// 잘 변환됐나?
        //2. Entity를 Repository로 DB에 저장하자!
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());// 잘 저장됐나?
        return "";
    }
}
