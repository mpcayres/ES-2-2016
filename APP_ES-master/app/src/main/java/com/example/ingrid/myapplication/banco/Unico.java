package com.example.ingrid.myapplication.banco;
import java.sql.Time;
import java.util.Date;

/**
 * Created by ingrid on 03/11/16.
 */
public class Unico {
    private int id;
    private String nome;
    private String anotacao;
    private Time horaFinal, horaInicial;
    private Date data;
    private String local;
    private int prioridade;
    private Usuario userID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Time getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Usuario getUserID() {
        return userID;
    }

    public void setUserID(Usuario userID) {
        this.userID = userID;
    }
}
