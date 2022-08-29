package com.example.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller     // 해당 클래스가 스프링 MVC 에서 컨트롤러로 역할 그리고 스프링의 빈으로 처리되기 위해서 사용
public class SampleController {

        @GetMapping("/hello")
        public void hello(){
                log.info("hello........");
        }
        @GetMapping("/ex1")
        public void ex1(String name,int age){   // ex1?name=AAA&age=16
                log.info("ex1.......");
                log.info("name: "+name);
                log.info("age: "+age);
        }

        @GetMapping("/ex2")
        public void ex2(@RequestParam(name = "name",defaultValue = "AAA") String name,
                        @RequestParam(name = "age",defaultValue = "20") int age){
                log.info("ex2......");
                log.info("name {}",name);
                log.info("age: {}",age);
        }

        @GetMapping("/ex4")
        public void ex4(Model model){
                model.addAttribute("message","Hello");
        }
        @GetMapping("/ex5")
        public String ex5(RedirectAttributes redirectAttributes){
                redirectAttributes.addAttribute("name","ABC");
                redirectAttributes.addFlashAttribute("result","success");

                return "redirect:/ex6";
        }

        @GetMapping("/ex6")
        public void ex6(){

        }
}
