package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.SujetDTO;
import ci.apirest.forum.services.SujetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/forums/{forumId}/sujets")
public class SujetResource {
    private final SujetService sujetService;

    @PostMapping
    public SujetDTO createSujet(@PathVariable Long forumId, @RequestBody SujetDTO sujetDTO) {
        sujetDTO.setForumId(forumId);
        return sujetService.createSujet(sujetDTO);
    }

    @GetMapping
    public List<SujetDTO> getSujetsByForumId(@PathVariable Long forumId) {
        return sujetService.getSujetsByForumId(forumId);
    }

    @GetMapping("/{id}")
    public SujetDTO getSujetById(@PathVariable Long id) {
        return sujetService.getSujetById(id);
    }
}
