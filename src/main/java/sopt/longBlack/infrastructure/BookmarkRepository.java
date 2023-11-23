package sopt.longBlack.infrastructure;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.domain.post.Post;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findByPost(Post post);
}
