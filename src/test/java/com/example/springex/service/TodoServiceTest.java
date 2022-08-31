package com.example.springex.service;

import com.example.springex.domain.TodoVO;
import com.example.springex.dto.PageRequestDTO;
import com.example.springex.dto.PageResponseDTO;
import com.example.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister(){

        TodoDTO todoDTO = TodoDTO.builder()
                .title("Test.....")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();

        todoService.register(todoDTO);
    }

    @Test
    public void testPaging(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

        PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
        //response에는 rufrnr dtoList가 있음 그걸 이미 pageRequset로 받아서 처리하고 결과를 사용
        log.info(responseDTO);
        responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));

    }


}