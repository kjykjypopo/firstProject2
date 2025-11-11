package com.poly.firstProject.dto;

import com.poly.firstProject.entity.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity(){
        return new Article(id, title, content);
    }


}
