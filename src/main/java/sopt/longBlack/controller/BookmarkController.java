package sopt.longBlack.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.longBlack.domain.bookmark.Bookmark;
import sopt.longBlack.dto.request.BookmarkRequest;
import sopt.longBlack.service.BookmarkService;
import sopt.longBlack.service.PostService;

@RestController
@RequestMapping("/api/bookmark")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("{postId}")
    public ResponseEntity<Void> postBookmarkById(@PathVariable Long postId,
                                             @RequestBody BookmarkRequest request) {

        URI location = URI.create("/api/bookmark/" + bookmarkService.postBookMark(request, postId));
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deleteBookmarkById(@PathVariable Long postId) {
        bookmarkService.deleteBookmark(postId);
        return ResponseEntity.noContent().build();
    }

}
