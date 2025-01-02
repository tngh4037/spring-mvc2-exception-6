package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// ResponseStatusExceptionResolver 에 의해 처리된다.
// ResponseStatusExceptionResolver 도 HandlerExceptionResolver 를 구현하고, 내부에서 @ResponseStatus 에 설정된 값을 가지고 response.sendError() 로 처리한다.
// 따라서, response.sendError 로 처리하므로 WAS에서 다시 오류페이지(/error)를 내부 요청한다.
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.bad")
public class BadRequestException extends RuntimeException {
}