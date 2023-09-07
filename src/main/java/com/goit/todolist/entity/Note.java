package com.goit.todolist.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private Long id;
    private String title;
    private String content;


}
