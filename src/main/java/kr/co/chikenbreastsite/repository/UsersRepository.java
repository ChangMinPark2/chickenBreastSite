package kr.co.chikenbreastsite.repository;

import kr.co.chikenbreastsite.domain.entity.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByIdentity(String identity);
    Boolean existsByIdentity(String identity);
    Boolean existsByCellphone(String cellphone);
}
