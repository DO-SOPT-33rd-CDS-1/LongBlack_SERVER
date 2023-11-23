package sopt.longBlack.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.domain.stamp.Stamp;

public interface StampRepository extends JpaRepository<Stamp, Long> {
    Optional<Stamp> findStampByPost(Post post);
}
