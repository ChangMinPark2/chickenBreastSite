package kr.co.chikenbreastsite.controller;

import kr.co.chikenbreastsite.domain.dto.users.*;
import kr.co.chikenbreastsite.exception.ResponseFormat;
import kr.co.chikenbreastsite.service.users.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final SignInService signInService;  //생성자주입

    private final SignUpService signUpService;

    private final UsersUpdateService usersUpdateService;

    private final UsersDeleteService usersDeleteService;

    private final UsersGetService usersGetService;

    private final UsersPasswordUpdateService usersPasswordUpdateService;

    private final UsersCellphoneUpdateService usersCellphoneUpdateService;

    @PostMapping
    public ResponseFormat signUp(@RequestBody @Valid SignUpDto signUpDto){
        signUpService.signUp(signUpDto);
        return ResponseFormat.ok();
    }

    @PostMapping("/login")
    public ResponseFormat signIn(@RequestBody @Valid SignInDto signInDto){
        signInService.signIn(signInDto);
        return ResponseFormat.ok("Login Success");
    }

    @PutMapping("/myPage")
    public ResponseFormat updateUsers(@RequestBody @Valid UsersUpdateDto usersUpdateDto){
        usersUpdateService.userUpdate(usersUpdateDto);
        return ResponseFormat.ok();}

    @PutMapping("/myPage/usersCellphone")
    public ResponseFormat usersUpdateCellphone(@RequestBody @Valid UsersCellphoneUpdateDto usersCellphoneUpdateDto){
        usersCellphoneUpdateService.usersUpdateCellphone(usersCellphoneUpdateDto);
        return ResponseFormat.ok();}

    @PutMapping("/myPage/passwordUpdate")
    public ResponseFormat passwordUpdateUsers(@RequestBody @Valid UsersPasswordUpdateDto usersPasswordUpdateDto){
        usersPasswordUpdateService.usersPasswordUpdate(usersPasswordUpdateDto);
        return ResponseFormat.ok();
    }

    @GetMapping("/myPage")
    public ResponseFormat<UsersGetDto> usersGet(@RequestParam("identity") String identity){
        return ResponseFormat.ok(usersGetService.usersGet(identity));
    }

    @DeleteMapping("/myPage")
    public ResponseFormat deleteUser(@RequestBody @Valid UserDeleteDto userDeleteDto){
        usersDeleteService.UserDelete(userDeleteDto);
        return ResponseFormat.ok();
    }
}
