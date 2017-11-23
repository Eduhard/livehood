package com.example.chaoa.livehood.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.chaoa.livehood.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class UsuarioDao {

    public static void adicionarUsuario(Context context, Usuario u){
        Banco banco = new Banco(context);
        long id = banco.inserirUsuario(u);
        //Toast.makeText(context, "Id" + id, Toast.LENGTH_SHORT).show();
    }

    public static Usuario retornarUsuarioPorNome(Context context,String usuario){

        Banco banco = new Banco(context);
        return banco.retornarUsuarioPorNome(usuario);
    }
}
