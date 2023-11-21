package sopt.longBlack.dto.response;

import java.time.LocalDate;
import java.util.List;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.post.Post;

public record SinglePostGetResponse(Long id, String title, String writer, LocalDate createdDate) {

    public static SinglePostGetResponse of(Post post) {
        return new SinglePostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getWriter(),
                post.getCreatedDate()
        );
    };

}
