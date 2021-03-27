package co.edu.poli.ins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.ins.model.Admin;
import co.edu.poli.ins.model.Estudiante;
import co.edu.poli.ins.repository.AdminRepository;
import co.edu.poli.ins.repository.MateriaRepository;



@RestController 
@RequestMapping("/api/v1/")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	


	@PostMapping("/admin")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminRepository.save(admin);
	}

}
