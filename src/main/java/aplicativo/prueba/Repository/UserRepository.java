package aplicativo.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicativo.prueba.model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

}
