package com.gonder.ws.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder;
	
//	@Autowired
//	UserRepository userRepository;
//sadece bunun ile yapılan injektion aşağıdaki ile aynı görev görüyo
	//constactır ile injection etme yolu source -> generate constactor
	//spring UserServic i oluştururken constractırı çağırıcak
	//bu constacter da UserRepository e ihtiyaç duyduğundan 
	//UserRepository i oluşturucak oluştuduğu instance ı buraya paslamış olcak.
	//bir constractor olduğu için autowired ı kullanma zorunluluğu yok.
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	
	public void save(User body) {
//		String encryptedPassword = this.passwordEncoder.encode(body.getPassword()););
//		body.setPassword(encryptedPassword);
		body.setPassword(this.passwordEncoder.encode(body.getPassword()));
		userRepository.save(body);
	}

}
