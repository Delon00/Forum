package ci.apirest.forum.services.Impl;

import ci.apirest.forum.models.Forum;
import ci.apirest.forum.repositories.ForumRepository;
import ci.apirest.forum.services.DTO.ForumDTO;
import ci.apirest.forum.services.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {


    private final ForumRepository forumRepository;

    @Override
    public ForumDTO createForum(ForumDTO forumDTO) {
        Forum forum = new Forum();
        forum.setName(forumDTO.getName());
        forum.setDescription(forumDTO.getDescription());
        Forum savedForum = forumRepository.save(forum);
        return convertToDTO(savedForum);
    }

    @Override
    public List<ForumDTO> getAllForums() {
        List<Forum> forums = forumRepository.findAll();
        return forums.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ForumDTO getForumById(Long id) {
        Forum forum = forumRepository.findById(id).orElse(null);
        return forum != null ? convertToDTO(forum) : null;
    }

    private ForumDTO convertToDTO(Forum forum) {
        ForumDTO forumDTO = new ForumDTO();
        forumDTO.setName(forum.getName());
        forumDTO.setDescription(forum.getDescription());
        return forumDTO;
    }
}

