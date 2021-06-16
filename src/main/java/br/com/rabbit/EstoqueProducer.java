package br.com.rabbit;

import br.com.model.Estoque;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EstoqueProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("estoqueQueue")
    @Autowired
    private Queue queue;

    public void send(Estoque estoque){
        rabbitTemplate.convertAndSend(this.queue.getName(), estoque);
    }
}
