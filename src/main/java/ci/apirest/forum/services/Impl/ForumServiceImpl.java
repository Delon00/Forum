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


    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO createForum(ForumDTO forumDTO) {
        log.debug("Request to save Forum: {}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum = forumRepository.save(forum);
        log.info("Forum saved successfully with ID: {}", forum.getId());
        return forumMapper.toDto(forum);
    }

    @Override
    public ForumDTO createformwithSlug(ForumDTO forumDTO) {
        log.debug("Request to create Forum with slug for: {}", forumDTO.getNom());
        final String slug = SlugifyUtils.generate(forumDTO.getNom());
        forumDTO.setSlug(slug);
        log.info("Generated slug: {}", slug);
        return createForum(forumDTO);
    }

    @Override
    public Optional<ForumDTO> findOneForumBySlug(String slug) {
        log.debug("Request to get Forum by slug: {}", slug);
        return forumRepository.findBySlug(slug).map(forumMapper::toDto)
                .map(forumDTO -> {
                    log.info("Forum found: {}", forumDTO);
                    return forumDTO;
                })
                .or(() -> {
                    log.warn("Forum not found for slug: {}", slug);
                    return Optional.empty();
                });
    }


    @Override
    public List<ForumDTO> getAllForums() {
        log.debug("Request to get all Forums");
        List<ForumDTO> forums = forumRepository.findAll().stream()
                .map(forumMapper::toDto)
                .toList();
        log.info("Retrieved {} forums", forums.size());
        return forums;
    }

    @Override
    public Optional<ForumDTO> findOneForum(Long id) {
        log.debug("Request to get Forum by ID: {}", id);
        return forumRepository.findById(id).map(forumMapper::toDto)
                .map(forumDTO -> {
                    log.info("Forum found: {}", forumDTO);
                    return forumDTO;
                })
                .or(() -> {
                    log.warn("Forum not found for ID: {}", id);
                    return Optional.empty();
                });
    }




}

