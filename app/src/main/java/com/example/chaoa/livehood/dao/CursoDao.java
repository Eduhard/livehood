package com.example.chaoa.livehood.dao;
import android.content.Context;
import android.widget.Toast;
import com.example.chaoa.livehood.model.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaOa on 10/11/2016.
 */

public class CursoDao {
    private static List<Curso> ListaDeCursos = new ArrayList<Curso>();

    public static void adicionarCurso(Context context, Curso c){
        Banco banco = new Banco(context);
        long id = banco.inserirCurso(c);
        Toast.makeText(context, "Id" + id, Toast.LENGTH_SHORT).show();
    }

    public static List<Curso> retornarCursos(Context context){

        Banco banco = new Banco(context);
        return banco.retornarCursos();
    }

    public static Integer retornarCursoPorNome(Context context,Curso c){

        Banco banco = new Banco(context);
        return banco.retornarCursoPorNome(c);
    }

}