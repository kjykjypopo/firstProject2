package com.poly.firstProject.controller;

import com.poly.firstProject.dto.ArticleForm;
import com.poly.firstProject.entity.Article;
import com.poly.firstProject.repository.ArticleRepository;
import com.poly.firstProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public String index(Model mo){
        //List<Article> articleSelect = (List<Article>)articleRepository.findAll();
        List<Article> articleSelect= articleService.index();
        mo.addAttribute("articleList",articleSelect);
        return "article/index";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable("id") Long id, Model mo){
        // System.out.println(id);
        mo.addAttribute("showArticleItem", articleService);
        return "article/show";
    }

    @GetMapping("/articles/new")
    public String newArticle(){
        return "article/new";
    }

    @PostMapping("/articles/create")
    public String newArticle(ArticleForm form){
        articleService.create(form);
        return "redirect:/articles";

        //System.out.println(form.getTitle() +", "+form.getContent());
        //return "";
    }



    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable("id") Long id, RedirectAttributes mo){
        articleService.delete(id);
        mo.addFlashAttribute("msg", "삭제되었습니다!");
        return "redirect:/articles";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model mo) {
        mo.addAttribute("articleItem", articleService);
        return "article/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm articleForm){
        articleService.create(articleForm);
        return "redirect:/articles/";
    }

}
