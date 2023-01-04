package kr.co.chikenbreastsite.controller.users;

import kr.co.chikenbreastsite.domain.dto.users.SignInDto;
import kr.co.chikenbreastsite.domain.dto.users.SignUpDto;
import kr.co.chikenbreastsite.domain.dto.users.UserDeleteDto;
import kr.co.chikenbreastsite.domain.dto.users.UsersUpdateDto;
import kr.co.chikenbreastsite.service.users.SignInService;
import kr.co.chikenbreastsite.service.users.SignUpService;
import kr.co.chikenbreastsite.service.users.UserUpdateService;
import kr.co.chikenbreastsite.service.users.UsersDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final SignInService signInService;  //생성자주입
    private final SignUpService signUpService;
    private final UserUpdateService userUpdateService;
    private final UsersDeleteService usersDeleteService;

    @PostMapping
    public void signUp(@RequestBody SignUpDto signUpDto){
        signUpService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public void signIn(@RequestBody SignInDto signInDto){
        signInService.signIn(signInDto);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody UsersUpdateDto usersUpdateDto){ userUpdateService.userUpdate(usersUpdateDto); }
        //TODO 회원 정보 수정 API

    public void getUser(){
        //TODO 회원 정보 조회 API
    }

    @DeleteMapping
    public void deleteUser(@RequestBody UserDeleteDto userDeleteDto){
        usersDeleteService.UserDelete(userDeleteDto);
    }
}
