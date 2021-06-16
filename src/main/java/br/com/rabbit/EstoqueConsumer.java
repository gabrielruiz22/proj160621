package br.com.rabbit;

import br.com.model.Estoque;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import br.com.service.EstoqueService;

@Component
public class EstoqueConsumer {

    @Autowired
    private EstoqueService estoqueService;

    @RabbitListener(queues = {"${queue.estoque.name}"})
    public void receive (@Payload Estoque estoque){
        System.out.println("Id: "+ estoque.get_id() + "\nDescricao: "
                + "\nQuantidade de Produto: " + estoque.getQtdProduto() +
                "\nProduto: " + estoque.getProduto().getNome());
        estoqueService.save(estoque);
    }

}
