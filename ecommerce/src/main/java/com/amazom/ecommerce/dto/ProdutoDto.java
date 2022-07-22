package com.amazom.ecommerce.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ProdutoDto {
    private String id;
    @Positive
    private Integer codigo;
    @NotBlank(message = "A descrição do produto deve ser informada!")
    private String descricao;
    @Positive
    private double valor;
    private double precoCusto;
    @NotNull(message = "O fornecedor obrigatóriamente deve ser informado!") 
    @Size(min = 10, message = "Fornecedor precisa ter 10 caracteres ou mais!")
    private String fornecedor;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    public String getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
