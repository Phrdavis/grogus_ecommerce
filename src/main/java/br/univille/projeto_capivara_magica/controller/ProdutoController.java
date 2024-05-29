package br.univille.projeto_capivara_magica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;
import br.univille.projeto_capivara_magica.entity.Fornecedor;
import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.entity.Tipo_Produto;
import br.univille.projeto_capivara_magica.service.ProdutoService;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getProdutos() {

        return produtoService.getProdutos();

    }

    @GetMapping("/{nome}")
    public Produto getProdutoByName(@PathVariable("nome") String nome) {

        return produtoService.getProdutoByName(nome);

    }

    public record ProdutoModel(
            String nome,
            boolean disponibilidade,
            String descricao,
            int garantia,
            String modelo,
            String imagem,
            float preco,
            Fornecedor fornecedor,
            Tipo_Produto tipo_produto,
            Categoria_Produto categoria_produto) {
    };

    @PostMapping
    public void addProduto(@RequestBody ProdutoModel newProduto) {

        Produto produto = new Produto();
        produto.setNome(newProduto.nome);
        produto.setDisponibilidade(newProduto.disponibilidade);
        produto.setDescricao(newProduto.descricao);
        produto.setGarantia(newProduto.garantia);
        produto.setModelo(newProduto.modelo);
        produto.setImagem(newProduto.imagem);
        produto.setPreco(newProduto.preco);
        produto.setFornecedor(newProduto.fornecedor);
        produto.setTipo_produto(newProduto.tipo_produto);
        produto.setCategoria_produto(newProduto.categoria_produto);

        produtoService.addProduto(produto);

    }
}
