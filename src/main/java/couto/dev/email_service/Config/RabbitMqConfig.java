package couto.dev.email_service.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public JacksonJsonMessageConverter  messageConverter(){
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, JacksonJsonMessageConverter converter){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter);

        return template;
    }

    @Bean
    public Queue emailqueu(){
        return new Queue("email.queue");
    }

    @Bean
    public FanoutExchange reservaExchange(){
        return new FanoutExchange("reserva.ex");
    }

    @Bean
    public Binding binding(Queue emailQueue, FanoutExchange reservaExchange){
        return BindingBuilder
                .bind(emailQueue)
                .to(reservaExchange);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }
}
