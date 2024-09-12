package ci.apirest.forum.services.Impl;

import ci.apirest.forum.models.Forum;
import ci.apirest.forum.models.Sujet;
import ci.apirest.forum.repositories.SujetRepository;
import ci.apirest.forum.services.DTO.ForumDTO;
import ci.apirest.forum.services.DTO.SujetDTO;
import ci.apirest.forum.services.SujetService;
import ci.apirest.forum.services.mapper.SujetMapper;
import ci.apirest.forum.repositories.ForumRepository;
import ci.apirest.forum.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final ForumRepository forumRepository;
    private final SujetMapper sujetMapper;


    @Override
    public SujetDTO createSujet(SujetDTO sujetDTO) {
        log.debug("Request to save Sujet: {}", sujetDTO);

        // Vérifier si le forum existe
        Forum forum = forumRepository.findById(sujetDTO.getForumId())
                .orElseThrow(() -> new RuntimeException("Forum not found"));

        // Convertir le DTO en entité
        Sujet sujet = sujetMapper.toEntity(sujetDTO);

        // Assigner le forum
        sujet.setForum(forum);

        // Générer le slug
        sujet.setSlug(SlugifyUtils.generate(sujetDTO.getTitre()));

        // Sauvegarder le sujet dans la base de données
        sujet = sujetRepository.save(sujet);

        // Retourner le DTO correspondant
        return sujetMapper.toDto(sujet);
    }

    @Override
    public List<SujetDTO> getAllSujets() {
        log.debug("Request to get all Sujets");
        List<SujetDTO> sujet = sujetRepository.findAll().stream()
                .map(sujetMapper::toDto)
                .toList();
        log.info("Retrieved {} sujet", sujet.size()); // Journaliser le nombre de Sujet récupérés
        return sujet;
    }



    @Override
    public List<SujetDTO> getSujetsByForumId(Long forumId) {
        log.debug("Request to get Sujets for Forum ID: {}", forumId);
        return sujetRepository.findByForumId(forumId).stream()
                .map(sujetMapper::toDto)
                .toList();
    }

    @Override
    public Optional<SujetDTO> findOneSujetBySlug(String slug) {
        log.debug("Request to get Sujet by slug: {}", slug);
        return sujetRepository.findBySlug(slug).map(sujetMapper::toDto)
                .map(sujetDTO -> {
                    log.info("Sujet found: {}", sujetDTO);
                    return sujetDTO;
                })
                .or(() -> {
                    log.warn("Sujet not found for slug: {}", slug);
                    return Optional.empty();
                });
    }




    @Override
    public Optional<SujetDTO> getSujetById(Long id) {
        log.debug("Request to get Sujet by ID: {}", id);
        return sujetRepository.findById(id).map(sujetMapper::toDto);
    }
}