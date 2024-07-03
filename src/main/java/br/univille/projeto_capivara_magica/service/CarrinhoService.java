package br.univille.projeto_capivara_magica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.projeto_capivara_magica.entity.Carrinho;
import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.repository.CarrinhoRepository;

@Service
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {

        this.carrinhoRepository = carrinhoRepository;

    }

    public List<Carrinho> getTodoCarrinho() {

        return carrinhoRepository.findAll();

    }

    public Carrinho getCarrinhoProduto(long id) {

        return carrinhoRepository.findById(id);

    }

    public List<Carrinho> getCarrinhoUsuario(Usuario usuario) {

        return carrinhoRepository.findByUsuario(usuario);

    }

    public void updateCarrinho(Carrinho carrinho) {

        Usuario usuario_carrinho = carrinho.getUsuario();
        Produto produto_carrinho = carrinho.getProduto();

        Carrinho old_carrinho = carrinhoRepository.findByUsuarioProduto(usuario_carrinho, produto_carrinho);

        if (old_carrinho == null) {

            carrinhoRepository.save(carrinho);

        } else {

            old_carrinho.setQuantidade(old_carrinho.getQuantidade() + carrinho.getQuantidade());
            carrinhoRepository.save(old_carrinho);

        }

    }

}
