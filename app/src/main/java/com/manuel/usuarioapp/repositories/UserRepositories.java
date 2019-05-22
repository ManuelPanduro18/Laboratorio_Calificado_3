package com.manuel.usuarioapp.repositories;

import com.manuel.usuarioapp.models.Usuario;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepositories {
    public static void create(String nombres, String usuario, String password) {

        Usuario usuarios = new Usuario();
        usuarios.setNombres(nombres);
        usuarios.setUsuario(usuario);
        usuarios.setPassword(password);

        SugarRecord.save(usuarios);
    }

    public static Usuario login(String usuario, String password){

        List<Usuario> usuarios = SugarRecord.find(Usuario.class,
                "usuario=? and password=?", usuario, password);

        if(!usuarios.isEmpty()){
            return usuarios.get(0);
        }
        return null;
    }

    public static Usuario load (Long id){
        Usuario user = SugarRecord.findById(Usuario.class,id);
        return user;
    }
}
