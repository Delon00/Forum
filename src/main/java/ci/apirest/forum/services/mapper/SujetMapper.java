package ci.apirest.forum.services.mapper;

import ci.apirest.forum.models.Sujet;
import ci.apirest.forum.services.DTO.SujetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SujetMapper extends EntityMapper<SujetDTO, Sujet> {

}
