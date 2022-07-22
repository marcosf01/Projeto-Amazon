package com.amazom.ecommerce.service;

import java.util.List;

import com.amazom.ecommerce.dto.ProdutoDto;

public interface ProdutoService {
    List<ProdutoDto> obterTodosOsProdutos();
    ProdutoDto obterPorId(String id);
    ProdutoDto obterPorCodigo(Integer codigo);
    ProdutoDto cadastrarProdutos(ProdutoDto produto);
    void excluirProduto(String id);
    ProdutoDto alterarProduto(String id, ProdutoDto produto);
}
