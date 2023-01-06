package kr.co.chikenbreastsite.domain.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class UsersGetDto {
    private String identity;

    private String name;

    private String cellphone;

    private String gender;

    private String birth;

    private String address;

    private String detailAddress;
}
