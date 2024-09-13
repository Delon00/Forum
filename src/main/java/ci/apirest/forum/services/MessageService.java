package ci.apirest.forum.services;

import ci.apirest.forum.services.DTO.MessageDTO;
import java.util.List;

public interface MessageService {
    MessageDTO createMessage(MessageDTO messageDTO); // Créer un message
    List<MessageDTO> getMessagesBySujetId(Long sujetId); // Récupérer les messages d'un sujet
}