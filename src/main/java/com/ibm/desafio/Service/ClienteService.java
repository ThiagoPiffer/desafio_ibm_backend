package com.ibm.desafio.Service;

import com.ibm.desafio.Controller.Dto.ClienteDTO;
import com.ibm.desafio.Entidade.Cliente;
import com.ibm.desafio.Repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private MovimentacaoService movimentacaoService;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(Long id) {
        movimentacaoService.deleteByClienteId(id);
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteData = clienteRepository.findById(id);
        if (clienteData.isPresent()) {
            Cliente _cliente = clienteData.get();
            _cliente.setNome(clienteDTO.getNome());
            _cliente.setIdade(clienteDTO.getIdade());
            _cliente.setEmail(clienteDTO.getEmail());
            _cliente.setNumero_Conta(clienteDTO.getNumero_Conta());
            return clienteRepository.save(_cliente);
        } else {
            return null;
        }
    }
}
