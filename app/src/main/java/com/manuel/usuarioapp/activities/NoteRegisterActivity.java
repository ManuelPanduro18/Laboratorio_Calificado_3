package com.manuel.usuarioapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manuel.usuarioapp.R;
import com.manuel.usuarioapp.models.Note;
import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteRegisterActivity extends AppCompatActivity {
    private EditText ettitulo,etcontenido;
    private Button btnguardar, btnlistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_register);
        setTitle(R.string.register_note);

        ettitulo=findViewById(R.id.etTitulo);
        etcontenido=findViewById(R.id.etContenido);

        btnguardar=findViewById(R.id.btn_guardar);
        btnlistar=findViewById(R.id.btn_listar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        btnlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(NoteRegisterActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }

    public String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd/MM/yyyy hh:mm  a", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void save(){
        String titulo=ettitulo.getText().toString();
        String contenido=etcontenido.getText().toString();
        String fecha=getDate();

        Note note=new Note();
        note.setTitulo(titulo);
        note.setContenido(contenido);
        note.setFecha(fecha);
        SugarRecord.save(note);

        Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(NoteRegisterActivity.this,ListActivity.class);
        startActivity(intent);
    }
}
