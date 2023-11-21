package sopt.longBlack.dto.response;

import java.time.LocalDate;
import java.util.List;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.post.Post;

public record SingePostGetResponse(Long id, String title, String writer, LocalDate createdDate, List<Paragraph> paragraphs) {

    public static SingePostGetResponse of(Post post, ) {
        return new SingePostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getWriter(),
                post.getCreatedDate(),

        )
    }

}
