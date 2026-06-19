package couto.dev.email_service.Dto;

import java.util.UUID;

public record ReservacriadaDto(Integer reservaId,
                               UUID usuarioId,
                               Integer salaId,
                               String destinatario,
                               String assunto,
                               String mensagem) {
}
