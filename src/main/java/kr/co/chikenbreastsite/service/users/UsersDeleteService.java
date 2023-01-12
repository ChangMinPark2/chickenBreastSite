package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UserDeleteDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDeleteService {
    private final UsersRepository usersRepository;

    public void UserDelete(UserDeleteDto userDeleteDto){
        Users users = usersRepository.findByIdentity(userDeleteDto.getIdentity())
                .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), userDeleteDto.getPassword());
        usersRepository.delete(users);
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }
}
