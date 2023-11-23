package sopt.longBlack.dto.response;

import java.util.List;

public record PostsGetResponse(
        List<PostInfoResponse> posts
) {
    public static PostsGetResponse of(List<PostInfoResponse> posts) {
        return new PostsGetResponse(posts);
    }
}
