package aplicativo.prueba.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import aplicativo.prueba.model.Usuario;

@Component

public class UsuarioValidator implements Validator {
	

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "El nombre es obligatorio");
        
        if (usuario.getEdad() < 18) {
            errors.rejectValue("edad", "edad.invalid", "La edad debe ser mayor o igual a 18");
        }
    }

}
