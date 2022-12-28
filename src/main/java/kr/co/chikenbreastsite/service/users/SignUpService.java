package kr.co.chikenbreastsite.service.users;


import kr.co.chikenbreastsite.domain.dto.users.SignUpDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor // final이나 @NotNull이붙은 필드의 생성자를 자동적으로 생성해줌(의존성 주입: 생성자 방법)
@Transactional //DB와 관련된, 트렌젝션이 필요한 서비스클래스 or 메서드의 다 달아주기. (여기서는 Builder를 가져오기 위해서)
public class SignUpService {

    private final UsersRepository usersRepository;

    /*
    * 회원가입 기능
     */
    public void signUp(SignUpDto signUpDto){
        Boolean isExistIdentity = usersRepository.existsByIdentity(signUpDto.getIdentity());
        Boolean isExistCellphone = usersRepository.existsByCellphone(signUpDto.getCellphone());

        if(isExistIdentity){
            System.out.println("아이디가 중복되었습니다.");
        }
        if(isExistCellphone){
            System.out.println("이미 등록된 전화번호입니다.");
        }

        Users usersBuild = Users.builder()
                .identity(signUpDto.getIdentity())
                .password(signUpDto.getPassword())
                .name(signUpDto.getName())
                .gender(signUpDto.getGender())
                .birth(signUpDto.getBirth())
                .address(signUpDto.getAddress())
                .cellphone(signUpDto.getCellphone())
                .detailAddress(signUpDto.getDetailAddress())
                .build();

        usersRepository.save(usersBuild);
    }

    /*
    * 회원정보 조회, 삭제, 업데이트 기능을 구현
    * <마이페이지>안에서 다 사용할 것이지만 우선 다 따로 메소드 만들기.
     */
}
