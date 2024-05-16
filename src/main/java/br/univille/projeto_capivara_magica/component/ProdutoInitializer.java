package br.univille.projeto_capivara_magica.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.univille.projeto_capivara_magica.entity.Categoria_Produto;
import br.univille.projeto_capivara_magica.entity.Fornecedor;
import br.univille.projeto_capivara_magica.entity.Produto;
import br.univille.projeto_capivara_magica.entity.Tipo_Produto;
import br.univille.projeto_capivara_magica.repository.CategoriaProdutoRepository;
import br.univille.projeto_capivara_magica.repository.FornecedorRepository;
import br.univille.projeto_capivara_magica.repository.ProdutoRepository;
import br.univille.projeto_capivara_magica.repository.TipoProdutoRepository;

@Component
@Order(6)
public class ProdutoInitializer implements CommandLineRunner{

    @Autowired
    private CategoriaProdutoRepository categoriaRepository;

    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception{

        if(produtoRepository.count() == 0){

            Categoria_Produto categoria = categoriaRepository.findByNome("Periféricos");
            Tipo_Produto tipo_produto = tipoProdutoRepository.findByNome("Mouse");
            Fornecedor fornecedor = fornecedorRepository.findByNome("Pichau");

            Produto produto = new Produto();
            produto.setNome("Mouse Gamer Fortrek Spider Tarantula, 2000 Dpi USB OM702, 54623");
            produto.setDisponibilidade(true);
            produto.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/5/4/546232.jpg");
            produto.setDescricao("Mouse Gamer");
            produto.setGarantia(12);
            produto.setModelo("54623");
            produto.setPreco(150.50f);
            produto.setFornecedor(fornecedor);
            produto.setTipo_produto(tipo_produto);
            produto.setCategoria_produto(categoria);
            
            produtoRepository.save(produto);

            Produto produto2 = new Produto();
            produto2.setNome("Mouse Thermaltake Tt eSPORTS Ventus Z 11000Dpi RGB, MO-VEZ-WDLOBK-01");
            produto2.setDisponibilidade(true);
            produto2.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/m/o/mo-vez-wdlobk-015.jpg");
            produto2.setDescricao("Mouse Gamer");
            produto2.setGarantia(12);
            produto2.setModelo("MO-VEZ-WDLOBK-01");
            produto2.setPreco(419.99f);
            produto2.setFornecedor(fornecedor);
            produto2.setTipo_produto(tipo_produto);
            produto2.setCategoria_produto(categoria);
            
            produtoRepository.save(produto2);

            Produto produto3 = new Produto();
            produto3.setNome("Mouse Logitech M170 2.4Ghz USB Wireless Vermelho, 910-004941");
            produto3.setDisponibilidade(true);
            produto3.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/9/1/910-00494123123.jpg");
            produto3.setDescricao("Mouse Gamer");
            produto3.setGarantia(12);
            produto3.setModelo("910-004941");
            produto3.setPreco(49.99f);
            produto3.setFornecedor(fornecedor);
            produto3.setTipo_produto(tipo_produto);
            produto3.setCategoria_produto(categoria);
            
            produtoRepository.save(produto3);

            Produto produto4 = new Produto();
            produto4.setNome("Mouse Gamer Thermaltake Neros, RGB, 3200DPI, 6 Botoes, Preto, EMO-NRR-WDOTBK-01");
            produto4.setDisponibilidade(true);
            produto4.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/e/m/emo-nrr-wdotbk-013.jpg");
            produto4.setDescricao("Mouse Gamer");
            produto4.setGarantia(12);
            produto4.setModelo("EMO-NRR-WDOTBK-01");
            produto4.setPreco(179.99f);
            produto4.setFornecedor(fornecedor);
            produto4.setTipo_produto(tipo_produto);
            produto4.setCategoria_produto(categoria);
            
            produtoRepository.save(produto4);

            Produto produto5 = new Produto();
            produto5.setNome("Mouse Logitech MX Anywhere 3S, Bluetooth, 8000DPI, 6 Botoes, Cinza, 910-006933");
            produto5.setDisponibilidade(true);
            produto5.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/9/1/910-006933.jpg");
            produto5.setDescricao("Mouse Gamer");
            produto5.setGarantia(12);
            produto5.setModelo("910-006933");
            produto5.setPreco(379.99f);
            produto5.setFornecedor(fornecedor);
            produto5.setTipo_produto(tipo_produto);
            produto5.setCategoria_produto(categoria);
            
            produtoRepository.save(produto5);

            Produto produto6 = new Produto();
            produto6.setNome("Mouse Gamer Zowie EC1-CW, Wireless, 3200DPI, 5 Botoes, Preto, 9H.N48BE.A2E");
            produto6.setDisponibilidade(true);
            produto6.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/9/h/9hn48bea2e6.jpg");
            produto6.setDescricao("Mouse Gamer");
            produto6.setGarantia(12);
            produto6.setModelo("9H.N48BE.A2E");
            produto6.setPreco(1249.99f);
            produto6.setFornecedor(fornecedor);
            produto6.setTipo_produto(tipo_produto);
            produto6.setCategoria_produto(categoria);
            
            produtoRepository.save(produto6);

            Produto produto7 = new Produto();
            produto7.setNome("Mouse Gamer Zowie EC3-CW, Wireless, 3200DPI, 5 Botoes, Preto, 9H.N4ABE.A2E");
            produto7.setDisponibilidade(true);
            produto7.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/9/h/9hn4abea2e5.jpg");
            produto7.setDescricao("Mouse Gamer");
            produto7.setGarantia(12);
            produto7.setModelo("9H.N4ABE.A2E");
            produto7.setPreco(678.99f);
            produto7.setFornecedor(fornecedor);
            produto7.setTipo_produto(tipo_produto);
            produto7.setCategoria_produto(categoria);
            
            produtoRepository.save(produto7);

            Produto produto8 = new Produto();
            produto8.setNome("Mouse Philips SPK7307BL, 1600DPI, 3 Botoes, Wireless, Preto, SPK7307BL");
            produto8.setDisponibilidade(true);
            produto8.setImagem("https://media.pichau.com.br/media/catalog/product/cache/ef72d3c27864510e5d4c0ce69bade259/s/p/spk7307bl3.jpg");
            produto8.setDescricao("Mouse Gamer");
            produto8.setGarantia(12);
            produto8.setModelo("SPK7307BL");
            produto8.setPreco(44.90f);
            produto8.setFornecedor(fornecedor);
            produto8.setTipo_produto(tipo_produto);
            produto8.setCategoria_produto(categoria);
            
            produtoRepository.save(produto8);
        }

    }
    
}
