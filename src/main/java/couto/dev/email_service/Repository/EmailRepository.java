package couto.dev.email_service.Repository;

import couto.dev.email_service.domin.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity,Integer> {
}
