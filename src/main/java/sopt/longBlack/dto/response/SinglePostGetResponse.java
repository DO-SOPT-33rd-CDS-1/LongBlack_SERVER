package sopt.longBlack.dto.response;

import java.time.LocalDate;
import java.util.List;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.domain.post.PostType;

public record SinglePostGetResponse(Long id,
                                    String title,
                                    String writer,
                                    LocalDate createdDate,
                                    PostType postType,
                                    boolean like,
                                    boolean stamp,
                                    Integer bookmarkIdx,
                                    List<Paragraph> paragraphs
) {

    public static SinglePostGetResponse of(Post post, boolean like, boolean stamp, Integer bookmarkIdx, List<Paragraph> paragraphs) {
        return new SinglePostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getWriter(),
                post.getCreatedDate(),
                post.getPostType(),
                like,
                stamp,
                bookmarkIdx,
                paragraphs
        );
    };

}
