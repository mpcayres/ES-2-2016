package com.example.ingrid.myapplication.banco;
import java.sql.Time;

/**
 * Created by ingrid on 03/11/16.
 */
public class Periodico {
    private int id;
    private String nome;
    private String anotacao;
    private Time horaFinal, horaInicial;
    private int repeticao;
    private String local;
    private int prioridade;
    private String frequencia;
    private int faltas;
    private Usuario userID;
    private int segunda, terca, quarta, quinta, sexta, sabado, domingo;

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

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
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

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Usuario getUserID() {
        return userID;
    }

    public void setUserID(Usuario userID) {
        this.userID = userID;
    }

    public int getSegunda() {return segunda;  }

    public void setSegunda(int segunda) {this.segunda = segunda; }

    public int getTerca() {return terca;  }

    public void setTerca(int terca) {this.terca = terca; }

    public int getQuarta() {return quarta;  }

    public void setQuarta(int quarta) {this.quarta = quarta; }

    public int getQuinta() {return quinta;  }

    public void setQuinta(int quinta) {this.quinta = quinta; }

    public int getSexta() {return sexta;  }

    public void setSexta(int sexta) {this.sexta = sexta; }

    public int getSabado() {return sabado;  }

    public void setSabado(int sabado) {this.sabado= sabado; }

    public int getDomingo() {return domingo;  }

    public void setDomingo (int domingo) {this.domingo= domingo; }

}
