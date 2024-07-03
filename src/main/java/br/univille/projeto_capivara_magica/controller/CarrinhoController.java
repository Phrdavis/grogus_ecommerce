package br.univille.projeto_capivara_magica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Carrinho;
import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.entity.Usuario;
import br.univille.projeto_capivara_magica.service.CarrinhoService;

@RestController
@RequestMapping("api/v1/carrinhos")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {

        this.carrinhoService = carrinhoService;

    }

    @GetMapping
    public List<Carrinho> getProdutos() {

        return carrinhoService.getTodoCarrinho();

    }

    @CrossOrigin
    @PostMapping("/usuario/{usuario}")
    public List<Carrinho> getCarrinhoUsuario(@PathVariable("usuario") Usuario usuario) {

        return carrinhoService.getCarrinhoUsuario(usuario);

    }

    @PostMapping("/adicionar")
    public void updateCarrinho(@RequestBody Carrinho request) {

        Carrinho carrinho_aux = request;

        carrinhoService.updateCarrinho(carrinho_aux);

    }

}
