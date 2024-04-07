package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Cliente;
import br.univille.projeto_capivara_magica.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes(){

        return clienteRepository.findAll();

    }

    public void addCliente(Cliente cliente){

        clienteRepository.save(cliente);

    }

}
