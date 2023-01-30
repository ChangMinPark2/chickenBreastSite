package kr.co.chikenbreastsite.domain.entity.users;

import kr.co.chikenbreastsite.domain.dto.users.SignUpDto;
import kr.co.chikenbreastsite.domain.dto.users.UsersGetDto;
import kr.co.chikenbreastsite.domain.entity.product.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_users")
@NoArgsConstructor// 기본 생성자를 만들어준다.
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true) // 중복을 허용하지 않는다.
    private String identity;

    @Column
    private String name;

    @Column(unique = true)
    private String cellphone;

    @Column
    private String password;

    @Column
    private Gender gender;

    @Column
    private String birth;

    @Column
    private String address;

    @Column
    private String detailAddress;

    @Column
    private UserRole userRole;

    @Builder
    public Users(String identity,
                 String password,
                 String name,
                 String cellphone,
                 String gender, //FEMALE
                 String birth,
                 String address,
                 String detailAddress,
                 String userRole) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.cellphone = cellphone;
        this.gender = Gender.of(gender);
        this.birth = birth;
        this.address = address;
        this.detailAddress = detailAddress;
        this.userRole = UserRole.of(userRole);
    }

    public static Users of(SignUpDto signUpDto){
        return Users.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .cellphone(signUpDto.getCellphone())
                .gender(signUpDto.getGender())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .detailAddress(signUpDto.getDetailedAdress())
                .userRole(signUpDto.getUserRole())
                .build();
    }

    public static UsersGetDto of(Users users){
        return UsersGetDto.builder()
                .identity(users.getIdentity())
                .name(users.getName())
                .cellphone(users.getCellphone())
                .gender(users.getGender().toString())
                .birth(users.getBirth())
                .address(users.getAddress())
                .detailAddress(users.getDetailAddress())
                .build();
    }

    public void usersUpdate(String name,
                           String birth,
                           String gender,
                           String address,
                           String detailAddress){
        this.name = name;
        this.birth = birth;
        this.gender = Gender.of(gender);
        this.address = address;
        this.detailAddress = detailAddress;
    }

    public void passwordUpdate(String password){
        this.password = password;
    }

    public void usersCellphoneUpdate(String cellphone){ this.cellphone = cellphone;}

}
