package kr.co.chikenbreastsite.domain.dto.users;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UsersUpdateDto {

    private String identity;

   @NotNull(message = "비밀번호를 입력해주세요.")
    private String password;

    String name;

    String cellphone;

    String birth;

    String gender;

    String address;

    String detailedAdress;

}
