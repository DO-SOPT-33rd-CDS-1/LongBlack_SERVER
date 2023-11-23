package sopt.longBlack.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.domain.likey.Likey;
import sopt.longBlack.domain.paragraph.Paragraph;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.domain.stamp.Stamp;
import sopt.longBlack.dto.response.SinglePostGetResponse;
import sopt.longBlack.infrastructure.BookmarkRepository;
import sopt.longBlack.infrastructure.LikeyRepository;
import sopt.longBlack.infrastructure.ParagraphRepository;
import sopt.longBlack.infrastructure.PostRepository;
import sopt.longBlack.infrastructure.StampRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final LikeyRepository likeyRepository;
    private final StampRepository stampRepository;
    private final BookmarkRepository bookmarkRepository;
    private final ParagraphRepository paragraphRepository;

    public SinglePostGetResponse getById(Long postId) {
        // post 정보 (postId, title, writer, createdDate, postType)
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));
        // like, stamp의 존재 여부 확인
        Optional<Likey> like = likeyRepository.findLikeyByPost(post);
        Optional<Stamp> stamp = stampRepository.findStampByPost(post);
        boolean likeExists = like.isPresent();
        boolean stampExists = stamp.isPresent();
        // bookmark 정보 확인
//        Bookmark bookmark = bookmarkRepository.findByPost(post);
//        Integer bookmarkIdx = null;
//        if (bookmark != null ) {
//            bookmarkIdx = bookmark.getBookmarkIdx();
//        }
        Optional<Bookmark> bookmarkOptional = bookmarkRepository.findByPost(post);
        Integer bookmarkIdx = bookmarkOptional.map(Bookmark::getBookmarkIdx).orElse(null);
        // paragraph 정보 확인
        List<Paragraph> paragraphs = paragraphRepository.findAllByPost(post);
        return SinglePostGetResponse.of(post, likeExists, stampExists, bookmarkIdx, paragraphs);
    }


}
