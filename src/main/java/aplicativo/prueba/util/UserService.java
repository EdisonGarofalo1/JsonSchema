package aplicativo.prueba.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import aplicativo.prueba.Repository.UserRepository;
import aplicativo.prueba.model.User;

public class UserService {
	
	 private final UserRepository userRepository;
	    private final ObjectMapper objectMapper; // Assuming ObjectMapper is configured

	    public UserService(UserRepository userRepository, ObjectMapper objectMapper) {
	        this.userRepository = userRepository;
	        this.objectMapper = objectMapper;
	    }
	    public User createUser(User user)  {
	     
	       
	     
	        return userRepository.save(user);
	    }

}
