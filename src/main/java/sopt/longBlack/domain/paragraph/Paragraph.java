package sopt.longBlack.domain.paragraph;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.longBlack.domain.post.Post;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short paragraphId;

    private String content;

    @Column(name = "paragraph_type")
    @Enumerated(EnumType.STRING)
    private ParagraphType paragraphType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Paragraph(String content, ParagraphType paragraphType) {
        this.content = content;
        this.paragraphType = paragraphType;
    }

}
