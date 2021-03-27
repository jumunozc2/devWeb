package co.edu.poli.ins.controller;

import java.util.List;


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
public class MateriaController {

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;


	@PostMapping("/materia")
	public Materia createMateria(@RequestBody Materia materia) {
		return materiaRepository.save(materia);
	}
	
	@GetMapping("/materias/{id}")
	public Materia getMateriaById(@PathVariable String id) { 
		Materia employee =  materiaRepository.findById(id).get();
		return employee;
	}

	@DeleteMapping("/materia/{id}")
	public Materia deleteEstudiante(@PathVariable String id) {
		Materia  estudiantedb = materiaRepository.findById(id).get();
		materiaRepository.deleteById(id);
		return estudiantedb;
	}
	
	@PutMapping("/materias/{mat}/{est}")
	public Materia associate(@PathVariable String mat, @PathVariable String est) {
		
		Materia materia = materiaRepository.findById(mat).get();
		Estudiante estudiante =  estudianteRepository.findById(est).get();
		
		estudiante.getMaterias().add(materia);
		materia.getEstudiantes().add(estudiante);
		
		materiaRepository.save(materia);
		estudianteRepository.save(estudiante);
		
		return materia;
	}
	
	@GetMapping("/materia/{materia_id}")
	public List<Materia> filtrar(@PathVariable String materia_id) {
		return materiaRepository.findByMateriaId(materia_id);
		
	}
	@GetMapping("/materiaF/{f}")
	public List<Materia> filtrarFacultad(@PathVariable String f) {
		return materiaRepository.findByFacultad(f);
		
	}
}
