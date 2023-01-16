package kr.co.chikenbreastsite.controller.users;

import kr.co.chikenbreastsite.domain.dto.users.*;
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

    private final UserUpdateService userUpdateService;

    private final UsersDeleteService usersDeleteService;

    private final UsersGetService usersGetService;

    @PostMapping
    public void signUp(@RequestBody @Valid SignUpDto signUpDto){
        signUpService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public void signIn(@RequestBody @Valid SignInDto signInDto){
        signInService.signIn(signInDto);
    }

    @PutMapping("/myPage")
    public void updateUser(@RequestBody @Valid UsersUpdateDto usersUpdateDto){ userUpdateService.userUpdate(usersUpdateDto); }

    @GetMapping("/myPage")
    public UsersGetDto usersGet(@RequestParam("identity") String identity){
        return usersGetService.usersGet(identity);
    }

    @DeleteMapping("/myPage")
    public void deleteUser(@RequestBody @Valid UserDeleteDto userDeleteDto){
        usersDeleteService.UserDelete(userDeleteDto);
    }
}
