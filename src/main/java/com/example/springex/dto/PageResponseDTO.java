package com.example.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    //제네릭을 이용하는 이유는 나중에 다른 종류의 객체를 이용해서 PageResponseDTO를 구성하도록 위함이ㅏ다.
    private int page;
    private int size;
    private int total;
    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;
    //이전 페이지의 존재여부
    private boolean prev;
    //다음  페이지의 존재여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,List<E> dtoList,int total){
                this.page = pageRequestDTO.getPage();
                this.size = pageRequestDTO.getSize();

                this.total =total;      //전체 데이터 개수
                this.dtoList = dtoList;

                this.end = (int)(Math.ceil(this.page/10.0)) * 10;       // 11 일경우 1.1이된다. 이걸 올림하면 2가됨
                this.start = this.end -9;   //위에 11이면 20이고 20에서 9를 빼면 시작은 11이다.

                int last = (int)(Math.ceil((total/(double)size)));  //위에 end는 보여주는 곳에서 마지막이고 이건 total에 마지막
                this.end = end > last ? last : end; // 지금 현재 토탈이 100페이지까지 있는데 현재 있는 곳은 11페이지이면 end(20) 이보여야한다

                this.prev = this.start>1;
                this.next = total>this.end*this.size;

    }
}
