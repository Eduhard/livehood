package com.example.chaoa.livehood.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.chaoa.livehood.model.Exercicio;
import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Resposta;
import com.example.chaoa.livehood.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class ExercicioDao {

    private static List<Exercicio> ListaDeCursos = new ArrayList<Exercicio>();

    public static void adicionarExercicio(Context context, Exercicio e,Modulo m){
        Banco banco = new Banco(context);
        long id = banco.inserirExercicio(context,e, m);
        Toast.makeText(context, "Exercicio Id: " + id, Toast.LENGTH_SHORT).show();
    }

    public static List<Exercicio> retornarExercicio(Context context, Modulo m, Usuario u){

        Banco banco = new Banco(context);
        return banco.retornarExercicio(m, u );
    }

    public static Integer retornarExercicioPorPergunta(Context context,Exercicio e){

        Banco banco = new Banco(context);
        return banco.retornarExercicioPorPergunta(e);
    }

    public static boolean validarResposta(Context context, Resposta r) {
        boolean retornoResposta;
        Banco banco = new Banco(context);
        Resposta correta = banco.retornaRespostaCorreta(r);
        if (correta.getResposta().equals(r.getResposta())){
            retornoResposta = true;
        }
        else{
            retornoResposta = false;
        }

        return retornoResposta;
    }

    public static Exercicio retornarExercicioPorId(Context context,Integer exercicioId) {
        Banco banco = new Banco(context);
        return banco.retornarExercicioPorExercicioId(exercicioId);
    }
}
