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

    public static UserRole of(String userRole){
        return Arrays.stream(UserRole.values())
                .filter(g -> g.toString().equals(userRole)) //g의 ADMIN, USER가 담기는 것
                .findAny().orElseThrow(() -> new RuntimeException("관리자와 일반인만 있습니다."));
    }
}
