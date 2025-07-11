package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","지은");
        return "greetings";
    }
    @GetMapping("/bye")
    public String goodBye(Model model){
        model.addAttribute("nickname","징니");
        return "goodbye";
    }
//url
    @GetMapping("/random")
    public String randomQuotes(Model model){
        String[] quotes = {
                "삶이 있는 한 희망은 있다. - 키케로",
                "성공은 열정을 잃지 않고 실패를 거듭할 수 있는 능력이다. - 윈스턴 처칠",
                "어둠 속에서 별을 찾는다. - 찰리 채플린",
                "내일은 오늘보다 더 나은 날이 될 것이다. - 에이브러햄 링컨",
                "자신을 믿어라. 그러면 어떤 일도 가능하다. - 에밀리 디킨슨"
        };
        //랜덤의 숫자로 명언 배열의 인덱스를 정함
        int randomInt = (int)(Math.random() * quotes.length);
        //모델에 명언배열[랜덤인덱스] 데이터를 담아 전달
        model.addAttribute("quote",quotes[randomInt]);
        return "random-quotes";
        //html(mustache)파일
    }
}
