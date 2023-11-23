package sopt.longBlack.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.likey.Likey;
import sopt.longBlack.domain.post.Post;

public interface LikeyRepository extends JpaRepository<Likey, Long> {
    Optional<Likey> findLikeyByPost(Post post);
}
