package ci.apirest.forum.services;

import ci.apirest.forum.services.DTO.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {
    SujetDTO createSujet(SujetDTO sujetDTO); // Créer un sujet
    List<SujetDTO> getAllSujets(); // Récupérer tous les sujets
    Optional<SujetDTO> getSujetById(Long id); // Récupérer un sujet par ID
    List<SujetDTO> getSujetsByForumId(Long forumId); // Récupérer les sujets par forum
    Optional<SujetDTO> findOneSujetBySlug(String slug); // Récupérer un sujet par slug
}