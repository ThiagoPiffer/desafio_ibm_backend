package com.ibm.desafio.Repository;

import com.ibm.desafio.Entidade.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IMovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    List<Movimentacao> findByClienteId(Long clienteId);
}
