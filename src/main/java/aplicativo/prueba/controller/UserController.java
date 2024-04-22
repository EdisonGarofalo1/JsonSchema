package aplicativo.prueba.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import aplicativo.prueba.model.User;
import aplicativo.prueba.util.JsonSchemaLoader;
import jakarta.validation.Valid;

import com.github.fge.jsonschema.main.JsonSchema;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import javax.validation.Valid;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;


@RestController
public class UserController {
	
	 
	private final JsonSchema userSchema;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserController(ObjectMapper objectMapper) throws Exception {
        this.userSchema = JsonSchemaLoader.loadSchemaFromInputStream(getClass().getResourceAsStream("/json/user-schema.json"));
        this.objectMapper = objectMapper;
    }
	    
	    
	   
	    @PostMapping("/users")
	    public ResponseEntity<String> createUser(@Valid @RequestBody User user) throws ProcessingException, IOException {
	        String json = objectMapper.writeValueAsString(user);
	        ProcessingReport report = userSchema.validate(objectMapper.readTree(json));
	       
	        if (report.isSuccess()) {
	            return ResponseEntity.ok("User created successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON data: " + report.toString());
	        }
	    }
}
