package com.poly.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        System.out.println("hi");
        model.addAttribute("name","김지연");
        model.addAttribute("mail",5);
        return "greetings";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/randomQuote")
    public String randomQuoteMethod(Model model){
        String[] quotes={
                "오늘 할일을 내일로 미루지 마라.",
                "내일 죽을 것처럼 오늘을 살아라",
                "생각하는 대로 살지 않으면, 사는 대로 생각하게 된다.",
                "최고의 복수는 무시하고 성공하는 것이다.",
                "자기 자신을 믿으세요."
        };
        int ranNum=(int)(Math.random() * 5);
        model.addAttribute("result",quotes[ranNum]);
        return "randomQuteView";
    }



}
