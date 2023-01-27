package kr.co.chikenbreastsite.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
//목적 : 프론트단 개발자와 원활한 소통을 위해서
//Response : 응답
//Format : 양식 -> 본인 만드는 것. -> 프론트 단 개발자가 이해하기 위해 어떤 양식인지 설명을 해야함.
public class ResponseFormat<T> {

    //result => true : 응답 성공 , false : 응답 실패
    private boolean result;

    //제네릭 : 컴파일을 할 때 미리 데이터 타입을 미리 지정하는 것.
    //data : 성공 시, 전달할 데이터
    private T data;

    //성공 혹은 실패 에 따른 설명 메시지
    private String message;

    //응답 코드
    //2XX : 성공
    //4XX : 실패
    private int status;

    public static ResponseFormat ok(){
        return ResponseFormat.builder()
                .result(true)
                .data(null)
                .message(ErrorCodeType.SUCCESS_NULL.getMessage())
                .status(ErrorCodeType.SUCCESS_NULL.getStatus())
                .build();
    }

    public static <T> ResponseFormat ok(T data){
        return ResponseFormat.builder()
                .result(true)
                .data(data)
                .message(ErrorCodeType.SUCCESS_VALUE.getMessage())
                .status(ErrorCodeType.SUCCESS_VALUE.getStatus())
                .build();
    }

    public static <T> ResponseFormat ok(String message){
        return ResponseFormat.builder()
                .result(true)
                .data(null)
                .message(message)
                .status(ErrorCodeType.SUCCESS_VALUE.getStatus())
                .build();
    }

    public static ResponseFormat fail(String message){
        return ResponseFormat.builder()
                .result(false)
                .data(null)
                .message(ErrorCodeType.FAIL_NULL.getMessage())
                .status(ErrorCodeType.FAIL_NULL.getStatus())
                .build();
    }
}
