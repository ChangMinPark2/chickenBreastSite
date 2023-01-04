package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UserDeleteDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersDeleteService {
    private final UsersRepository usersRepository;

    public void UserDelete(UserDeleteDto userDeleteDto){
        Optional<Users> users = usersRepository.findByIdentity(userDeleteDto.getIdentity());
        if(!users.isPresent()){
            throw new UsersNotFoundException();
        }
        if(users.get().getPassword() != userDeleteDto.getPassword()){
            throw new WrongPasswordException();
        }
        usersRepository.delete(users.get());
    }
}
