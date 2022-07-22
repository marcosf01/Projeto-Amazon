package com.amazom.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import com.amazom.ecommerce.dto.ProdutoDto;
import com.amazom.ecommerce.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoDto> obterProdutos() {
        return service.obterTodosOsProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDto obterProdutoPorId(@PathVariable String id){
        return service.obterPorId(id);
    }

    @GetMapping("/codigo/{codigo}")
    public ProdutoDto obterPorCodigo(@PathVariable Integer codigo) {
        return service.obterPorCodigo(codigo);
    }

    @GetMapping("/porta")
    public String retornaPorta(@Value("${local.server.port}") String porta){
    return String.format("Microsserviço atuando na porta %s", porta);
  }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody @Valid ProdutoDto produto) {
        return new ResponseEntity<>(service.cadastrarProdutos(produto), HttpStatus.CREATED);
   
    }

    @PutMapping("/{id}")
    public ProdutoDto alterarProduto(@PathVariable String id, @RequestBody ProdutoDto produtoAlterar) {
         return service.alterarProduto(id, produtoAlterar);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable String id) {
        service.excluirProduto(id);
    }
}
