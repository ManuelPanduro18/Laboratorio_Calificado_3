package com.manuel.usuarioapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.manuel.usuarioapp.R;
import com.manuel.usuarioapp.models.Note;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listaTodo;
    private Button btnconsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle(R.string.title_list);

        listaTodo=findViewById(R.id.LVMostrar);
        btnconsultar=findViewById(R.id.btn_consultar);

        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar();
            }
        });
    }
    private void listar(){
        List<Note> notes=Note.listAll(Note.class);
        ArrayList<String> lista1=new ArrayList<String>();
        for(int i=0;i<notes.size();i++){
            Note not=notes.get(i);
            lista1.add("Fecha: "+not.getFecha()+"\nTitulo: "+not.getTitulo()+"\nContenido: "+not.getContenido());

        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista1);
        listaTodo.setAdapter(adapter);

    }
}
