package com.example.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;

    @NotEmpty
    private String title;
   // @Future     //지금보다 미래이다.
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty       //빈문자열 불가
    private String writer;

}
