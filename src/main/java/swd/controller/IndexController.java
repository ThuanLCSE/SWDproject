package swd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("welcome")
    public String greeting(Model model){
        System.out.println("index Controller handling!");
        return "index";
    }
}
