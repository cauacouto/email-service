package couto.dev.email_service.Repository;

import couto.dev.email_service.domin.EmailEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailService extends MongoRepository<EmailEntity,String> {
}
