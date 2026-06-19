package couto.dev.email_service.Service;

import couto.dev.email_service.Dto.ReservacriadaDto;
import couto.dev.email_service.Enum.EmailStatus;
import couto.dev.email_service.Mapper.EmailMapper;
import couto.dev.email_service.Repository.EmailRepository;
import couto.dev.email_service.domin.EmailEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {


    private final EmailRepository emailRepository;

    private final JavaMailSender mailSender;

    private final EmailMapper emailMapper;

    @Value("${spring.mail.username}")
    private String remetente;

    public  void enviarEmail(ReservacriadaDto event){
        EmailEntity email = emailMapper.toEntity(event);

        email.setEmailStatus(EmailStatus.PEDENDENTE);
        email.setDataCriacao(LocalDateTime.now());
    try {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(remetente);
        message.setTo(email.getDestinatario());
        message.setSubject(email.getAssunto());
        message.setText(email.getMensagem());

        mailSender.send(message);

        email.setEmailStatus(EmailStatus.ENVIADO);
        email.setDataEnvio(LocalDateTime.now());

    }catch (Exception e){
        email.setEmailStatus(EmailStatus.ERRO);
        email.setErro(e.getMessage());
    }
    emailRepository.save(email);

    }



}
