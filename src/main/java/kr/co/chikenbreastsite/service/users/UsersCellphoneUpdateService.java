package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersCellphoneUpdateDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.DuplicationCellPhoneException;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersCellphoneUpdateService {

    private final UsersRepository usersRepository;

    public void usersUpdateCellphone(UsersCellphoneUpdateDto usersCellphoneUpdateDto) {
        Users users = usersRepository.findByIdentity(usersCellphoneUpdateDto.getIdentity())
                .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), usersCellphoneUpdateDto.getPassword());
        duplicationCellphone(usersCellphoneUpdateDto.getIdentity());

        users.usersCellphoneUpdate(usersCellphoneUpdateDto.getCellphone());
        usersRepository.save(users);
    }

    private void checkPassword(String password, String newPassword){
        if(!password.equals(newPassword))
            throw new WrongPasswordException();
    }

    private void duplicationCellphone(String cellphone){
        if(usersRepository.existsByCellphone(cellphone))
            throw new DuplicationCellPhoneException();
    }

}
