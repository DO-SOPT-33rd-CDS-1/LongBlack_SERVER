package sopt.longBlack.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.dto.response.SinglePostGetResponse;
import sopt.longBlack.infrastructure.PostRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    public SinglePostGetResponse getById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));
        return SinglePostGetResponse.of(post);
    }


}
