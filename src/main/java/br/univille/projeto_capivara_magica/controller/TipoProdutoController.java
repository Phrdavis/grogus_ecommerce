package br.univille.projeto_capivara_magica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projeto_capivara_magica.entity.Tipo_Produto;
import br.univille.projeto_capivara_magica.service.TipoProdutoService;

@RestController
@RequestMapping("api/v1/tipos_produto")
public class TipoProdutoController {

    private TipoProdutoService tipoProdutoService;

    public TipoProdutoController(TipoProdutoService tipoProdutoService){
        this.tipoProdutoService = tipoProdutoService;
    }

    @GetMapping
    public List<Tipo_Produto> getTiposProduto(){

        return tipoProdutoService.getTiposProduto();

    }

    public record NewTipoProduto(

        String nome

    ){}

    @PostMapping
    public ResponseEntity<String> addTipoProduto(@RequestBody NewTipoProduto newTipoProduto){

        Tipo_Produto tipoProduto = new Tipo_Produto();
        tipoProduto.setNome(newTipoProduto.nome);

        
        try{
            
            String respost = tipoProdutoService.addTipoProduto(tipoProduto);
            return ResponseEntity.ok(respost);

        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.IM_USED).body(e.getMessage());
        }

    }
    
}
