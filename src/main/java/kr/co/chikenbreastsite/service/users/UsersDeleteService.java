package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UserDeleteDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
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
            System.out.println("해당 아이디는 존재하지 않습니다.");
        }

        if(users.get().getPassword() != userDeleteDto.getPassword()){
            System.out.println("비밀번호가 일치하지 않습니다.");
        }

        usersRepository.delete(users.get());
    }
}
