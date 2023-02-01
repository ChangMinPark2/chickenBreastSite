package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersUpdateDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.*;
import kr.co.chikenbreastsite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersUpdateService {
    private final UsersRepository usersRepository;

    public void userUpdate(UsersUpdateDto usersUpdateDto){

        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                 .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), usersUpdateDto.getPassword()); //비밀번호 체크

        users.usersUpdate(usersUpdateDto.getName(), usersUpdateDto.getBirth(), usersUpdateDto.getGender(),
                usersUpdateDto.getAddress(), usersUpdateDto.getDetailedAddress());

        usersRepository.save(users);
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }

}
