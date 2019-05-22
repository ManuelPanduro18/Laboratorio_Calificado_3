package com.manuel.usuarioapp.repositories;

import com.manuel.usuarioapp.models.Note;
import com.manuel.usuarioapp.models.Usuario;
import com.orm.SugarRecord;

public class NoteRepositories {
    public static void create(String titulo, String contenido, String fecha) {

        Note note=new Note();
        note.setTitulo(titulo);
        note.setContenido(contenido);
        note.setFecha(fecha);

        SugarRecord.save(note);
    }


}
