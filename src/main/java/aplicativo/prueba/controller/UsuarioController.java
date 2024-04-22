package aplicativo.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aplicativo.prueba.Repository.UsuarioRepository;
import aplicativo.prueba.model.Usuario;
import aplicativo.prueba.util.UsuarioValidator;
@RestController
public class UsuarioController {
	
	
	@Autowired
    private UsuarioRepository usuarioRepository;
	

    @Autowired
    private UsuarioValidator usuarioValidator;

    @PostMapping("/usuarios")
    public ResponseEntity<String> crearUsuario(@Validated @RequestBody Usuario usuario, BindingResult bindingResult) {
       
    	  // Validar los datos utilizando el validador personalizado
        usuarioValidator.validate(usuario, bindingResult);
    	if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Errores de validación: " + bindingResult.getAllErrors());
        }

        // Guardar el usuario en la base de datos
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuario creado correctamente");
    }

}
