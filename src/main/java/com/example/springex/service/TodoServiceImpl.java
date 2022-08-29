package com.example.springex.service;


import com.example.springex.domain.TodoVO;
import com.example.springex.dto.TodoDTO;
import com.example.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoMapper todoMapper;

    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
            log.info(modelMapper);

            TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

            log.info(todoVO);

            todoMapper.insertTodo(todoVO);


    }
}
