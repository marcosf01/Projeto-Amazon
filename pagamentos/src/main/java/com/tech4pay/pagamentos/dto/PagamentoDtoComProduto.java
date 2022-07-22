package com.tech4pay.pagamentos.dto;

import com.tech4pay.pagamentos.client.Produto;

public class PagamentoDtoComProduto extends PagamentoDto {
    private Produto produtoDetalhes;

    public Produto getProdutoDetalhes() {
        return produtoDetalhes;
    }

    public void setProdutoDetalhes(Produto produtoDetalhes) {
        this.produtoDetalhes = produtoDetalhes;
    }

    
}
