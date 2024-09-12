package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.SujetDTO;
import ci.apirest.forum.services.SujetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/forums/{forumId}/sujets")
//@RequestMapping("/api/sujets/{forumId}")
public class SujetResource {

    private final SujetService sujetService;

    // Créer un nouveau sujet
    @PostMapping
    public ResponseEntity<SujetDTO> createSujet(@PathVariable Long forumId, @RequestBody SujetDTO sujetDTO) {
        log.debug("REST request to create sujet for forum id: {}", forumId);

        // Associer le sujet au forum via son ID
        SujetDTO createdSujetDTO = sujetService.createSujet(sujetDTO);

        return new ResponseEntity<>(createdSujetDTO, HttpStatus.CREATED); // Retourner le sujet créé
    }

    // Récupérer tous les sujets d'un forum
    @GetMapping
    public List<SujetDTO> getSujetsByForumId(@PathVariable Long forumId) {
        log.debug("REST request to get all sujets for forum id: {}", forumId);

        return sujetService.getSujetsByForumId(forumId); // Récupérer la liste des sujets du forum
    }

    // Récupérer un sujet par son ID
    @GetMapping("/{id}")
    public SujetDTO getSujetById(@PathVariable Long id) {
        return sujetService.getSujetDetails(id);
    }


     @GetMapping("/slug/{slug}")
     public ResponseEntity<?> getSujetBySlug(@PathVariable String slug) {
         log.info("REST Request to get Sujet by slug: {}", slug);
         Optional<SujetDTO> sujetDTO = sujetService.findOneSujetBySlug(slug);

         if (sujetDTO.isPresent()) {
             return new ResponseEntity<>(sujetDTO.get(), HttpStatus.OK);
         } else {
             return new ResponseEntity<>("Sujet by slug not found", HttpStatus.NOT_FOUND);
         }
     }
}
