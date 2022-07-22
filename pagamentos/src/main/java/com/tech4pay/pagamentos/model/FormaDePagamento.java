package com.tech4pay.pagamentos.model;

public enum FormaDePagamento {
    DINHEIRO("dinheiro", ""),
    VISA_DEBITO("Cartão de débito", "Visa"),
    VISA_CREDITO("Cartão de crédito", "Visa"),
    MASTER_DEBITO("Cartão de débito", "Master"),
    MASTER_CREDITO("Cartão de crédito", "Master"),
    AMEX("Cartão de crédito", "American Express"),
    PIX("Pix", ""),
    TRANSFERENCIA("Transferência", "");

    String descricao;
    String bandeira;

    private FormaDePagamento(String descricao, String bandeira) {
        this.descricao = descricao;
        this.bandeira = bandeira;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getBandeira() {
        return bandeira;
    }

    
}
