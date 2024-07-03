package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Estoque;
import br.univille.projeto_capivara_magica.repository.EstoqueRepository;

@Service
public class EstoqueService {

    private EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {

        this.estoqueRepository = estoqueRepository;

    }

    public List<Estoque> getTodoEstoque() {

        return estoqueRepository.findAll();

    }

    public Estoque getEstoqueProduto(int id) {

        return estoqueRepository.findById(id);

    }

    public void updateEstoque(Estoque estoque) {

        long id_estoque = estoque.getId();

        Estoque old_estoque = estoqueRepository.findById(id_estoque);

        if (old_estoque == null) {

            estoqueRepository.save(estoque);

        } else {

            old_estoque.setQuantidade(old_estoque.getQuantidade() + estoque.getQuantidade());
            estoqueRepository.save(old_estoque);

        }

    }

}
