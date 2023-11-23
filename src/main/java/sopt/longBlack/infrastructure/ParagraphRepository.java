package sopt.longBlack.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.post.Post;

public interface ParagraphRepository extends JpaRepository<Paragraph, Short> {
    List<Paragraph> findAllByPost(Post post);
}
