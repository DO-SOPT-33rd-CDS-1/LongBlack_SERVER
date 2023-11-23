package sopt.longBlack.dto.response;

import sopt.longBlack.domain.post.PostType;

public record PostInfoResponse(
        Long id,
        String title,
        String writer,
        PostType postType,
        String color,
        Boolean like
) {
    public static PostInfoResponse of(Long id, String title, String writer, PostType postType, String color, Boolean like) {
        return new PostInfoResponse(id, title, writer, postType, color, like);
    }
}
