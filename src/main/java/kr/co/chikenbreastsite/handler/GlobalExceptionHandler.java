package kr.co.chikenbreastsite.handler;

import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.ResponseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestController가 붙은 모든 API에서 발생한 예외를 가로채줌.
@RestControllerAdvice
public class GlobalExceptionHandler {
    // value(내가만든 예외들, Runtime -> 예외의 최고부모)을 제외하고, 다른 예외가 뜰 경우 fail메시지가 나옴.
    //HttpStatus.OK -> 다른 예외로 인하여 서버가 다운받는 상황이 생길 수 있으므로 OK!
    //Handler는 500에러를 띄움. 500에러는 임의에 에러, 없는에러?
    //ResponseEntity란? ResponseFormat처럼 내가 만든 양식 말고, 스프링이 만든 양식.
    @ExceptionHandler(value = {BusinessLogicException.class, RuntimeException.class})
    public ResponseEntity handlerRuntimeException(RuntimeException e){
        ResponseFormat responseFormat = ResponseFormat.fail(e.getMessage());
        return new ResponseEntity(responseFormat, HttpStatus.OK);
    }
}
