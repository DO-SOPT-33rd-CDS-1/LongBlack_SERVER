package sopt.longBlack.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.domain.post.Post;
import sopt.longBlack.dto.request.BookmarkRequest;
import sopt.longBlack.infrastructure.BookmarkRepository;
import sopt.longBlack.infrastructure.PostRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final PostRepository postRepository;

    @Transactional
    public String postBookMark(BookmarkRequest request, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));

        Bookmark bookmark = bookmarkRepository.save(
                Bookmark.builder()
                        .bookmarkIdx(request.bookmarkIdx())
                        .post(post).build());

        return bookmark.getBookmarkId().toString();

    }

    @Transactional
    public void deleteBookmark(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 포스트가 없습니다."));

        Optional<Bookmark> bookmark = bookmarkRepository.findBookmarkByPost(post);
        if (bookmark.isPresent()) {
            bookmarkRepository.delete(bookmark.get());
        }
    }
}
