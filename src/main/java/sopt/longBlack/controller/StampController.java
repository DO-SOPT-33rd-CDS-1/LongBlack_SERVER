package sopt.longBlack.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sopt.longBlack.dto.response.StampGetResponse;
import sopt.longBlack.service.StampService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stamp")
public class StampController {

    private final StampService stampService;
    private static final String VIEW_API_ENDPOINT = "/api/post/";

    @PostMapping("{postId}")
    public ResponseEntity<Void> createStamp(@PathVariable Long postId) {
        URI location = URI.create(VIEW_API_ENDPOINT + stampService.create(postId));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<StampGetResponse> getStamp() {
        return ResponseEntity.ok(stampService.getCount());
    }
}
