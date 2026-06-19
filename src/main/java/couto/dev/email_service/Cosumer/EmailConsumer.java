package couto.dev.email_service.Cosumer;

import couto.dev.email_service.Dto.ReservacriadaDto;
import couto.dev.email_service.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @RabbitListener(queues = "email.queue")
    public void ReceberReserva(@Payload ReservacriadaDto event){
        emailService.enviarEmail(event);
    }
}
