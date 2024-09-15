package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.ForumDTO;
import ci.apirest.forum.services.ForumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/forums")
public class ForumResource {

    private final ForumService forumService;

    @PostMapping
    public ResponseEntity<ForumDTO> createForum(@RequestBody ForumDTO forumDTO) {
        log.debug("REST request to save forum {}", forumDTO);

        ForumDTO forumDTO1 = forumService.createformwithSlug(forumDTO);

        return new ResponseEntity<>(forumDTO1, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ForumDTO> getAllForums() {
        log.debug("REST request to get all forums");
        return forumService.getAllForums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getForumById(@PathVariable Long id) {
        log.info("REST Request to get Forum by ID: {}", id);
        Optional<ForumDTO> forumDTO = forumService.findOneForum(id);

        // Vérifier si le forum est présent ou non
        if (forumDTO.isPresent()) {
            return new ResponseEntity<>(forumDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getForumBySlug(@PathVariable String slug) {
        log.info("REST Request to get Forum by slug: {}", slug);
        Optional<ForumDTO> forumDTO = forumService.findOneForumBySlug(slug);

        // Vérifier si le forum est présent ou non
        if (forumDTO.isPresent()) {
            return new ResponseEntity<>(forumDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum by slug not found", HttpStatus.NOT_FOUND);
        }
    }
}