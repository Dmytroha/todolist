package com.goit.todolist.servicies;

import com.goit.todolist.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;


@Service
public class NoteService {
    private final Map<Long, Note> notes;
    private final Random randomId=new Random();
    public static final String NOTE_DSNT_EXST="Note with id - %s doesn't exist!";

    public NoteService() {
        notes = new HashMap<>();
    }


    //- повертає список всіх нотаток
    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }



    //- додає нову нотатку, генеруючи для цієї нотатки унікальний (випадковий) числовий ідентифікатор, повертає цю ж нотатку зі згенерованим ідентифікатором.
    public Note add(Note note){
        Long id = generateNoteId();
        note.setId(id);
        notes.put(note.getId(), note);
        return note;
    }

    //- видаляє нотатку з вказаним ідентифікатором. Якщо нотатки з ідентифікатором немає - викидає виключення.
    public void deleteById(long id) {

        Optional.ofNullable(notes.get(id)).ifPresentOrElse(
                n->notes.remove(n.getId()),
                () -> {
                    throw(new NoSuchElementException(String.format("Delete failure."+NOTE_DSNT_EXST, id)));
                });

    }
    //- шукає нотатку по note.id. Якщо нотатка є - оновлює для неї title та content. Якщо нотатки немає - викидає виключення.
    public void update(Note note){

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
    public Note getById(long id) {
        return Optional.ofNullable(notes.get(id))
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Get failure."+NOTE_DSNT_EXST, id)));
    }

    public long generateNoteId() {
        Long newId;
        do {

            newId = randomId.nextLong();
        } while (newId <= 0 || notes.containsKey(newId));
        return newId;
    }
}
