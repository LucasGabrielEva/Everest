package com.exampl.Everest.model;

public enum Estoque {
    Contem ("contem"),
    NaoContem ("não contem");   

    private String Estoque;

    Estoque(String estoque) {
        this.Estoque = estoque;
    }

    public String getEstoque() {
        return Estoque;
    }
    
    
}
