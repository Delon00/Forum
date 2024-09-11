package ci.apirest.forum.services;


import ci.apirest.forum.services.DTO.ForumDTO;

import java.util.List;


public interface ForumService {
    ForumDTO createForum(ForumDTO forumDTO);
    List<ForumDTO> getAllForums();
    ForumDTO getForumById(Long id);
}
