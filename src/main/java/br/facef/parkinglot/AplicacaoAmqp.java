package br.facef.parkinglot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoAmqp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AplicacaoAmqp.class, args);
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        do {
            rabbitTemplate.convertAndSend("tutorial-exchange", "primaryRoutingKey", "Hello, world! at "+System.currentTimeMillis());
            Thread.sleep(60000);
        } while (true);
    }

}
