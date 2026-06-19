package couto.dev.email_service.Mapper;

import couto.dev.email_service.Dto.ReservacriadaDto;
import couto.dev.email_service.domin.EmailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {


    EmailEntity toEntity(ReservacriadaDto email);
}
