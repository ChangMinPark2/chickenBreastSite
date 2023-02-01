package kr.co.chikenbreastsite.service.users;

import kr.co.chikenbreastsite.domain.dto.users.UsersGetDto;
import kr.co.chikenbreastsite.domain.entity.users.Users;
import kr.co.chikenbreastsite.exception.users.UsersNotFoundException;
import kr.co.chikenbreastsite.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
