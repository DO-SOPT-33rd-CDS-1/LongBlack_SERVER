package sopt.longBlack.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.longBlack.dto.request.LikeyRequest;
import sopt.longBlack.service.LikeyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/likey")
public class LikeyController {

    private final LikeyService likeyService;
    private static final String VIEW_API_ENDPOINT = "/api/post";

    @PutMapping
    public ResponseEntity<Void> likeyPost(@RequestBody LikeyRequest request) {
        boolean isCreated = likeyService.modify(request);
        if (isCreated) {
            if (request.isListView()) {
                return ResponseEntity.created(URI.create(VIEW_API_ENDPOINT)).build();
            }
            return ResponseEntity.created(URI.create(VIEW_API_ENDPOINT + "/" + request.postId())).build();
        }
        return ResponseEntity.noContent().build();
    }
}
