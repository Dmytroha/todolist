package com.goit.todolist.entity;

import lombok.*;
import jakarta.persistence.*;

@Data
@Getter
@Setter
@ToString
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String content;

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Note() {

    }

}
