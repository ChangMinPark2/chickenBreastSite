package kr.co.chikenbreastsite.domain.dto.users;

import lombok.Getter;

@Getter
public class SignUpDto {
    private String identity;

    private String name;

    private String cellphone;

    private String password;

    private String gender;

    private String birth;

    private String address;

    private String detailAddress;
}
