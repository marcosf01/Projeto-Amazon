package com.tech4pay.pagamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech4pay.pagamentos.dto.PagamentoDto;
import com.tech4pay.pagamentos.dto.PagamentoDtoComProduto;
import com.tech4pay.pagamentos.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    
    @Autowired
    private PagamentoService service;

    @GetMapping
    public List<PagamentoDto> obterPagamentos() {
        return service.obterTodosOsPagamentos();
    }

    @GetMapping("/{id}")
    public PagamentoDtoComProduto obertPorId(@PathVariable String id) {
        return service.obterPagamentoPorId(id);
    }

    @PostMapping
    public PagamentoDto fazerPagamento(@RequestBody PagamentoDto pagamento) {
        return service.realizarPagamento(pagamento);
    }

    @PutMapping("/{id}")
    public PagamentoDto alterarPagamento(@PathVariable String id, @RequestBody PagamentoDto pagamento) {
        return service.alterarPagamento(id, pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletarPagamento(@PathVariable String id) {
        service.excluirPagamento(id);
    }
}
