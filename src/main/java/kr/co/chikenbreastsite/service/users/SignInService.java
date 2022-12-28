package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.SignInDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class SignInService {

    private final UsersRepository usersRepository;

    public void signIn(SignInDto signInDto){
        Optional<Users> users = usersRepository.findByIdentity(signInDto.getIdentity());


        if(users == null){
            System.out.println("회원정보가 없습니다.");
        }
        if(users.of("password").equals(signInDto.getPassword())){
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
        //TODO : 레포지토리 안에 password와 Dto password를 비교해주고싶은데 users.getPassword를 어디에 정의해야할지 모르겠음.
    }
}
