package br.univille.projeto_capivara_magica.service;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Fornecedor;
import br.univille.projeto_capivara_magica.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;
    
    public FornecedorService(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    public void getFornecedores(){

        fornecedorRepository.findAll();

    }

    public void addFornecedor(Fornecedor fornecedor){

        fornecedorRepository.save(fornecedor);

    }
    
}
