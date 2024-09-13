package ci.apirest.forum.repositories;

import ci.apirest.forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    List<Sujet> findByForumId(Long forumId); // Récupérer les sujets par ID du forum
    Optional<Sujet> findBySlug(String slug); // Récupérer un sujet par slug
}

