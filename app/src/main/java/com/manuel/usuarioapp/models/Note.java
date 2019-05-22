package com.manuel.usuarioapp.models;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Note  extends SugarRecord {
    private Long id;
    private String titulo;
    private String contenido;
    private String fecha;

    public Note() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
