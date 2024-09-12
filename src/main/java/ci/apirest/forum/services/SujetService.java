package ci.apirest.forum.services;

import ci.apirest.forum.services.DTO.SujetDTO;


import java.util.List;
import java.util.Optional;


public interface SujetService {
    SujetDTO createSujet(SujetDTO sujetDTO);
    List<SujetDTO> getSujetsByForumId(Long forumId);
    SujetDTO getSujetDetails(Long id);

    Optional<SujetDTO> findOneSujetBySlug(String slug);
}

