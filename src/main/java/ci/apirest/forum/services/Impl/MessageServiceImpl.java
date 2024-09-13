package ci.apirest.forum.services.Impl;

import ci.apirest.forum.models.Message;
import ci.apirest.forum.models.Sujet;
import ci.apirest.forum.repositories.ForumRepository;
import ci.apirest.forum.repositories.MessageRepository;
import ci.apirest.forum.repositories.SujetRepository;
import ci.apirest.forum.services.DTO.MessageDTO;
import ci.apirest.forum.services.ForumService;
import ci.apirest.forum.services.MessageService;
import ci.apirest.forum.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final SujetRepository sujetRepository;
    private final MessageMapper messageMapper;
    private final ForumService forumService;



    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {
        log.debug("Request to save Message: {}", messageDTO);

        Sujet sujet = sujetRepository.findById(messageDTO.getSujetId())
                .orElseThrow(() -> new RuntimeException("Sujet not found"));


        Message message = messageMapper.toEntity(messageDTO);
        message.setSujet(sujet); // Assigner le sujet au message

        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }

    @Override
    public List<MessageDTO> getMessagesBySujetId(Long sujetId) {
        log.debug("Request to get Messages for Sujet ID: {}", sujetId);
        return messageRepository.findBySujetId(sujetId).stream()
                .map(messageMapper::toDto)
                .toList();
    }

}