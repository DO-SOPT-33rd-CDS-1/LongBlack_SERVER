package sopt.longBlack.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.longBlack.domain.likey.Likey;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.dto.request.LikeyRequest;
import sopt.longBlack.infrastructure.LikeyRepository;
import sopt.longBlack.infrastructure.PostRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeyService {

    private final PostRepository postRepository;
    private final LikeyRepository likeyRepository;

    public boolean modify(LikeyRequest request) {
        Post post = postRepository.findById(request.postId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글입니다."));

        Optional<Likey> likey = likeyRepository.findLikeyByPost(post);
        if (likey.isPresent()) {
            likeyRepository.delete(likey.get());
            return false;
        } else {
            likeyRepository.save(Likey.builder().post(post).build());
            return true;
        }
    }
}
