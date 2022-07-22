package com.tech4pay.pagamentos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech4pay.pagamentos.client.ProdutoFeignClient;
import com.tech4pay.pagamentos.dto.PagamentoDto;
import com.tech4pay.pagamentos.dto.PagamentoDtoComProduto;
import com.tech4pay.pagamentos.model.Pagamento;
import com.tech4pay.pagamentos.repository.PagamentoRepository;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository repository;
    
    @Autowired
    private ProdutoFeignClient feignclient;

    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<PagamentoDto> obterTodosOsPagamentos() {
        List<Pagamento> pagamentos = repository.findAll();
        return pagamentos.stream()
                .map(pg -> mapper.map(pg, PagamentoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PagamentoDtoComProduto obterPagamentoPorId(String id) {
        Optional<Pagamento> pagamentoBuscar = repository.findById(id);

        if (pagamentoBuscar.isPresent()) {

            PagamentoDtoComProduto pagamentoComDetalhes = mapper.map(pagamentoBuscar, PagamentoDtoComProduto.class);
            pagamentoComDetalhes.setProdutoDetalhes(feignclient.obterProdutoPorId(pagamentoBuscar.get().getIdProduto()));
            return pagamentoComDetalhes;
        }
        return null;
    }

    @Override
    public PagamentoDto realizarPagamento(PagamentoDto pagamento) {
        Pagamento pagamentoSalvar = mapper.map(pagamento, Pagamento.class);
        repository.save(pagamentoSalvar);
        return mapper.map(pagamentoSalvar, PagamentoDto.class);
    }

    @Override
    public PagamentoDto alterarPagamento(String id, PagamentoDto pagamento) {
        Optional<Pagamento> pagamentoAlterarBuscar = repository.findById(id);

        if (pagamentoAlterarBuscar.isPresent()) {
            Pagamento pagamentoAlterar = mapper.map(pagamento, Pagamento.class);
            pagamentoAlterar.setId(id);
            pagamentoAlterar = repository.save(pagamentoAlterar);
                return mapper.map(pagamentoAlterar, PagamentoDto.class);
        }
        return null; 
    }

    @Override
    public void excluirPagamento(String id) {
        repository.deleteById(id);
    }
    
}
