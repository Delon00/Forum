package ci.apirest.forum.services;


import ci.apirest.forum.services.DTO.ForumDTO;

import java.util.List;
import java.util.Optional;


public interface ForumService {
    ForumDTO createForum(ForumDTO forumDTO);
    List<ForumDTO> getAllForums();
    Optional<ForumDTO> findOneForum(Long id);
    Optional<ForumDTO> findOneForumBySlug(String slug);

    ForumDTO createformwithSlug(ForumDTO forumDTO);
}
