package ci.apirest.forum.repositories;

import ci.apirest.forum.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    List<Sujet> findByForumId(Long forumId);
}

