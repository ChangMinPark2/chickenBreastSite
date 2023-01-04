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
@Transactional
public class SignInService {

    private final UsersRepository usersRepository;

    public void signIn(SignInDto signInDto){
        Optional<Users> users = usersRepository.findByIdentity(signInDto.getIdentity());

        if(!users.isPresent()){
            throw new UsersNotFoundException();
        }
        if(users.get().getPassword().equals(signInDto.getPassword())){
            throw new WrongPasswordException();
        }
    }
}
