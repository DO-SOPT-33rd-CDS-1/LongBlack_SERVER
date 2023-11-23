package sopt.longBlack.domain.post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.domain.paragraph.Paragraph;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String hexacode;
    private String writer;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_type", length = 10)
    private PostType postType;

    @Builder
    public Post(String title, String hexacode, String writer, LocalDate createdDate, PostType postType) {
        this.title = title;
        this.hexacode = hexacode;
        this.writer = writer;
        this.createdDate = createdDate;
        this.postType = postType;
    }
}
