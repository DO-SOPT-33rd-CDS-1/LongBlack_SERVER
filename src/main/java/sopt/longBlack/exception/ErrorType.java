package sopt.longBlack.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorType {

    /*
    404 NOT FOUND
     */
    NOT_FOUND_POST_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 포스트입니다."),

    /*
    409 CONFLICT
     */
    BOOKMARK_EXISTS_ALREADY(HttpStatus.CONFLICT, "이미 해당 포스트에 대한 책갈피가 존재합니다."),


    /*
    500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
