package ci.apirest.forum.web.resources;

import ci.apirest.forum.services.DTO.MessageDTO;
import ci.apirest.forum.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sujets/{sujetId}/messages")
public class MessageResource {


    private final MessageService messageService;

    @PostMapping
    public MessageDTO createMessage(@PathVariable Long sujetId, @RequestBody MessageDTO messageDTO) {
        messageDTO.setSujetId(sujetId);
        return messageService.createMessage(messageDTO);
    }

    @GetMapping
    public List<MessageDTO> getMessagesBySujetId(@PathVariable Long sujetId) {
        return messageService.getMessagesBySujetId(sujetId);
    }
}
