package com.example.springex.controller;


import com.example.springex.dto.PageRequestDTO;
import com.example.springex.dto.TodoDTO;
import com.example.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public void list(@Valid PageRequestDTO pageRequestDTO,BindingResult bindingResult, Model model){

        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO",todoService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register(){
        log.info("Get todo register.......");
    }

    @GetMapping({"/read","/modify"})
    public void read(Long tno,Model model,PageRequestDTO requestDTO){
        TodoDTO todoDTO = todoService.selectOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto",todoDTO);
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
            //????????? ????????? ????????? ????????? ?????? ????????? ??????????????? ???????????? redirectAttributes??? ??????
            return "redirect:/todo/register";
        }

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         PageRequestDTO requestDTO){
        if(bindingResult.hasErrors()){
            log.info("has error____");
            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno",todoDTO.getTno());
            return "redirect:/todo/modify";
        }


        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("tno",todoDTO.getTno());
        return "redirect:/todo/read";
    }
    @PostMapping("/remove")
    public String remove(Long tno,PageRequestDTO requestDTO){
        log.info("=========remove=-========");
        log.info("tno: "+tno);
        todoService.remove(tno);

        return "redirect:/todo/list";
    }



    }
