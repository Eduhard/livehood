package com.example.chaoa.livehood.dao;

import android.provider.BaseColumns;
/**
 * Created by ChaOa on 22/11/2016.
 */

public final class Contrato {

    public static abstract class TabelaCurso implements BaseColumns {
        public static final String NOME_DA_TABELA = "TableCurso";
        public static final String NOME_DA_COLUNA_ID = "CursoId";
        public static final String NOME_DA_COLUNA_NOME = "CursoNome";
    }

    public static abstract class TabelaModulo implements BaseColumns {
        public static final String NOME_DA_TABELA = "TableModulo";
        public static final String NOME_DA_COLUNA_ID = "ModuloId";
        public static final String NOME_DA_COLUNA_NOME = "ModuloNome";
        public static final String NOME_DA_COLUNA_CURSO_ID = "ModuloCurso";
    }

    public static abstract class TabelaExercicio implements BaseColumns {
        public static final String NOME_DA_TABELA = "TableExercicio";
        public static final String NOME_DA_COLUNA_ID = "ExercicioId";
        public static final String NOME_DA_COLUNA_PERGUNTA = "ExercicioPergunta";
        public static final String NOME_DA_COLUNA_MODULO_ID = "ExercicioModulo";
    }

    public static abstract class TabelaResposta implements BaseColumns {
        public static final String NOME_DA_TABELA = "TableResposta";
        public static final String NOME_DA_COLUNA_ID = "RespostaId";
        public static final String NOME_DA_COLUNA_EXERCICIO_ID = "RespostaExercicio";
        public static final String NOME_DA_COLUNA_RESPOSTA = "RespostaResposta";
        public static final String NOME_DA_COLUNA_CORRETA = "RespostaCorreta";
    }

    public static abstract class TabelaUsuario implements BaseColumns {
        public static final String NOME_DA_TABELA = "TableUsuario";
        public static final String NOME_DA_COLUNA_ID = "UsuarioId";
        public static final String NOME_DA_COLUNA_USUARIO = "UsuarioUsuario";
        public static final String NOME_DA_COLUNA_NOME = "UsuarioNome";
        public static final String NOME_DA_COLUNA_SENHA = "UsuarioSenha";
        public static final String NOME_DA_COLUNA_EMAIL = "UsuarioEmail";
        public static final String NOME_DA_COLUNA_NASCIMENTO = "UsuarioNascimento";
        public static final String NOME_DA_COLUNA_CIDADE = "UsuarioCidade";
    }

    public static abstract class TabelaRespostaUsuario implements BaseColumns {
        public static final String NOME_DA_TABELA = "TableRespostaUsuario";
        public static final String NOME_DA_COLUNA_ID = "RespostaUsuarioId";
        public static final String NOME_DA_COLUNA_MODULO_ID = "RespostaUsuarioModuloId";
        public static final String NOME_DA_COLUNA_EXERCICIO_ID = "RespostaUsuarioExercicioId";
        public static final String NOME_DA_COLUNA_RESPOSTA_ID = "RespostaUsuarioRespostaId";
        public static final String NOME_DA_COLUNA_USUARIO_ID = "RespostaUsuarioUsuarioId";
        public static final String NOME_DA_COLUNA_ACERTOU = "RespostaUsuarioAcertou";
    }
}
