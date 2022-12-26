package repository.users;

import domain.entity.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByIdentity(String identity); //아이디찾기 일단 이걸로 시작, 추 후에 Optional로 바꾸기
}
