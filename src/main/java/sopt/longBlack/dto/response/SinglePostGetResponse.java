package sopt.longBlack.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.domain.post.PostType;

public record SinglePostGetResponse(Long postId,
                                    String title,
                                    String writer,
                                    LocalDate createdDate,
                                    PostType postType,
                                    boolean like,
                                    boolean stamp,
                                    Integer bookmarkIdx,
                                    List<ParagraphGetResponse> paragraphs
) {

    public static SinglePostGetResponse of(Post post, boolean like, boolean stamp, Integer bookmarkIdx, List<Paragraph> paragraphs) {
        List<ParagraphGetResponse> paragraphResponses = paragraphs.stream()
                .map(paragraph -> ParagraphGetResponse.of(paragraph))
                .collect(Collectors.toList());
        return new SinglePostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getWriter(),
                post.getCreatedDate(),
                post.getPostType(),
                like,
                stamp,
                bookmarkIdx,
                paragraphResponses
        );
    };

}
