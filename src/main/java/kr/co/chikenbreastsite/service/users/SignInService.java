package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.SignInDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.ResponseFormat;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class SignInService {

    private final UsersRepository usersRepository;

    public void signIn(SignInDto signInDto){
        Users users = usersRepository.findByIdentity(signInDto.getIdentity())
                .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), signInDto.getPassword());
        ResponseFormat.ok(users);
    }

    private void checkPassword(String originPassword, String password){
        if(!originPassword.equals(password)) throw new WrongPasswordException();
    }
}
