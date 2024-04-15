package br.univille.projeto_capivara_magica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Fornecedor;
import br.univille.projeto_capivara_magica.service.FornecedorService;

@RestController
@RequestMapping("api/v1/fornecedores")
public class FornecedorController {
    
    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService){
        this.fornecedorService = fornecedorService;
    }

    public void getFornecedores(){

        fornecedorService.getFornecedores();

    }

    public record NewFornecedor(
        String nome,
        String cidade,
        String filial,
        String uf,
        String cnpj
    ){};

    @GetMapping
    public void addFornecedor(@RequestBody NewFornecedor newFornecedor){

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(newFornecedor.nome); 
        fornecedor.setCidade(newFornecedor.cidade);
        fornecedor.setFilial(newFornecedor.filial);
        fornecedor.setUf(newFornecedor.uf);
        fornecedor.setCnpj(newFornecedor.cnpj);

        fornecedorService.addFornecedor(fornecedor);

    }

}
