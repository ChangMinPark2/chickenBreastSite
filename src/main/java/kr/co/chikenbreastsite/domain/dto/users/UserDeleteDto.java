package kr.co.chikenbreastsite.domain.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDeleteDto {
    private String identity;
    private String password;
}
