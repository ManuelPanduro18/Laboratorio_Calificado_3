package com.manuel.usuarioapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manuel.usuarioapp.R;
import com.manuel.usuarioapp.models.Usuario;
import com.orm.SugarRecord;

public class RegisterActivity extends AppCompatActivity {
    private EditText etusuario,etnombre,etemail,etpaswword;
    private Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etusuario=findViewById(R.id.etUsuario);
        etnombre=findViewById(R.id.etNombres);
        etemail=findViewById(R.id.etEmail);
        etpaswword=findViewById(R.id.etPassword);

        btnguardar=findViewById(R.id.btnGuardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }
    private void save(){

        try {
            String usuario=etusuario.getText().toString();
            String nombres=etnombre.getText().toString();
            String email=etemail.getText().toString();
            String password=etpaswword.getText().toString();

            Usuario usuarios=new Usuario();
            usuarios.setUsuario(usuario);
            usuarios.setNombres(nombres);
            usuarios.setEmail(email);
            usuarios.setPassword(password);
            SugarRecord.save(usuarios);

            Toast.makeText(this, "Registro satisfactorio", Toast.LENGTH_SHORT).show();

            finish();
        }catch (Exception e){
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
