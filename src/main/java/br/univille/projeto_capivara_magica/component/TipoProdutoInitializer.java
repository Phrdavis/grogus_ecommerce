package br.univille.projeto_capivara_magica.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.univille.projeto_capivara_magica.entity.Tipo_Produto;
import br.univille.projeto_capivara_magica.repository.TipoProdutoRepository;

@Component
@Order(2)
public class TipoProdutoInitializer implements CommandLineRunner{

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Override
    public void run(String... args) throws Exception{

        if(tipoProdutoRepository.count() == 0){
            Tipo_Produto tipoProduto = new Tipo_Produto();
            tipoProduto.setNome("Mouse");
            tipoProdutoRepository.save(tipoProduto);

            Tipo_Produto tipoProduto2 = new Tipo_Produto();
            tipoProduto2.setNome("Computador");
            tipoProdutoRepository.save(tipoProduto2);

            Tipo_Produto tipoProduto3 = new Tipo_Produto();
            tipoProduto3.setNome("Headset");
            tipoProdutoRepository.save(tipoProduto3);

            Tipo_Produto tipoProduto4 = new Tipo_Produto();
            tipoProduto4.setNome("Gabinete");
            tipoProdutoRepository.save(tipoProduto4);
        }

    }
    
}
