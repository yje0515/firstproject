package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
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
//        System.out.println(form);
        log.info(form.toString());
        //1. DTO를 DB에 저장하기 위해 Entity로 변환하자!
        Article article = form.toEntity();
//        System.out.println(article.toString());// 잘 변환됐나?
        log.info(article.toString());
        //2. Entity를 Repository로 DB에 저장하자!
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());// 잘 저장됐나?
        log.info(saved.toString());
        return "";
    }

    @GetMapping("/articles/{id}") //id는 변수로 사용됨
    public String show(@PathVariable Long id, Model model){ //id를 매개변수로 받아옴

        //잘 받아왔나 확인
        log.info("id : "+id);

        //1. id를 조회해 데이터 받아오기 반환형 -> Optional<Article>
        Article articelEntity = articleRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("article",articelEntity);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1.모든 데이터 가져오기 ArrayList ->List로 업캐스팅 할 수도 있음.
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("articleList",articleEntityList);
        //3. 뷰 페이지 설정하기
        return "articles/index";
    }
}
