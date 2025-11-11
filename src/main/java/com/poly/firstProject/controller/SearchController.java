package com.poly.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String mainSearch(@RequestParam("mainSearchKeyword") String searchKeyword){
        System.out.println("keyword:"+searchKeyword);
        return "";
    }
}
