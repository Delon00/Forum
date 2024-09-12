package ci.apirest.forum.services.Impl;

import ci.apirest.forum.models.Forum;
import ci.apirest.forum.repositories.ForumRepository;
import ci.apirest.forum.services.DTO.ForumDTO;
import ci.apirest.forum.services.ForumService;
import ci.apirest.forum.services.mapper.ForumMapper;
import ci.apirest.forum.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {


    private final ForumRepository forumRepository; // Repository pour accéder aux données des forums
    private final ForumMapper forumMapper; // Mapper pour transformer entre Forum et ForumDTO

    @Override
    public ForumDTO createForum(ForumDTO forumDTO) {
        log.debug("Request to save Forum: {}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO); // Convertir ForumDTO en Forum
        forum = forumRepository.save(forum); // Sauvegarder le forum dans la base de données
        log.info("Forum saved successfully with ID: {}", forum.getId()); // Journaliser l'ID du forum créé
        return forumMapper.toDto(forum); // Convertir le forum en ForumDTO et le retourner
    }

    @Override
    public ForumDTO createFormSlug(ForumDTO forumDTO) {
        log.debug("Request to create Forum with slug for: {}", forumDTO.getNom());
        final String slug = SlugifyUtils.generate(forumDTO.getNom()); // Générer un slug à partir du nom du forum
        forumDTO.setSlug(slug); // Assigner le slug au ForumDTO
        log.info("Generated slug: {}", slug); // Journaliser le slug généré
        return createForum(forumDTO); // Créer le forum avec le slug
    }

    @Override
    public Optional<ForumDTO> findOneForumBySlug(String slug) {
        log.debug("Request to get Forum by slug: {}", slug);
        return forumRepository.findBySlug(slug).map(forumMapper::toDto)
                .map(forumDTO -> {
                    log.info("Forum found: {}", forumDTO); // Journaliser les détails du forum trouvé
                    return forumDTO;
                })
                .or(() -> {
                    log.warn("Forum not found for slug: {}", slug); // Journaliser un avertissement si le forum n'est pas trouvé
                    return Optional.empty();
                });
    }


    @Override
    public List<ForumDTO> getAllForums() {
        log.debug("Request to get all Forums");
        List<ForumDTO> forums = forumRepository.findAll().stream()
                .map(forumMapper::toDto)
                .toList();
        log.info("Retrieved {} forums", forums.size()); // Journaliser le nombre de forums récupérés
        return forums;
    }

    @Override
    public Optional<ForumDTO> findOneForum(Long id) {
        log.debug("Request to get Forum by ID: {}", id);
        return forumRepository.findById(id).map(forumMapper::toDto)
                .map(forumDTO -> {
                    log.info("Forum found: {}", forumDTO); // Journaliser les détails du forum trouvé
                    return forumDTO;
                })
                .or(() -> {
                    log.warn("Forum not found for ID: {}", id); // Journaliser un avertissement si le forum n'est pas trouvé
                    return Optional.empty();
                });
    }




}

