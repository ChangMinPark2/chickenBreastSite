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
        checkCellPhone(usersRepository.existsByCellphone(usersUpdateDto.getCellphone()),
                users.getCellphone(),
                usersUpdateDto.getCellphone()); //중복 Cellphone체크 메소드

        users.usersUpdate(usersUpdateDto.getName(), usersUpdateDto.getCellphone(), usersUpdateDto.getBirth(),
                usersUpdateDto.getGender(), usersUpdateDto.getAddress(), usersUpdateDto.getDetailedAddress());

        usersRepository.save(users);
    }

    private void checkCellPhone(Boolean othersCellphone, String cellPhone, String newCellphone){
        if(othersCellphone && !cellPhone.equals(newCellphone))
            throw new DuplicationCellPhoneException();
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }

}
