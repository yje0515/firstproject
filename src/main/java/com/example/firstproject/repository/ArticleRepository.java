package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

//엔티티 관리 제너릭 <관리대상 Entity의 클래스타입,대푯값 타입>
public interface ArticleRepository extends CrudRepository<Article,Long>{
}
