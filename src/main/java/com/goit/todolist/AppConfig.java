package com.goit.todolist;
import com.goit.todolist.entity.Note;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Map<Long, Note> notes() {

        Map<Long, Note> notes = new HashMap<>();
        return notes;
    }

}
