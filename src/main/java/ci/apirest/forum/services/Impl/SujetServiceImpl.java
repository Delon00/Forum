package ci.apirest.forum.services.Impl;

import ci.apirest.forum.models.Forum;
import ci.apirest.forum.models.Sujet;
import ci.apirest.forum.repositories.ForumRepository;
import ci.apirest.forum.repositories.SujetRepository;

import ci.apirest.forum.services.DTO.SujetDTO;
import ci.apirest.forum.services.SujetService;
import ci.apirest.forum.services.mapper.SujetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final ForumRepository forumRepository;
    private final SujetMapper sujetMapper;

    @Override
    public SujetDTO createSujet(SujetDTO sujetDTO) {
        Sujet sujet = sujetMapper.toEntity(sujetDTO);
        Forum forum = forumRepository.findById(sujetDTO.getForumId()).orElse(null);
        if (forum != null) {
            sujet.setForum(forum);
            Sujet savedSujet = sujetRepository.save(sujet);
            return sujetMapper.toDto(savedSujet);
        }
        return null;
    }

    @Override
    public List<SujetDTO> getSujetsByForumId(Long forumId) {
        List<Sujet> sujets = sujetRepository.findByForumId(forumId);
        return sujets.stream().map(sujetMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public SujetDTO getSujetDetails(Long id) {
        Sujet sujet = sujetRepository.findById(id).orElse(null);
        return sujet != null ? sujetMapper.toDto(sujet) : null;
    }

    @Override
    public Optional<SujetDTO> findOneSujetBySlug(String slug) {
        return Optional.empty();
    }

}
