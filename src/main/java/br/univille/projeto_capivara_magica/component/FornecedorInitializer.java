package br.univille.projeto_capivara_magica.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.univille.projeto_capivara_magica.entity.Fornecedor;
import br.univille.projeto_capivara_magica.repository.FornecedorRepository;

@Component
@Order(4)
public class FornecedorInitializer implements CommandLineRunner{

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public void run(String... args) throws Exception{

        if(fornecedorRepository.count() == 0){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setNome("Pichau");
            fornecedor.setCidade("Joinville");
            fornecedor.setFilial("1");
            fornecedor.setUf("SC");
            fornecedor.setCnpj("123445578976");
            fornecedorRepository.save(fornecedor);

            Fornecedor fornecedor2 = new Fornecedor();
            fornecedor2.setNome("Kabum");
            fornecedor2.setCidade("São Paulo");
            fornecedor2.setFilial("3");
            fornecedor2.setUf("SP");
            fornecedor2.setCnpj("7653452334");
            fornecedorRepository.save(fornecedor2);

            Fornecedor fornecedor3 = new Fornecedor();
            fornecedor3.setNome("Terabyte");
            fornecedor3.setCidade("Curitiba");
            fornecedor3.setFilial("2");
            fornecedor3.setUf("PR");
            fornecedor3.setCnpj("3457665875");
            fornecedorRepository.save(fornecedor3);

        }

    }
    
}
