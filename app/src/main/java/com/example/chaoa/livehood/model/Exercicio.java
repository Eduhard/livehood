package com.example.chaoa.livehood.model;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class Exercicio {

    private Integer id;
    private String pergunta;
    private Integer moduloId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Integer getModuloId() {
        return moduloId;
    }

    public void setModuloId(Integer moduloId) {
        this.moduloId = moduloId;
    }
}
