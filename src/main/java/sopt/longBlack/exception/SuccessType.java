package sopt.longBlack.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessType {

    /*
    200 OK
     */

    SINGLE_POST_GET_SUCCESS(HttpStatus.OK, "단일 게시물 조회 성공"),

    /*
    201 CREATED
     */

    BOOKMARK_POST_SUCCESS(HttpStatus.CREATED, "책갈피 꽂기 성공"),

    /*
    204 NO CONTENT
     */

    BOOKMARK_DELETE_SUCCESS(HttpStatus.OK, "책갈피 삭제 성공");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
