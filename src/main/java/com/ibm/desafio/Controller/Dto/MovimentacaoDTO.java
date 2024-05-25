package com.ibm.desafio.Controller.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimentacaoDTO {
    private Long clienteId;
    private String tipo;
    private BigDecimal valor;
    private LocalDateTime dataMovimentacao;

    // Construtores
    public MovimentacaoDTO() {
        // Construtor padrão necessário para deserialização
    }

    public MovimentacaoDTO(Long clienteId, String tipo, BigDecimal valor, LocalDateTime dataMovimentacao) {
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.valor = valor;
        this.dataMovimentacao = dataMovimentacao;
    }

    // Getters e Setters
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
}
