package com.example.chaoa.livehood.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.chaoa.livehood.model.Curso;
import com.example.chaoa.livehood.model.Modulo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaOa on 29/11/2016.
 */

public class ModuloDao {
    private static List<Modulo> ListaDeCursos = new ArrayList<Modulo>();

    public static void adicionarModulo(Context context, Modulo m, Curso c){
        Banco banco = new Banco(context);
        long id = banco.inserirModulo(context,m,c);
        Toast.makeText(context, "Modulo Id: " + id, Toast.LENGTH_SHORT).show();
    }

    public static List<Modulo> retornarModulos(Context context, String curso){

        Banco banco = new Banco(context);
        return banco.retornarModulos(context, curso);
    }

    public static Integer retornarModuloPorNome(Context context,Modulo m){

        Banco banco = new Banco(context);
        return banco.retornarModuloPorNome(m);
    }
}
