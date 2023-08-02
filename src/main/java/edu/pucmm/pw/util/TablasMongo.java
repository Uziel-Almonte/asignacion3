package edu.pucmm.pw.util;

public enum TablasMongo {
    ESTUDIANTES("estudiantes");

    private String valor;

    TablasMongo(String valor){
        this.valor =  valor;
    }

    public String getValor() {
        return valor;
    }
}
