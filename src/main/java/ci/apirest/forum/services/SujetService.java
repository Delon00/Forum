package ci.apirest.forum.services;

import ci.apirest.forum.services.DTO.SujetDTO;


import java.util.List;


public interface SujetService {
    SujetDTO createSujet(SujetDTO sujetDTO);
    List<SujetDTO> getSujetsByForumId(Long forumId);
    SujetDTO getSujetById(Long id);
}

