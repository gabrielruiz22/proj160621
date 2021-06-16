import br.com.Main;
import br.com.model.Estoque;
import br.com.model.Produto;
import br.com.model.Venda;
import br.com.service.EstoqueService;
import br.com.service.ProdutoService;
import br.com.service.VendaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
@WebAppConfiguration
public class QueuesControllerTest {

    @Autowired
    private EstoqueService estoqueService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private VendaService vendaService;

    @Test
    public void save() throws Exception {

        long qtd = 5;

        estoqueService.deleteAll();
        produtoService.deleteAll();
        vendaService.deleteAll();


        for ( int i = 1 ; i <= qtd ; i++){
            produtoService.sendProdutoRabbit(new Produto(i, "Teste 1 " + i));
        }

        for ( int i = 1 ; i <= qtd ; i++){
            estoqueService.sendEstoqueRabbit(new Estoque(i, 200 + i, new Produto(i, "Produto " + i)));
        }

        for (int i = 1; i <= qtd; i++){
            vendaService.sendVendaRabbit(new Venda(i, 10 + i, "Dinheiro", "14/06/2021", new Produto(i, "Produto " + i)));
        }
    }
}
