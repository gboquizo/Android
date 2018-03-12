package com.example.guillermo.sopadeletrasexamen;

public class Capital {
    private String capital;
    private int filaInicial;
    private int filaFinal;
    private int columnaInicial;
    private int columnaFinal;

    public Capital(String capital) {
        this.capital = capital;
    }


    public void setFilaInicial(int filaInicial) {
        this.filaInicial = filaInicial;
    }

    public int getFilaInicial(int i) {
        return filaInicial;
    }

    void setFilaFinal(int filaFinal) {
        this.filaFinal = filaFinal;
    }

    public int getFilaFinal() {
        return filaFinal;
    }

    public void setColumnaInicial(int columnaInicial) {
        this.columnaInicial = columnaInicial;
    }

    int getColumnaInicial() {
        return columnaInicial;
    }

    void setColumnaFinal(int columnaFinal) {
        this.columnaFinal = columnaFinal;
    }

    int getColumnaFinal() {
        return columnaFinal;
    }

    String getCapital() {
        return capital;
    }

    int tamanno(){
        return capital.length();
    }

}