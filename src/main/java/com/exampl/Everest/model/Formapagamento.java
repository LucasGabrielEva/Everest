package com.exampl.Everest.model;

public enum Formapagamento {
    CartaoCredito ("Cartão de Crédito"),
    CartaoDebito ("Cartão de Débito"),
    Pix ("Pix");

    private String formaPagamento;

    Formapagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
