package com.goit.todolist.servicies;

import com.goit.todolist.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private final Map<Long, Note> notes;
public static final String NOTE_DSNT_EXST="Note with id - %s doesn't exist!";

    public NoteService() {
        notes = new HashMap<>();
    }

    List<Note> listAll(){return new ArrayList<>(notes.values()); } //- повертає список всіх нотаток
    //- додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку з згенерованим ідентифікатором.
    Note add(Note note){
        if (!notes.containsKey(note.getId())) {
            notes.put(note.getId(), note);
        }
        return note;
    }

    //- видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
    void deleteById(long id) {

        Optional.ofNullable(notes.get(id)).ifPresentOrElse(
                n->notes.remove(n.getId()),
                () -> {
                    throw(new NoSuchElementException(String.format("Delete failure."+NOTE_DSNT_EXST, id)));
                });

    }
    //- шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
    void update(Note note){

        Optional.ofNullable(notes.get(note.getId())).ifPresentOrElse(
                n -> {
                    Note noteNew = notes.get(n.getId());
                    noteNew.setContent(n.getContent());
                    noteNew.setTitle(n.getTitle());
                    },
                () -> {
                    throw(new NoSuchElementException(String.format("Update failure."+NOTE_DSNT_EXST, note.getId())));
                });


    }

    //- повертає нотатку по її ідентифікатору. Якщо нотатки немає - викидає виключення.
    Note getById(long id) {
        return Optional.ofNullable(notes.get(id))
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Get failure."+NOTE_DSNT_EXST, id)));
    }
}
