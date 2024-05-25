package com.ibm.desafio.Service;

import com.ibm.desafio.Controller.Dto.MovimentacaoDTO;
import com.ibm.desafio.Entidade.Cliente;
import com.ibm.desafio.Entidade.Movimentacao;
import com.ibm.desafio.Repository.IMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private IMovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ClienteService clienteService;

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

    public Movimentacao createMovimentacao(MovimentacaoDTO movimentacaoDTO) {
        Movimentacao movimentacao = new Movimentacao();
        Cliente cliente = clienteService.findById(movimentacaoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        movimentacao.setClienteId(cliente.getId());
        movimentacao.setTipo(movimentacaoDTO.getTipo());
        movimentacao.setValor(movimentacaoDTO.getValor());
        movimentacao.setDataMovimentacao(movimentacaoDTO.getDataMovimentacao());
        return movimentacaoRepository.save(movimentacao);
    }
}
