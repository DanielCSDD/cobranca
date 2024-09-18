package com.algaworks.cobranca.model.enuns;

public enum StatusTitulo {

    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private final String descricao;

    StatusTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
