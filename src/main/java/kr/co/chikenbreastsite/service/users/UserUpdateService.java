package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersUpdateDto;
import kr.co.chikenbreastsite.domain.entity.users.Gender;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.ErrorCodeType;
import kr.co.chikenbreastsite.exception.users.*;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserUpdateService {
    private final UsersRepository usersRepository;

    public void userUpdate(UsersUpdateDto usersUpdateDto){

        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                 .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), usersUpdateDto.getPassword()); //비밀번호 체크
        checkIdentity(usersUpdateDto.getIdentity()); //중복 id체크 메소드
        checkCellPhone(usersUpdateDto.getCellphone()); //중복 password체크 메소드

        // 고치던 도중 builder를 가져올 필요가 없다는 것을 깨닫고 userUpdate로 수정 .!
        users.userUpdate(usersUpdateDto.getName(), usersUpdateDto.getGender(), usersUpdateDto.getCellphone(),
                usersUpdateDto.getDetailedAdress(), usersUpdateDto.getBirth(), usersUpdateDto.getAddress());

        usersRepository.save(users);
    }

    private void checkIdentity(String identity){
        if(usersRepository.existsByIdentity(identity))
            throw new DuplicationIdException();
    }

    private void checkCellPhone(String cellPhone){
        if(usersRepository.existsByCellphone(cellPhone))
            throw new DuplicationCellPhoneException();
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }

}
