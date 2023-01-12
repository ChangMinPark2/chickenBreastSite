package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersUpdateDto;
import kr.co.chikenbreastsite.domain.entity.users.Gender;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.*;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
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

        if(users.getPassword() != usersUpdateDto.getPassword()){
            throw new WrongPasswordException();
        }

        Boolean isExistIdentity = usersRepository.existsByIdentity(usersUpdateDto.getIdentity());
        Boolean isExistCellphone = usersRepository.existsByCellphone(usersUpdateDto.getCellphone());

        if(isExistIdentity){
            throw new DuplicationIdException(); //중복 ID 예외처리
        }
        if(isExistCellphone){
            throw new DuplicationCellPhoneException(); //중복 휴대폰 번호 예외처리
        }
        // 고치던 도중 builder를 가져올 필요가 없다는 것을 깨닫고 userUpdate로 수정 .!
        users.userUpdate(usersUpdateDto.getName(), usersUpdateDto.getGender(), usersUpdateDto.getCellphone(),
                usersUpdateDto.getDetailedAdress(), usersUpdateDto.getBirth(), usersUpdateDto.getAddress());

        usersRepository.save(users);
    }
}
