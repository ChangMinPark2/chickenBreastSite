package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersGetDto;
import kr.co.chikenbreastsite.domain.entity.users.Gender;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.BusinessLogicException;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UsersGetService {

    private final UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public UsersGetDto usersGet(String identity){
        Users users = usersRepository.findByIdentity(identity)
                .orElseThrow(() -> new UsersNotFoundException());

        return Users.of(users);
    }
}
