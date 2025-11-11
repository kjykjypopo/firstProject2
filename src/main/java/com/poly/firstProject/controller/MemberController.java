package com.poly.firstProject.controller;

import com.poly.firstProject.dto.MemberForm;
import com.poly.firstProject.dto.MemberForm;
import com.poly.firstProject.entity.Member;
import com.poly.firstProject.entity.Member;
import com.poly.firstProject.service.MemberService;
import com.poly.firstProject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public String index(Model mo) {
        mo.addAttribute("memberList", memberService.index());
        return "members/index";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable("id") Long id, Model mo) {
        Member memberEntity = memberService.show(id);
        mo.addAttribute("memberItem", memberEntity);
        return "members/show";
    }

    @GetMapping("/members/new")
    public String newMemberForm() {
        return "members/new";
    }

    @PostMapping("/members/create")
    public String createMember(MemberForm form) {
        Member member = form.toEntity();
        memberService.create(form);
        return "redirect:/members";
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes mo) {
        memberService.delete(id);
        mo.addFlashAttribute("msg", "삭제되었습니다!");
        return "redirect:/members";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model mo) {
        Member memberEntity = memberService.edit(id);
        mo.addAttribute("memberItem", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm memberForm) {
        Member updated = memberService.update(memberForm);
        if (updated != null) {
            return "redirect:/members/" + updated.getId();
        }
        return "redirect:/members";
    }
}
