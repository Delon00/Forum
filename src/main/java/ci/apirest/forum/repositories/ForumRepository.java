package ci.apirest.forum.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import ci.apirest.forum.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForumRepository extends JpaRepository<Forum, Long> {
    Optional<Forum> findBySlug(String slug); // Méthode pour trouver un forum par son slug
}

