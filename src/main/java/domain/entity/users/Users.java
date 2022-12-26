package domain.entity.users;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;


@Getter
@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@AllArgsConstructor
//TODO : 이거 왜 빨간줄 일까용 ..

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uno;

    @Column(unique = true) // 중복을 허용하지 않는다.
    private String identity;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String cellphone;

    private String password;
    private String gender;
    private String birth;
    private String address;
    private String detailedAdress;

    public void userUpdate(String name, String cellphone, String birth, String gender,
                           String address, String detailedAdress){
        this.name = name;
        this.cellphone = cellphone;
        this.birth = birth;
        this.gender = gender;
        this.address = address;
        this.detailedAdress = detailedAdress;
    }

    public void passwordUpdate(String password){
        this.password = password;
    }

    @Builder //생성자 주입
    public Users(Long uno, String identity, String name, String cellphone, String password,
                 String gender, String birth, String address, String detailedAdress) {
        this.uno = uno;
        this.identity = identity;
        this.name = name;
        this.cellphone = cellphone;
        this.password = password;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.detailedAdress = detailedAdress;
    }

}
