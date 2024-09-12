package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.ForumDTO;
import ci.apirest.forum.services.DTO.SujetDTO;
import ci.apirest.forum.services.SujetService;
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
@RequestMapping("/api/sujets")
public class SujetResource {

    private final SujetService sujetService;

    @PostMapping
    public ResponseEntity<SujetDTO> createSujet(@RequestBody SujetDTO sujetDTO) {
        log.debug("REST request to save Sujet: {}", sujetDTO);
        SujetDTO createdSujet = sujetService.createSujet(sujetDTO);
        return new ResponseEntity<>(createdSujet, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SujetDTO> getAllSujets() {
        log.debug("REST request to get all forums");
        return sujetService.getAllSujets(); // Récupérer tous les sujets
    }

    @GetMapping("/forum/{forumId}")
    public List<SujetDTO> getSujetsByForumId(@PathVariable Long forumId) {
        log.debug("REST request to get Sujets for Forum ID: {}", forumId);
        return sujetService.getSujetsByForumId(forumId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SujetDTO> getSujetById(@PathVariable Long id) {
        log.info("REST Request to get Sujet by ID: {}", id);
        Optional<SujetDTO> sujetDTO = sujetService.getSujetById(id);
        return sujetDTO.map(sujet -> new ResponseEntity<>(sujet, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getSujetBySlug(@PathVariable String slug) {
        log.info("REST Request to get Sujet by slug: {}", slug);
        Optional<SujetDTO> sujetDTO = sujetService.findOneSujetBySlug(slug);

        // Vérifier si le sujet est présent ou non
        if (sujetDTO.isPresent()) {
            return new ResponseEntity<>(sujetDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sujet by slug not found", HttpStatus.NOT_FOUND); // Sujet non trouvé
        }
    }
}