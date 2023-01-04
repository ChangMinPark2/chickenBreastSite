package kr.co.chikenbreastsite.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeType{

    UNKNOWN(400, "COMMON_001", "UNKNOWN"),
    USER_UNAUTHORIZED(400, "COMMON_002", "이 기능을 사용할 수 없는 사용자입니다."),
    //Users
    USER_NOT_FOUND(400, "MEMBER_001", "해당 회원을 찾을 수 없습니다."),
    WRONG_PASSWORD(400, "MEMBER_002", "비밀번호가 틀렸습니다."),
    DPLC_ID(400,"MEMBER_003", "중복된 아이디 입니다."),
    DPLC_CELLPHONE(400,"MEMBER_004", "중복된 전화번호 입니다."),

    INPUT_VALUE_INVALID(400, "COMMON_003", "입력값이 올바르지 않습니다.");

    private int status;
    private String code;
    private String message;
}
