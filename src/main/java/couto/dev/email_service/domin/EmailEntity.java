package couto.dev.email_service.domin;

import couto.dev.email_service.Enum.EmailStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collation = "emails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmailEntity {

    @Id
    private String id;
    private UUID usuarioId;
    private Integer salaId;
    private Integer reservaId;
    private String destinatario;
    private String assunto;
    private String mensagem;
    private EmailStatus emailStatus;



}
