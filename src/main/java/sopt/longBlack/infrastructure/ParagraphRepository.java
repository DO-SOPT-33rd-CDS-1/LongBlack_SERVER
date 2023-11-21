package sopt.longBlack.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.longBlack.domain.paragraph.Paragraph;

public interface ParagraphRepository extends JpaRepository<Paragraph, Short> {
}
