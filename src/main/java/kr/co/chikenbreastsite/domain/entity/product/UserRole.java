package kr.co.chikenbreastsite.domain.entity.product;

import kr.co.chikenbreastsite.domain.entity.users.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum UserRole {

    ROLE_ADMIN("관리자"),
    ROLE_USER("일반");

    String userRole;
}
