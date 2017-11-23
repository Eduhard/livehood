package com.example.chaoa.livehood.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.model.Curso;
import com.example.chaoa.livehood.model.Exercicio;
import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Resposta;
import com.example.chaoa.livehood.model.RespostaUsuario;
import com.example.chaoa.livehood.model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaOa on 27/11/2016.
 */

public class Banco extends SQLiteOpenHelper {

    public static final String NOME_DO_BANCO = "LivehoodDb.db";
    public static final int VERSAO_DO_BANCO = 1; // Versão para controle de atualização

    // Tipos usados no SQL
    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO= " INTEGER";
    public static final String VIRGULA = ", ";

    // ***********  STRING PARA TABELA DE CURSOS
    public static final String SQL_CRIAR_TABELA_CURSO = "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaCurso.NOME_DA_TABELA + " (" +
            Contrato.TabelaCurso.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
            Contrato.TabelaCurso.NOME_DA_COLUNA_NOME + TIPO_TEXTO + "); ";

    public static final String SQL_DELETAR_TABELA_CURSO = "DROP TABLE IF EXISTS " + Contrato.TabelaCurso.NOME_DA_TABELA;


    // ***********  STRING PARA TABELA DE MODULOS
    public static final String SQL_CRIAR_TABELA_MODULO = "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaModulo.NOME_DA_TABELA + " (" +
            Contrato.TabelaModulo.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
            Contrato.TabelaModulo.NOME_DA_COLUNA_NOME + TIPO_TEXTO  + VIRGULA +
            Contrato.TabelaModulo.NOME_DA_COLUNA_CURSO_ID + TIPO_INTEIRO + "); ";

    public static final String SQL_DELETAR_TABELA_MODULO = "DROP TABLE IF EXISTS " + Contrato.TabelaModulo.NOME_DA_TABELA;


    // ***********  STRING PARA TABELA DE EXERCICIOS
    public static final String SQL_CRIAR_TABELA_EXERCICIO = "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaExercicio.NOME_DA_TABELA + " (" +
            Contrato.TabelaExercicio.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
            Contrato.TabelaExercicio.NOME_DA_COLUNA_PERGUNTA + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaExercicio.NOME_DA_COLUNA_MODULO_ID + TIPO_INTEIRO + "); ";

    public static final String SQL_DELETAR_TABELA_EXERCICIO = "DROP TABLE IF EXISTS " + Contrato.TabelaExercicio.NOME_DA_TABELA;



    // ***********  STRING PARA TABELA DE RESPOSTAS
    public static final String SQL_CRIAR_TABELA_RESPOSTA = "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaResposta.NOME_DA_TABELA + " (" +
            Contrato.TabelaResposta.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
            Contrato.TabelaResposta.NOME_DA_COLUNA_RESPOSTA + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaResposta.NOME_DA_COLUNA_CORRETA + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID + TIPO_INTEIRO + "); ";

    public static final String SQL_DELETAR_TABELA_RESPOSTA = "DROP TABLE IF EXISTS " + Contrato.TabelaResposta.NOME_DA_TABELA;


    // ***********  STRING PARA TABELA DE USUARIOS
    public static final String SQL_CRIAR_TABELA_USUARIO = "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaUsuario.NOME_DA_TABELA + " (" +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_USUARIO + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_NOME + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_SENHA + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_EMAIL + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_NASCIMENTO + TIPO_TEXTO + VIRGULA +
            Contrato.TabelaUsuario.NOME_DA_COLUNA_CIDADE + TIPO_TEXTO + "); ";


    public static final String SQL_DELETAR_TABELA_USUARIO = "DROP TABLE IF EXISTS " + Contrato.TabelaUsuario.NOME_DA_TABELA;

    // ***********  STRING PARA TABELA DE RESPOSTASUSUARIOS
    public static final String SQL_CRIAR_TABELA_RESPOSTAUSUARIO = "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaRespostaUsuario.NOME_DA_TABELA + " (" +
            Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_ID + TIPO_INTEIRO + " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
            Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_MODULO_ID + TIPO_INTEIRO + VIRGULA +
            Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_EXERCICIO_ID + TIPO_INTEIRO + VIRGULA +
            Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_RESPOSTA_ID + TIPO_INTEIRO + VIRGULA +
            Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_USUARIO_ID + TIPO_INTEIRO + VIRGULA +
            Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_ACERTOU + TIPO_TEXTO + "); ";


    public static final String SQL_DELETAR_TABELA_RESPOSTAUSUARIO = "DROP TABLE IF EXISTS " + Contrato.TabelaRespostaUsuario.NOME_DA_TABELA;


    public Banco(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_DO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("Criar Branco", SQL_CRIAR_TABELA_CURSO);
        db.execSQL(SQL_CRIAR_TABELA_CURSO);
        Log.v("Criar Branco", SQL_CRIAR_TABELA_MODULO);
        db.execSQL(SQL_CRIAR_TABELA_MODULO);
        Log.v("Criar Branco", SQL_CRIAR_TABELA_EXERCICIO);
        db.execSQL(SQL_CRIAR_TABELA_EXERCICIO);
        Log.v("Criar Branco", SQL_CRIAR_TABELA_RESPOSTA);
        db.execSQL(SQL_CRIAR_TABELA_RESPOSTA);
        Log.v("Criar Branco", SQL_CRIAR_TABELA_USUARIO);
        db.execSQL(SQL_CRIAR_TABELA_USUARIO);
        Log.v("Criar Branco", SQL_CRIAR_TABELA_RESPOSTAUSUARIO);
        db.execSQL(SQL_CRIAR_TABELA_RESPOSTAUSUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Log.v("Atualizar banco", SQL_DELETAR_TABELA_CURSO);
        db.execSQL(SQL_DELETAR_TABELA_CURSO);
        db.execSQL(SQL_DELETAR_TABELA_MODULO);
        db.execSQL(SQL_DELETAR_TABELA_EXERCICIO);
        db.execSQL(SQL_DELETAR_TABELA_RESPOSTA);
        db.execSQL(SQL_DELETAR_TABELA_USUARIO);
        db.execSQL(SQL_DELETAR_TABELA_RESPOSTAUSUARIO);
    }

    //************************************************************//
    //                   C U R S O S                              //
    //************************************************************//
    public long inserirCurso(Curso c){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaCurso.NOME_DA_COLUNA_NOME, c.getNome());;

        return banco.insert(Contrato.TabelaCurso.NOME_DA_TABELA, null, registro);
    }

    public List<Curso> retornarCursos() {
        SQLiteDatabase banco = getWritableDatabase();
        List<Curso> cursos = new ArrayList<Curso>();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaCurso.NOME_DA_COLUNA_ID,
                Contrato.TabelaCurso.NOME_DA_COLUNA_NOME,
        };

        Cursor cursor = banco.query(
                Contrato.TabelaCurso.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                null,                                  // The columns for the WHERE clause
                null,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        do {
            Curso c = new Curso();
            c.setNome(cursor.getString(1));
            cursos.add(c);
        } while (cursor.moveToNext());

        return cursos;
    }

    public Integer retornarCursoPorNome(Curso c) {
        SQLiteDatabase banco = getWritableDatabase();
        List<Curso> cursos = new ArrayList<Curso>();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaCurso.NOME_DA_COLUNA_ID,
                Contrato.TabelaCurso.NOME_DA_COLUNA_NOME,
        };

        String selection = Contrato.TabelaCurso.NOME_DA_COLUNA_NOME + " = ?";
        String[] selectionArgs = { c.getNome() };

        Cursor cursor = banco.query(
                Contrato.TabelaCurso.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        // Retorno o primeiro ID de curso que encontrei
        Integer idCurso = Integer.valueOf(cursor.getInt(0));


        return idCurso;
    }


    //****************** M O D U L O S *****************************
    public long inserirModulo(Context context, Modulo m, Curso c){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaModulo.NOME_DA_COLUNA_NOME, m.getNome());
        // Busco o id do curso para registrar o vinculo
        Integer idCurso = CursoDao.retornarCursoPorNome(context, c );
        //Toast.makeText(context, "ID Curso retornado:" + idCurso, Toast.LENGTH_SHORT).show();
        registro.put(Contrato.TabelaModulo.NOME_DA_COLUNA_CURSO_ID, idCurso);

        return banco.insert(Contrato.TabelaModulo.NOME_DA_TABELA, null, registro);
    }

    public List<Modulo> retornarModulos(Context context, String cursoSelecionado) {
        SQLiteDatabase banco = getWritableDatabase();
        List<Modulo> modulos = new ArrayList<Modulo>();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaModulo.NOME_DA_COLUNA_ID,
                Contrato.TabelaModulo.NOME_DA_COLUNA_NOME,
                Contrato.TabelaModulo.NOME_DA_COLUNA_CURSO_ID,
        };

        //pega o id do curso
        Curso curso = new Curso();
        curso.setNome(cursoSelecionado);
        Integer idCurso = CursoDao.retornarCursoPorNome(context,curso);


        String selection = Contrato.TabelaModulo.NOME_DA_COLUNA_CURSO_ID + " = ?";
        String[] selectionArgs = { idCurso.toString() };

        Cursor cursor = banco.query(
                Contrato.TabelaModulo.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                             // The columns for the WHERE clause
                selectionArgs,                         // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        do {
            Modulo m = new Modulo();
            m.setNome(cursor.getString(1));
            m.setCursoId(cursor.getInt(2));
            modulos.add(m);
        } while (cursor.moveToNext());

        return modulos;
    }

    public Integer retornarModuloPorNome(Modulo m) {
        SQLiteDatabase banco = getWritableDatabase();
        List<Modulo> modulos = new ArrayList<Modulo>();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaModulo.NOME_DA_COLUNA_ID,
                Contrato.TabelaModulo.NOME_DA_COLUNA_NOME,
        };

        String selection = Contrato.TabelaModulo.NOME_DA_COLUNA_NOME + " = ?";
        String[] selectionArgs = { m.getNome() };

        Cursor cursor = banco.query(
                Contrato.TabelaModulo.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        // Retorno o primeiro ID de modulo que encontrei
        Integer idModulo = Integer.valueOf(cursor.getInt(0));


        return idModulo;
    }



    //************************************************************//
    //                   E X E R C I C I O S                      //
    //************************************************************//
    public long inserirExercicio(Context context, Exercicio e, Modulo m ){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaExercicio.NOME_DA_COLUNA_PERGUNTA, e.getPergunta());

        Integer idModulo = ModuloDao.retornarModuloPorNome(context, m );
        Toast.makeText(context, "idModulo retornado: " + idModulo, Toast.LENGTH_SHORT).show();
        registro.put(Contrato.TabelaExercicio.NOME_DA_COLUNA_MODULO_ID, idModulo);

        return banco.insert(Contrato.TabelaExercicio.NOME_DA_TABELA, null, registro);
    }

    public List<Exercicio> retornarExercicio( Modulo m, Usuario u) {
        SQLiteDatabase banco = getWritableDatabase();
        List<Exercicio> exercicios = new ArrayList<Exercicio>();

        String rawQuery = "SELECT * FROM " + Contrato.TabelaExercicio.NOME_DA_TABELA
                + " WHERE NOT EXISTS ( SELECT * FROM "+ Contrato.TabelaRespostaUsuario.NOME_DA_TABELA
                + " WHERE " + Contrato.TabelaExercicio.NOME_DA_COLUNA_ID + " = " + Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_EXERCICIO_ID
                + " AND " + Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_USUARIO_ID + " = " + u.getId() +" )"
                + " AND " + Contrato.TabelaExercicio.NOME_DA_COLUNA_MODULO_ID + " = "+ m.getId()+ ";" ;

        Log.v("String SQL", rawQuery);

        Cursor cursor = banco.rawQuery(
                rawQuery,
                null
        );

        cursor.moveToFirst();

        if(cursor!=null && cursor.getCount()!=0) {
            do {
                Exercicio exercicio = new Exercicio();
                exercicio.setId(cursor.getInt(1));
                exercicio.setPergunta(cursor.getString(1));
                exercicio.setModuloId(cursor.getInt(2));
                exercicios.add(exercicio);
            } while (cursor.moveToNext());
        }

        return exercicios;
    }

    public Integer retornarExercicioPorPergunta(Exercicio e) {
        SQLiteDatabase banco = getWritableDatabase();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaExercicio.NOME_DA_COLUNA_ID,
                Contrato.TabelaExercicio.NOME_DA_COLUNA_PERGUNTA,
                Contrato.TabelaExercicio.NOME_DA_COLUNA_MODULO_ID,
        };

        String selection = Contrato.TabelaExercicio.NOME_DA_COLUNA_PERGUNTA + " = ?";
        String[] selectionArgs = { e.getPergunta() };

        Cursor cursor = banco.query(
                Contrato.TabelaExercicio.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        // Retorno o primeiro ID de exercicio que encontrei
        Integer idExercicio = Integer.valueOf(cursor.getInt(0));


        return idExercicio;
    }

    public Exercicio retornarExercicioPorExercicioId(Integer exercicioId) {

        Exercicio exercicio = new Exercicio();

        SQLiteDatabase banco = getWritableDatabase();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaExercicio.NOME_DA_COLUNA_ID,
                Contrato.TabelaExercicio.NOME_DA_COLUNA_PERGUNTA,
                Contrato.TabelaExercicio.NOME_DA_COLUNA_MODULO_ID,
        };

        String selection = Contrato.TabelaExercicio.NOME_DA_COLUNA_ID + " = ?";
        String[] selectionArgs = { exercicioId.toString() };

        Cursor cursor = banco.query(
                Contrato.TabelaExercicio.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        // Retorno o primeiro ID de exercicio que encontrei
        exercicio.setPergunta(cursor.getString(1));
        exercicio.setModuloId(cursor.getInt(2));

        return exercicio;

    }


    //************************************************************//
    //                   R E S P O S T A S                        //
    //************************************************************//
    public long inserirResposta(Context context, Resposta r, Exercicio e ){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaResposta.NOME_DA_COLUNA_RESPOSTA, r.getResposta());
        registro.put(Contrato.TabelaResposta.NOME_DA_COLUNA_CORRETA, r.getCorreta());

        Integer idExercicio = ExercicioDao.retornarExercicioPorPergunta(context, e );
        Toast.makeText(context, "idExercicio retornado: " + idExercicio, Toast.LENGTH_SHORT).show();
        registro.put(Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID, idExercicio);

        return banco.insert(Contrato.TabelaResposta.NOME_DA_TABELA, null, registro);
    }

    public List<Resposta> retornarRespostas(Integer idExercicio) {
        SQLiteDatabase banco = getWritableDatabase();
        List<Resposta> respostas = new ArrayList<Resposta>();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaResposta.NOME_DA_COLUNA_ID,
                Contrato.TabelaResposta.NOME_DA_COLUNA_RESPOSTA,
                Contrato.TabelaResposta.NOME_DA_COLUNA_CORRETA,
                Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID,
        };

        String selection = Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID + " = ?";
        String[] selectionArgs = { idExercicio.toString() };

        Cursor cursor = banco.query(
                Contrato.TabelaResposta.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        do {
            Resposta r = new Resposta();
            r.setResposta(cursor.getString(1));
            r.setCorreta(cursor.getString(2));
            r.setExercicioId(cursor.getInt(3));
            respostas.add(r);
        } while (cursor.moveToNext());

        return respostas;
    }


    public Resposta retornaRespostaCorreta(Resposta r) {
        SQLiteDatabase banco = getWritableDatabase();
        Resposta correta = new Resposta();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaResposta.NOME_DA_COLUNA_ID,
                Contrato.TabelaResposta.NOME_DA_COLUNA_RESPOSTA,
                Contrato.TabelaResposta.NOME_DA_COLUNA_CORRETA,
                Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID,
        };

        String selection = Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID + " = ?" + " AND " +
                Contrato.TabelaResposta.NOME_DA_COLUNA_CORRETA + "= ?";
        String[] selectionArgs = { r.getExercicioId().toString(),"S" };

        Cursor cursor = banco.query(
                Contrato.TabelaResposta.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        if(cursor!=null && cursor.getCount()!=0) {
            correta.setResposta(cursor.getString(1));
            correta.setCorreta(cursor.getString(2));
            correta.setExercicioId(cursor.getInt(3));
        }

        return correta;
    }

    public Resposta retornarRespostaPorResposta(Resposta r) {

        SQLiteDatabase banco = getWritableDatabase();
        Resposta respostaUsuario = new Resposta();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaResposta.NOME_DA_COLUNA_ID,
                Contrato.TabelaResposta.NOME_DA_COLUNA_RESPOSTA,
                Contrato.TabelaResposta.NOME_DA_COLUNA_CORRETA,
                Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID,
        };

        String selection = Contrato.TabelaResposta.NOME_DA_COLUNA_EXERCICIO_ID + " = ?" + " AND " +
                Contrato.TabelaResposta.NOME_DA_COLUNA_RESPOSTA + "= ?";
        String[] selectionArgs = { r.getExercicioId().toString(),r.getResposta() };

        Cursor cursor = banco.query(
                Contrato.TabelaResposta.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();

        if(cursor!=null && cursor.getCount()!=0) {
            respostaUsuario.setId(cursor.getInt(0));
            respostaUsuario.setResposta(cursor.getString(1));
            respostaUsuario.setCorreta(cursor.getString(2));
            respostaUsuario.setExercicioId(cursor.getInt(3));
        }


        return respostaUsuario;

    }

    //************************************************************//
    //                   U S U A R I O S                          //
    //************************************************************//
    public long inserirUsuario(Usuario u){
        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaUsuario.NOME_DA_COLUNA_USUARIO, u.getUsuario());;
        registro.put(Contrato.TabelaUsuario.NOME_DA_COLUNA_NOME, u.getNome());;
        registro.put(Contrato.TabelaUsuario.NOME_DA_COLUNA_SENHA, u.getSenha());;
        registro.put(Contrato.TabelaUsuario.NOME_DA_COLUNA_EMAIL, u.getEmail());;
        registro.put(Contrato.TabelaUsuario.NOME_DA_COLUNA_NASCIMENTO, u.getNascimento());;
        registro.put(Contrato.TabelaUsuario.NOME_DA_COLUNA_CIDADE, u.getCidade());;

        return banco.insert(Contrato.TabelaUsuario.NOME_DA_TABELA, null, registro);
    }

    public Usuario retornarUsuarioPorNome(String usuario) {
        SQLiteDatabase banco = getWritableDatabase();
        Usuario u = new Usuario();

        //Colunas que quero retornar do banco
        String[] colunas = new String[]{
                Contrato.TabelaUsuario.NOME_DA_COLUNA_ID,
                Contrato.TabelaUsuario.NOME_DA_COLUNA_NOME,
                Contrato.TabelaUsuario.NOME_DA_COLUNA_USUARIO,
                Contrato.TabelaUsuario.NOME_DA_COLUNA_SENHA,
                Contrato.TabelaUsuario.NOME_DA_COLUNA_EMAIL,
                Contrato.TabelaUsuario.NOME_DA_COLUNA_NASCIMENTO,
                Contrato.TabelaUsuario.NOME_DA_COLUNA_CIDADE,
        };

        String selection = Contrato.TabelaUsuario.NOME_DA_COLUNA_USUARIO + " = ?";
        String[] selectionArgs = { usuario };

        Cursor cursor = banco.query(
                Contrato.TabelaUsuario.NOME_DA_TABELA,  // The table to query
                colunas,                               // The columns to return
                selection,                                  // The columns for the WHERE clause
                selectionArgs,                                  // The values for the WHERE clause
                null, null, null);

        cursor.moveToFirst();


        if(cursor!=null && cursor.getCount()!=0){
            u.setId(cursor.getInt(0));
            u.setNome(cursor.getString(1));
            u.setUsuario(cursor.getString(2));
            u.setSenha(cursor.getString(3));
            u.setEmail(cursor.getString(4));
            u.setNascimento(cursor.getString(5));
            u.setCidade(cursor.getString(6));
        }

        return u;
    }

    //************************************************************//
    //            R E S P O S T A S  x  U S U A R I O S           //
    //************************************************************//
    public long inserirRespostaUsuario(Resposta r, Usuario u, Modulo m) {


        SQLiteDatabase banco = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put(Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_EXERCICIO_ID, r.getExercicioId());
        registro.put(Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_MODULO_ID, m.getId());
        registro.put(Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_RESPOSTA_ID, r.getId());
        registro.put(Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_USUARIO_ID,u.getId() );
        registro.put(Contrato.TabelaRespostaUsuario.NOME_DA_COLUNA_ACERTOU,r.getCorreta() );

        return banco.insert(Contrato.TabelaRespostaUsuario.NOME_DA_TABELA, null, registro);


    }

}