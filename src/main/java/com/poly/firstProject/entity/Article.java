package com.poly.firstProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table(name="users")
public class Article {
    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
//    public Article(String title, String content){
//        this.title=title;
//        this.content=content;
//    }
//    public Article(){
//
//    }
}
