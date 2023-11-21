package sopt.longBlack.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.bookmark.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
