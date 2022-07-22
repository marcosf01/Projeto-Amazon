package com.amazom.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amazom.ecommerce.dto.ProdutoDto;
import com.amazom.ecommerce.model.Produto;
import com.amazom.ecommerce.repository.ProdutoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository repository;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<ProdutoDto> obterTodosOsProdutos() {
        List<Produto> produtos = repository.findAll();

        return produtos.stream()
                .map(p -> mapper.map(p, ProdutoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDto obterPorId(String id) { 
        Optional<Produto> produto = repository.findById(id);

        if (produto.isPresent()) {
            return mapper.map(produto.get(), ProdutoDto.class);
        }
        return null;
    }

    @Override
    public ProdutoDto obterPorCodigo(Integer codigo) {
        Produto produto = repository.findByCodigo(codigo);

        return mapper.map(produto, ProdutoDto.class);
    }

    @Override
    public ProdutoDto cadastrarProdutos(ProdutoDto produto) {
        Produto produtoSalvar = mapper.map(produto, Produto.class);
        repository.save(produtoSalvar);
        return mapper.map(produtoSalvar, ProdutoDto.class);
    }

    @Override
    public void excluirProduto(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public ProdutoDto alterarProduto(String id, ProdutoDto produto) {
        Optional<Produto> produtoBusca = repository.findById(id);

       if (produtoBusca.isPresent()) {
            Produto produtoAlterar = mapper.map(produto, Produto.class);
            produtoAlterar.setId(id);
            produtoAlterar = repository.save(produtoAlterar);
                return mapper.map(produtoAlterar, ProdutoDto.class);
        }
        return null;
       
    }

}
