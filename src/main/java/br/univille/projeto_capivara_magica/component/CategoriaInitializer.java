package br.univille.projeto_capivara_magica.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;
import br.univille.projeto_capivara_magica.repository.CategoriaProdutoRepository;


@Component
@Order(3)
public class CategoriaInitializer implements CommandLineRunner{

    @Autowired
    private CategoriaProdutoRepository tipoProdutoRepository;

    @Override
    public void run(String... args) throws Exception{

        if(tipoProdutoRepository.count() == 0){
            Categoria_Produto categoriaProduto = new Categoria_Produto();
            categoriaProduto.setNome("Profissional");
            tipoProdutoRepository.save(categoriaProduto);

            Categoria_Produto categoriaProduto2 = new Categoria_Produto();
            categoriaProduto2.setNome("Gamer");
            tipoProdutoRepository.save(categoriaProduto2);

            Categoria_Produto categoriaProduto3 = new Categoria_Produto();
            categoriaProduto3.setNome("Periféricos");
            tipoProdutoRepository.save(categoriaProduto3);
        }

    }
    
}
