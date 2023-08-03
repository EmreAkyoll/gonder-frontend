package com.gonder.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gonder.ws.shared.GenericResponse;

@RestController
public class UserController {
	
	//private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired //dependency injection UserRepository objesini oluşturup buraya setliyor
	UserService userService;
	
	//bu request i alacak metot, formdan aldığımız bilgileri 
	//buraya göndereceğiz
	//post request kullanıcı yaratma requesti
	@PostMapping("/api/1.0/users") //dinlediğimiz url path ini vermeliyiz.
	public GenericResponse createUser(@RequestBody User body) { //(gelen request in içerisindeki body i bize ver, setter ları kullan) o gelen data yı almamız gerekecek 
		userService.save(body);
		GenericResponse response = new GenericResponse();
		response.setMessage("user created");
		return response;
	}

}
