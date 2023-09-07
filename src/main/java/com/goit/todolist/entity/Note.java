package com.goit.todolist.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private static  Long generatedId = 0L;
    private Long id = generatedId++;
    private String title;
    private String content;


}
