package com.example.chaoa.livehood.model;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class RespostaUsuario {

    private Integer moduloId;
    private Integer exercicioId;
    private Integer respostaId;
    private Integer usuarioId;
    private String acertou;

    public Integer getModuloId() {
        return moduloId;
    }

    public void setModuloId(Integer moduloId) {
        this.moduloId = moduloId;
    }

    public Integer getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Integer exercicioId) {
        this.exercicioId = exercicioId;
    }

    public Integer getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(Integer respostaId) {
        this.respostaId = respostaId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAcertou() {
        return acertou;
    }

    public void setAcertou(String acertou) {
        this.acertou = acertou;
    }
}
