package ci.apirest.forum.services.Impl;

import ci.apirest.forum.models.Message;
import ci.apirest.forum.models.Sujet;
import ci.apirest.forum.repositories.MessageRepository;
import ci.apirest.forum.repositories.SujetRepository;
import ci.apirest.forum.services.DTO.MessageDTO;
import ci.apirest.forum.services.MessageService;
import ci.apirest.forum.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {


    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final SujetRepository sujetRepository;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {
        Message message = messageMapper.toEntity(messageDTO);
        Sujet sujet = sujetRepository.findById(messageDTO.getSujetId()).orElse(null);
        if (sujet != null) {
            message.setSujet(sujet);
            Message savedMessage = messageRepository.save(message);
            return messageMapper.toDto(savedMessage);
        }
        return null;
    }



    @Override
    public List<MessageDTO> getMessagesBySujetId(Long sujetId) {
        List<Message> messages = messageRepository.findBySujetId(sujetId);
        return messages.stream().map(messageMapper::toDto).collect(Collectors.toList());
    }
}
