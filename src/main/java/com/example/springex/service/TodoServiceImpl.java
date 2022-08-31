package com.example.springex.service;


import com.example.springex.domain.TodoVO;
import com.example.springex.dto.PageRequestDTO;
import com.example.springex.dto.PageResponseDTO;
import com.example.springex.dto.TodoDTO;
import com.example.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);    //잘라서 가져온다.
        List<TodoDTO> dtoList = voList.stream()     //가져온걸 변환한다.
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);    //토탈 개수 확인

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)     //page와 size가 필요하다.
                .build();

        return pageResponseDTO;
    }
//    @Override
//    public List<TodoDTO> getAll(){
//
//        return todoMapper.selectAll().stream()
//                .map(el-> modelMapper.map(el,TodoDTO.class))
//                .collect(Collectors.toList());
//
//    }

    @Override
    public TodoDTO selectOne(Long tno) {
        TodoVO vo = todoMapper.selectOne(tno);

        return modelMapper.map(vo,TodoDTO.class);
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO,TodoVO.class);

        todoMapper.update(todoVO);
    }
}
