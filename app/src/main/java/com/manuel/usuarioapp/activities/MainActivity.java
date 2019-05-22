package com.manuel.usuarioapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manuel.usuarioapp.R;
import com.manuel.usuarioapp.models.Usuario;
import com.manuel.usuarioapp.repositories.UserRepositories;

public class MainActivity extends AppCompatActivity {
    private EditText edtpassword,edtusuario;
    private Button btnregister,btningresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusuario=findViewById(R.id.edt_usuario);
        edtpassword=findViewById(R.id.edt_password);

        btnregister=findViewById(R.id.btn_rgister);
        btningresar=findViewById(R.id.btn_ingresar);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });

        verifySession();
    }
    private void ingresar() {
        String usuario = edtusuario.getText().toString();
        String password = edtpassword.getText().toString();

        //usuarios=SugarRecord.findWithQuery(Usuario.class,"Select usuario, password from Usuario where usuario='"+usuario+"' and password='"+password+"'",null);

        //SugarRecord.find(Usuario.class,"usuario='"+usuario+"'and password='"+password+"'",null);

        if(usuario.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuarios= UserRepositories.login(usuario,password);

        if(usuarios==null){
            Toast.makeText(this, "Email y/o password inválido", Toast.LENGTH_SHORT).show();
            return;
        }


        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean success = sp.edit().putString("Usuario",usuario).
                putLong("id",usuarios.getId()).
                putBoolean("idlogged",true).
                commit();

        goMain();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    private void verifySession(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if(sp.getBoolean("islogged",false)){
            goMain();
        }
    }

    private void goMain(){
        startActivity(new Intent(this, HomeActivity.class));
        finish();

    }



}
