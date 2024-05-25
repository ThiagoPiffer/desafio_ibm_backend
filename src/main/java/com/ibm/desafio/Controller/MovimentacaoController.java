package com.ibm.desafio.Controller;

import com.ibm.desafio.Controller.Dto.MovimentacaoDTO;
import com.ibm.desafio.Entidade.Movimentacao;
import com.ibm.desafio.Service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private final MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public List<Movimentacao> findAll() {
        return movimentacaoService.findAll();
    }

    @GetMapping("/saldo/{clienteId}")
    public ResponseEntity<List<Movimentacao>> findByClienteId(@PathVariable Long clienteId) {
        List<Movimentacao> movimentacoes = movimentacaoService.findByClienteId(clienteId);
        if (movimentacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movimentacoes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable Long id) {
        Optional<Movimentacao> movimentacao = movimentacaoService.findById(id);
        return movimentacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movimentacao> addMovimentacao(@RequestBody MovimentacaoDTO movimentacaoDTO) {
        Movimentacao movimentacao = movimentacaoService.createMovimentacao(movimentacaoDTO);
        return ResponseEntity.ok(movimentacao);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean exists = movimentacaoService.findById(id).isPresent();
        if (exists) {
            movimentacaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
