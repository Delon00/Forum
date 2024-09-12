package ci.apirest.forum.services;


import ci.apirest.forum.services.DTO.ForumDTO;

import java.util.List;
import java.util.Optional;


public interface ForumService {
    ForumDTO createForum(ForumDTO forumDTO); // Crée un forum
    List<ForumDTO> getAllForums(); // Récupère tous les forums
    Optional<ForumDTO> findOneForum(Long id); // Récupère un forum par son ID
    Optional<ForumDTO> findOneForumBySlug(String slug); // Récupère un forum par son slug

    ForumDTO createFormSlug(ForumDTO forumDTO);
}
