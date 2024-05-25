package com.ibm.desafio.Repository.impl;

import com.ibm.desafio.Entidade.Movimentacao;
import com.ibm.desafio.Repository.IMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovimentacaoRepository {

    private final IMovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoRepository(IMovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public List<Movimentacao> findAllByClienteId(Long clienteId) {
        return movimentacaoRepository.findByClienteId(clienteId);
    }
}
