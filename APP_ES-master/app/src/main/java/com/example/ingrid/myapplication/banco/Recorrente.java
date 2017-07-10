package com.example.ingrid.myapplication.banco;
import java.sql.Time;
import java.util.Date;
/**
 * Created by ingrid on 03/11/16.
 */
public class Recorrente {
    private int id;
    private String nome;
    private String anotacao, local;
    private Time horaFinal;
    private float progressao;
    private int totalItens, itensFeitos, horasDia, prioridade;
    private Usuario userID;
    private int faltas;
    private Date dataFinal;

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public float getProgressao() {
        return progressao;
    }

    public void setProgressao(float progressao) {
        this.progressao = progressao;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public void setTotalItens(int totalItens) {
        this.totalItens = totalItens;
    }

    public int getItensFeitos() {
        return itensFeitos;
    }

    public void setItensFeitos(int itensFeitos) {
        this.itensFeitos = itensFeitos;
    }

    public int getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(int horasDia) {
        this.horasDia = horasDia;
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

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
