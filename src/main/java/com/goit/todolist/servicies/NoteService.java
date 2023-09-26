package com.goit.todolist.servicies;

import com.goit.todolist.entity.Note;
import com.goit.todolist.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public static final String NOTE_DSNT_EXST="Note with id - %s doesn't exist!";


    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    //- повертає список всіх нотаток
    public List<Note> listAll(){
        return noteRepository.findAll();
    }
     // додає
    public Note add(Note note){
        return noteRepository.save(note);
    }

    //- видаляє нотатку з вказаним ідентифікатором.
    public void deleteById(long id) {
             noteRepository.deleteById(id);
    }

    //- шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
    public void update(Note note){
        noteRepository.save(note);
    }

    //- повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
    public Note getById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                String.format("Get failure." + NOTE_DSNT_EXST, id)));
    }

}
