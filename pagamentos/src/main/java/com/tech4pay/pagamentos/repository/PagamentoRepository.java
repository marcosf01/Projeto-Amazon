package com.tech4pay.pagamentos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tech4pay.pagamentos.model.Pagamento;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
    
}
