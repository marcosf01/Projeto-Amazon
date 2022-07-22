package com.tech4pay.pagamentos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ecommerce-ms")
public interface ProdutoFeignClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/produtos/{id}" )
    Produto obterProdutoPorId(@PathVariable String id);
}
