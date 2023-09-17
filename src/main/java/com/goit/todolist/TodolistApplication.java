package com.goit.todolist;

import com.goit.todolist.entity.Note;
import com.goit.todolist.servicies.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {

	SpringApplication.run(TodolistApplication.class, args);
	}


}
