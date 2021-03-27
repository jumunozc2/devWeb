package co.edu.poli.ins.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.ins.model.Estudiante;
import co.edu.poli.ins.model.Materia;
import co.edu.poli.ins.repository.EstudianteRepository;
import co.edu.poli.ins.repository.MateriaRepository;

@RestController 
@RequestMapping("/api/v1/")
public class EstudianteController {

	@Autowired
	private EstudianteRepository estudianteRepository;


	@PostMapping("/estudiante")
	public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@GetMapping("/estudiantes/{id}")
	public Estudiante getEstudianteById(@PathVariable String id) { 
		Estudiante employee =  estudianteRepository.findById(id).get();
		return employee;
	}

	@DeleteMapping("/estudiante/{id}")
	public Estudiante deleteEstudiante(@PathVariable String id) {
		Estudiante  estudiantedb = estudianteRepository.findById(id).get();
		estudianteRepository.deleteById(id);
		return estudiantedb;
	}
}
