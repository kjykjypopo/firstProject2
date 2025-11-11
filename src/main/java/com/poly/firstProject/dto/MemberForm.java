package com.poly.firstProject.dto;

import com.poly.firstProject.entity.Article;
import com.poly.firstProject.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    private Long id;
    private String memberId;
    private String password;
    private String name;
    private String email;

    public Member toEntity(){
        return new Member(id, memberId, password, name, email);
    }
}
