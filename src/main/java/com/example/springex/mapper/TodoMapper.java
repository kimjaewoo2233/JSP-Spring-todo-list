package com.example.springex.mapper;

import com.example.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    List<TodoVO> findAll();
    void insertTodo(TodoVO vo);
}
