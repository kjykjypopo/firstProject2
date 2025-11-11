package com.poly.firstProject.service;

import com.poly.firstProject.dto.ArticleForm;
import com.poly.firstProject.entity.Article;
import com.poly.firstProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index(){
        List<Article> articleSelect = (List<Article>)articleRepository.findAll();
        return articleSelect;
    }

    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm form){
        Article article=form.toEntity();
        return articleRepository.save(article);
    }


    public void delete(Long id){
        articleRepository.deleteById(id);
    }
}
