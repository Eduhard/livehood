package com.example.chaoa.livehood.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Resposta;
import com.example.chaoa.livehood.model.Usuario;

import java.util.List;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class RespostaUsuarioDao {

    public static void adicionarRespostaUsuario(Context context, Resposta r, Usuario u, Modulo m){
        Banco banco = new Banco(context);
        long id = banco.inserirRespostaUsuario(r, u, m);
        //Toast.makeText(context, "Id" + id, Toast.LENGTH_SHORT).show();
    }

}
