package sopt.longBlack.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
