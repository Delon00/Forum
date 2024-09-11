package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.ForumDTO;
import ci.apirest.forum.services.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/forums")
public class ForumResource {

    private final ForumService forumService;

    @PostMapping
    public ForumDTO createForum(@RequestBody ForumDTO forumDTO) {
        return forumService.createForum(forumDTO);
    }

    @GetMapping
    public List<ForumDTO> getAllForums() {
        return forumService.getAllForums();
    }

    @GetMapping("/{id}")
    public ForumDTO getForumById(@PathVariable Long id) {
        return forumService.getForumById(id);
    }
}
