package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    //기본 생성자(Generate->Constructor)
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    //데이터를 잘 받았는지 확인
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    //DTO 객체를 Entity로 반환
    public Article toEntity() {
        return new Article(null,title,content);
    }
}
