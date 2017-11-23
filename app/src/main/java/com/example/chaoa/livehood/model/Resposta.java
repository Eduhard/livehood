package com.example.chaoa.livehood.model;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class Resposta {
    private Integer id;
    private Integer exercicioId;
    private String resposta;
    private String correta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(Integer exercicioId) {
        this.exercicioId = exercicioId;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }
}
