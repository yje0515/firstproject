package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;

    //DTO 객체를 Entity로 반환
    public Article toEntity() {
        return new Article(null,title,content);
    }
}
