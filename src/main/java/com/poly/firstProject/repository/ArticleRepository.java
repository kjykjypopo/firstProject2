package com.poly.firstProject.repository;

import com.poly.firstProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
