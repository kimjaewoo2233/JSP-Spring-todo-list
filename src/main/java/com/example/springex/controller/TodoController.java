package com.example.springex.controller;


import com.example.springex.dto.TodoDTO;
import com.example.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    @RequestMapping("/list")
    public void list(){
        log.info("todo list......");
    }

    @GetMapping("/register")
    public void register(){
        log.info("Get todo register.......");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes
                               ){
        log.info(todoDTO);
        log.info("Post todo register.......");

        if(bindingResult.hasErrors()){
            log.info("has Errors.....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            //검증에 에러가 있다면 화면에 다시 보내고 에러내용을 보기위해 redirectAttributes를 사용
            return "redirect:/todo/register";
        }

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }
}
