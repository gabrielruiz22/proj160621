package br.com;

import br.com.Utils.PlanilhaUtils;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class Main {

    @Value("${queue.produto.name}")
    private String produtoQueue;

    @Value("${queue.estoque.name}")
    private String estoqueQueue;

    @Value("${queue.venda.name}")
    private String vendaQueue;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Main.class, args);
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Queue produtoQueue(){
        return new Queue(produtoQueue,true);
    }

    @Bean
    public Queue vendaQueue(){
        return new Queue(vendaQueue,true);
    }

    @Bean
    public Queue estoqueQueue(){
        return new Queue(estoqueQueue,true);
    }

}