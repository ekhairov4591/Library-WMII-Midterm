package wm2.second.assignment.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wm2.second.assignment.library.model.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findFirstByEmail(String Email);

    UserEntity findByEmailAndPassword(String email, String password);

}