package co.edu.poli.ins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.ins.model.User;
import co.edu.poli.ins.repository.UserRepository;

@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
public class UsersController {
	@Autowired
	UserRepository userRep;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userRep.save(user);
	}

}
