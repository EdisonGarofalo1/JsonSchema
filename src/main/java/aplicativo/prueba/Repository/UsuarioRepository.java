package aplicativo.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicativo.prueba.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
