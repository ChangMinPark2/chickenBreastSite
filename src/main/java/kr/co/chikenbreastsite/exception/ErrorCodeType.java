package kr.co.chikenbreastsite.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeType{

    //Common? Success? TODO : common을 왜 써야하는지 모르겠움,
    SUCCESS_NULL(200, "SUCCESS_001", "실행이 성공했고, 응답 데이터는 없습니다."),
    SUCCESS_VALUE(200, "SUCCESS_002", "실행이 성공했고, 응답 데이터는 있습니다."),
    FAIL_NULL(400,"FAIL_001","실행실패입니다."),
    //Users
    USER_NOT_FOUND(400, "MEMBER_001", "해당 회원을 찾을 수 없습니다."),
    WRONG_PASSWORD(400, "MEMBER_002", "비밀번호가 일치하지 않습니다."),
    NEW_PASSWORD(400, "MEMBER_003", "기존 비밀번호와 새로운 비밀번호가 일치합니다."),
    WRONG_NEW_CHECK_PASSWORD(400, "MEMBER_004", "새로운 비밀번호와 확인 비밀번호가 일치하지 않습니다."),
    DUPLICATION_ID(400,"MEMBER_005", "중복된 아이디 입니다."),
    DUPLICATION_CELLPHONE(400,"MEMBER_006", "중복된 전화번호 입니다."),
    REQUIRED_NOT_INPUT(400, "MEMBER_007", "필수 입력 사항을 입력하지 않았습니다."),
    WRONG_CHECK_PASSWORD(400, "MEMBER_008", "비밀번호와 확인 비밀번호가 일치하지 않습니다."),
    USER_NOT_ROLE(400, "MEMBER_009", "해당 유저는 권한이 없습니다."),

    //Product
    DUPLICATION_PRODUCT_NAME(400,"PRODUCT_002", "중복된 상품 이름 입니다."),
    PRODUCT_NOT_FOUND(400,"PRODUCT_003", "해당 상품을 찾을 수 없습니다."),
    PRODUCT_DOES_NOT_ALREADY_EXIST(400,"PRODUCT_004", "해당 상품은 이미 존재하지 않습니다.");
    //내가 만들어논 예외 말고 다른 예외가 올 경우, 서버가 다운 될 수도 있는데, exception handler를 통해서 500 에러를 보내주는 역할을한다.
    private int status;
    private String code;
    private String message;
}
