package sopt.longBlack.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.domain.stamp.Stamp;

public interface StampRepository extends JpaRepository<Stamp, Long> {
    boolean existsByPost(Post post);
}
