package com.ibm.desafio.Repository;

import com.ibm.desafio.Entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
