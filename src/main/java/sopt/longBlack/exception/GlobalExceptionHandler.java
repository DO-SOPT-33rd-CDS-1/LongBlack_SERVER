package sopt.longBlack.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Component
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    /**
     * 404 NOT FOUND
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    protected ErrorResponse<?> handlePostNotFoundException(final RuntimeException e, final HttpServletRequest request) throws IOException {
        log.error("404 error occurred: {}", e.getMessage(), e);
        return ErrorResponse.error(ErrorType.NOT_FOUND_POST_ERROR);
    }

    /**
     * 500 INTERNEL_SERVER
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ErrorResponse<Exception> handleException(final Exception e, final HttpServletRequest request) throws IOException {
        log.error("500 error occured: {}", e.getMessage(), e);
        return ErrorResponse.error(ErrorType.INTERNAL_SERVER_ERROR, e);
    }

}