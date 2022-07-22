package com.tech4pay.pagamentos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pagamentos")
public class Pagamento {
    @Id
    private String id;
    private String nome;
    private double valorPago;
    private String idProduto;
    private FormaDePagamento pagamento;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValorPago() {
        return valorPago;
    }
    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    public String getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
    public FormaDePagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(FormaDePagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
    
}
