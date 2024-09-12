package ci.apirest.forum.services.mapper;


import ci.apirest.forum.models.Message;
import ci.apirest.forum.services.DTO.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {
}
