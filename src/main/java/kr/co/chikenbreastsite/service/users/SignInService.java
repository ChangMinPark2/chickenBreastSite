package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.SignInDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class SignInService {

    private final UsersRepository usersRepository;

    public void signIn(SignInDto signInDto){
        Users users = usersRepository.findByIdentity(signInDto.getIdentity())
                .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), signInDto.getPassword());
    }

    private void checkPassword(String originPassword, String password){
        if(!originPassword.equals(password)) throw new WrongPasswordException();
    }
}
