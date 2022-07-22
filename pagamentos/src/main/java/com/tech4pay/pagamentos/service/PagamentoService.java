package com.tech4pay.pagamentos.service;

import java.util.List;

import com.tech4pay.pagamentos.dto.PagamentoDto;
import com.tech4pay.pagamentos.dto.PagamentoDtoComProduto;

public interface PagamentoService {
    List<PagamentoDto> obterTodosOsPagamentos();
    PagamentoDtoComProduto obterPagamentoPorId(String id);
    PagamentoDto realizarPagamento(PagamentoDto pagamento);
    PagamentoDto alterarPagamento(String id, PagamentoDto pagamento);
    void excluirPagamento(String id);
}
