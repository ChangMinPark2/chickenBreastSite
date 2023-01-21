package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersPasswordUpdateDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.NewPasswordException;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.exception.users.WrongCheckPasswordException;
import kr.co.chikenbreastsite.exception.users.WrongPasswordException;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersPasswordUpdateService {

    private final UsersRepository usersRepository;

    public void usersPasswordUpdate(UsersPasswordUpdateDto usersPasswordDto){
        Users users = usersRepository.findByIdentity(usersPasswordDto.getIdentity())
                .orElseThrow(() -> new UsersNotFoundException());

        checkPassword(users.getPassword(), usersPasswordDto.getPassword()); //비밀번호 일치 검사 메소드
        newPasswordCheck(users.getPassword(), usersPasswordDto.getNewPassword()); // 기존 비밀번호와 새로운 비밀번호 검사 메소드
        wrongNewPasswordCheck(usersPasswordDto.getNewPassword(), usersPasswordDto.getCheckPassword()); // 새로운 비밀번호와 확민 비밀번호 메소드

        users.passwordUpdate(usersPasswordDto.getNewPassword());
        usersRepository.save(users);
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }

    private void newPasswordCheck(String Originpassword, String newPassword){
        if(Originpassword.equals(newPassword))
            throw new NewPasswordException();
    }

    private void wrongNewPasswordCheck(String newPassword, String checkPassword){
        if(!newPassword.equals(checkPassword))
            throw new WrongCheckPasswordException();
    }
}
