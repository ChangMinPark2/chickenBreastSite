package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersUpdateDto;
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
        if(usersUpdateDto.getIdentity() == null || usersUpdateDto.getGender() == null || usersUpdateDto.getCellphone() == null ||
        usersUpdateDto.getName() == null || usersUpdateDto.getBirth() == null || usersUpdateDto.getAddress() == null ||
        usersUpdateDto.getCellphone() == null || usersUpdateDto.getDetailedAdress() == null){
            throw new RequiredNotInputException();
        }

        Users users = usersRepository.findByIdentity(usersUpdateDto.getIdentity())
                 .orElseThrow(() -> new UsersNotFoundException());

        if(users.getPassword() != usersUpdateDto.getPassword()){
            throw new WrongPasswordException();
        }

        Boolean isExistIdentity = usersRepository.existsByIdentity(usersUpdateDto.getIdentity());
        Boolean isExistCellphone = usersRepository.existsByCellphone(usersUpdateDto.getCellphone());

        if(isExistIdentity){
            throw new DuplicationIdException();
        }
        if(isExistCellphone){
            throw new DuplicationCellPhoneException();
        }

        Users usersBuild = Users.builder()
                .identity(usersUpdateDto.getIdentity())
                .password(usersUpdateDto.getPassword())
                .name(usersUpdateDto.getName())
                .gender(usersUpdateDto.getGender())
                .birth(usersUpdateDto.getBirth())
                .address(usersUpdateDto.getAddress())
                .cellphone(usersUpdateDto.getCellphone())
                .detailAddress(usersUpdateDto.getDetailedAdress())
                .build();
        usersRepository.save(usersBuild);
    }
}
