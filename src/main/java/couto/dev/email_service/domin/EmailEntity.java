package couto.dev.email_service.domin;

import couto.dev.email_service.Enum.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "email-db")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UUID usuarioId;
    private Integer salaId;
    private Integer reservaId;
    private String destinatario;
    private String assunto;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEnvio;
    private String erro;
    private EmailStatus emailStatus;



}
