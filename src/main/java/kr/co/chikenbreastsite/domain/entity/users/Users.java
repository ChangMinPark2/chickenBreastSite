package kr.co.chikenbreastsite.domain.entity.users;

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

    @Builder
    public Users(String identity,
                 String name,
                 String cellphone,
                 String password,
                 String gender, //FEMALE
                 String birth,
                 String address,
                 String detailAddress) {
        this.identity = identity;
        this.name = name;
        this.cellphone = cellphone;
        this.password = password;
        this.gender = Gender.of(gender);
        this.birth = birth;
        this.address = address;
        this.detailAddress = detailAddress;
    }

    public void userUpdate(String name,
                           String cellphone,
                           String birth,
                           String gender,
                           String address,
                           String detailAddress){
        this.name = name;
        this.cellphone = cellphone;
        this.birth = birth;
        this.gender = Gender.of(gender);
        this.address = address;
        this.detailAddress = detailAddress;
    }

    public void passwordUpdate(String password){
        this.password = password;
    }
}
