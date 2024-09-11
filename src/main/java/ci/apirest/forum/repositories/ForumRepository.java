package ci.apirest.forum.repositories;

import ci.apirest.forum.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {
}

