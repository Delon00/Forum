package ci.apirest.forum.services.mapper;

import ci.apirest.forum.models.Forum;
import ci.apirest.forum.services.DTO.ForumDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForumMapper extends EntityMapper<ForumDTO, Forum>  {
}
