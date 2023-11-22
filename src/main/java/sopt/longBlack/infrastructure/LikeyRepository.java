package sopt.longBlack.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.domain.likey.Likey;

public interface LikeyRepository extends JpaRepository<Likey, Long> {
}
