package co.edu.poli.ins.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class MateriaController {

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@GetMapping("/")
	public String login() {
		return "Usuario Autenticado";
	}
	
	@GetMapping("/books")
	public List<Materia> getAllBooks() {
		// The BookRepository is already injected and you can use it
		return materiaRepository.findAll();
	}



	@PostMapping("/materia")
	public Materia createMateria(@RequestBody Materia materia) {
		return materiaRepository.save(materia);
	}
	
	@GetMapping("/materia/{id}")
	public Materia getMateriaById(@PathVariable String id) { 
		Materia employee =  materiaRepository.findById(id).get();
		return employee;
	}

	@DeleteMapping("/materia/{id}")
	public Materia deleteMateria(@PathVariable String id) {
		Materia  materiadb = materiaRepository.findById(id).get();
		materiaRepository.deleteById(id);
		return materiadb;
	}
	
	@PutMapping("/materia/{nrc}")
    public Materia updateMateria(@PathVariable String nrc, @RequestBody Materia newMateria) {
        Materia materiadb = materiaRepository.findById(nrc).get();

        materiadb.setNrc(newMateria.getNrc());
        materiadb.setMateria(newMateria.getMateria());
        materiadb.setFacultad(newMateria.getFacultad());

        materiadb.setHorasCredito(newMateria.getHorasCredito());
        materiadb.setCampus(newMateria.getCampus());
        materiadb.setPeriodoAsociado(newMateria.getPeriodoAsociado());
        materiadb.setMetodoEducativo(newMateria.getMetodoEducativo());

        materiaRepository.save(materiadb);
        return materiadb;
    }

	//QUERYS
	@GetMapping("/materiaQ1/{materia_id}")
	public List<Materia> filtrar(@PathVariable String materia_id) {
		return materiaRepository.findByMateriaId(materia_id);
		
	}
	@GetMapping("/materiaQ2/{f}")
	public List<Materia> filtrarFacultad(@PathVariable String f) {
		return materiaRepository.findByFacultad(f);
		
	}
}
