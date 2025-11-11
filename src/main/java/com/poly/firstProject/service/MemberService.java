package com.poly.firstProject.service;


import com.poly.firstProject.dto.MemberForm;
import com.poly.firstProject.entity.Member;
import com.poly.firstProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> index(){
        List<Member> memberResultList=(List<Member>)memberRepository.findAll();
        return memberResultList;
    }

    public Member show(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }

    public Member edit(Long id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member create(MemberForm form){
        Member member =form.toEntity();
        return memberRepository.save(member);
    }

    public Member update(MemberForm form) {
        Member memberEntity = form.toEntity();
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        if (target != null) {
            return memberRepository.save(memberEntity);
        }
        return null;
    }
}