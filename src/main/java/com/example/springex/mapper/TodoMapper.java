package com.example.springex.mapper;

import com.example.springex.domain.TodoVO;
import com.example.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    List<TodoVO> selectAll();
    void insertTodo(TodoVO vo);

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO requestDTO);
}
