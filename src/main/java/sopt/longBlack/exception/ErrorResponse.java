package sopt.longBlack.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@JsonPropertyOrder({"code", "success", "status", "data"})
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse<T> {

    private final int code;
    private final boolean success;
    private final String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static ErrorResponse<?> error(ErrorType errorType) {
        return new ErrorResponse<>(errorType.getHttpStatusCode(), false, errorType.getMessage());
    }

    public static ErrorResponse<?> error(ErrorType errorType, String message) {
        return new ErrorResponse<>(errorType.getHttpStatusCode(), false, message);
    }

    public static <T> ErrorResponse<T> error(ErrorType errorType, String message, T data) {
        return new ErrorResponse<>(errorType.getHttpStatusCode(), false, message, data);
    }

    public static <T> ErrorResponse<Exception> error(ErrorType errorType, Exception e) {
        return new ErrorResponse<>(errorType.getHttpStatusCode(), false,  errorType.getMessage(), e);
    }

    public static <T> ErrorResponse<T> error(ErrorType errorType, T data) {
        return new ErrorResponse<>(errorType.getHttpStatusCode(), false, errorType.getMessage(), data);
    }
}
