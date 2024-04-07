package br.univille.projeto_capivara_magica.controller;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.univille.projeto_capivara_magica.entity.Cliente;
import br.univille.projeto_capivara_magica.entity.TipoUsuario;
import br.univille.projeto_capivara_magica.service.ClienteService;


@RestController
@RequestMapping("api/clientes")
public class ClienteController {
    
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> getClientes(){

        return clienteService.getClientes();

    }

    public record ClienteModel(
        String nome,
        int idade,
        String cpf,
        String email,
        String telefone,
        String senha,
        boolean ativo,
        TipoUsuario tipo
    ){};

    @PostMapping
    public void addCliente(@RequestBody ClienteModel request){

            Cliente cliente = new Cliente();
            cliente.setNome(request.nome);
            cliente.setCpf(request.cpf);
            cliente.setEmail(request.email);
            cliente.setTelefone(request.telefone);
            cliente.setSenha(request.senha);
            cliente.setIdade(request.idade);
            cliente.setAtivo(request.ativo); 
            cliente.setTipo(request.tipo);

            clienteService.addCliente(cliente);

    }
}
