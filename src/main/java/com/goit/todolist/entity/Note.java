package com.goit.todolist.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Note {
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    private Long id;
    private String title;
    private String content;


}
