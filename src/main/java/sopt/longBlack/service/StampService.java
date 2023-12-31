package sopt.longBlack.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.domain.stamp.Stamp;
import sopt.longBlack.dto.request.StampCreateRequest;
import sopt.longBlack.dto.response.StampGetResponse;
import sopt.longBlack.infrastructure.PostRepository;
import sopt.longBlack.infrastructure.StampRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StampService {

    private final PostRepository postRepository;
    private final StampRepository stampRepository;

    @Transactional
    public String create(StampCreateRequest request) {
        Post post = postRepository.findById(request.postId()).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글입니다."));

        stampRepository.findStampByPost(post).ifPresent(stamp -> {
            throw new IllegalArgumentException("이미 스탬프가 찍혀있습니다.");
        });
        stampRepository.save(Stamp.builder().post(post).build());

        return post.getPostId().toString();
    }

    public StampGetResponse getCount() {
        return StampGetResponse.of(stampRepository.count());
    }
}
