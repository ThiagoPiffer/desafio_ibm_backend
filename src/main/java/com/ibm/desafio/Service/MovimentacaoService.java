package com.ibm.desafio.Service;

import com.ibm.desafio.Controller.Dto.MovimentacaoDTO;
import com.ibm.desafio.Entidade.Cliente;
import com.ibm.desafio.Entidade.Movimentacao;
import com.ibm.desafio.Repository.IClienteRepository;
import com.ibm.desafio.Repository.IMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private IMovimentacaoRepository movimentacaoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public List<Movimentacao> findByClienteId(Long clienteId) {
        return movimentacaoRepository.findByClienteId(clienteId);
    }

    public Optional<Movimentacao> findById(Long id) {
        return movimentacaoRepository.findById(id);
    }

    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteById(Long id) {
        movimentacaoRepository.deleteById(id);
    }

    @Transactional
    public Movimentacao createMovimentacao(Long clienteId, MovimentacaoDTO movimentacaoDTO) {

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setClienteId(clienteId);
        movimentacao.setTipo(movimentacaoDTO.getTipo());
        movimentacao.setValor(movimentacaoDTO.getValor());
        movimentacao.setDataMovimentacao(movimentacaoDTO.getDataMovimentacao());

        if ("transferencia".equals(movimentacaoDTO.getTipo()) && movimentacaoDTO.getClienteIdTransferencia() != null) {
            Cliente clienteTransferencia = clienteRepository.findById(movimentacaoDTO.getClienteIdTransferencia())
                    .orElseThrow(() -> new RuntimeException("Cliente destinatário não encontrado"));
            movimentacao.setClienteIdTransferencia(clienteTransferencia.getId());

            // Criação da movimentação espelho para o cliente destinatário
            Movimentacao movimentacaoEspelho = new Movimentacao();
            movimentacaoEspelho.setClienteId(clienteTransferencia.getId());
            movimentacaoEspelho.setTipo("credito");
            movimentacaoEspelho.setValor(movimentacaoDTO.getValor());
            movimentacaoEspelho.setDataMovimentacao(movimentacaoDTO.getDataMovimentacao());
            movimentacaoEspelho.setClienteIdTransferencia(clienteId);

            movimentacaoRepository.save(movimentacaoEspelho);
        }

        return movimentacaoRepository.save(movimentacao);
    }

    public void deleteByClienteId(Long clienteId) {
        List<Movimentacao> movimentacoes = movimentacaoRepository.findByClienteId(clienteId);
        movimentacaoRepository.deleteAll(movimentacoes);
    }
}
