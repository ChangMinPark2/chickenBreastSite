package domain.dto.users;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class UsersUpdateDto {
    private String identity;

    @NotNull(message = "비밀번호를 입력해주세요.") //아무것도 입력하지 않을경우 비밀번호를 입력해주세요가 뜨게하는건데 왜 빨간줄이징.
    //import NotNull이 다른거 발견. Build.gradle 문제인가 ??
    private String password;

    String name;
    String cellphone;
    String birth;
    String gender;
    String address;
    String detailedAdress;

}
