package com.example.chaoa.livehood.dao;

import android.content.Context;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.model.Exercicio;
import com.example.chaoa.livehood.model.Resposta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class RespostaDao {
    private static List<Resposta> ListaDeRespostas = new ArrayList<Resposta>();

    public static void adicionarResposta(Context context, Resposta r, Exercicio e){
        Banco banco = new Banco(context);
        long id = banco.inserirResposta(context,r,e);
        Toast.makeText(context, "Resposta Id: " + id, Toast.LENGTH_SHORT).show();
    }

    public static List<Resposta> retornarRespostas(Context context, Integer idExercicio){

        Banco banco = new Banco(context);
        return banco.retornarRespostas(idExercicio);
    }

    public static Resposta retornarRespostaPorResposta(Context context,Resposta r){

        Banco banco = new Banco(context);
        return banco.retornarRespostaPorResposta(r);
    }

}
