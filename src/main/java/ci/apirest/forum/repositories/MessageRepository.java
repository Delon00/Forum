package ci.apirest.forum.repositories;

import ci.apirest.forum.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySujetId(Long sujetId); // Méthode pour trouver un forum par son id
}

