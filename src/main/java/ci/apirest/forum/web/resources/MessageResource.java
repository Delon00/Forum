package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.MessageDTO;
import ci.apirest.forum.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageResource {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        log.debug("REST request to save Message: {}", messageDTO);
        MessageDTO createdMessage = messageService.createMessage(messageDTO);
        return new ResponseEntity<>(createdMessage, HttpStatus.CREATED);
    }

    @GetMapping("/sujet/{sujetId}")
    public List<MessageDTO> getMessagesBySujetId(@PathVariable Long sujetId) {
        log.debug("REST request to get Messages for Sujet ID: {}", sujetId);
        return messageService.getMessagesBySujetId(sujetId);
    }
}