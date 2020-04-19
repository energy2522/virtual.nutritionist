package ua.nure.virtual.nutritionist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }

//    @PostMapping("/main")
//    public String test() {
//        return "redirecmain";
//    }
}
