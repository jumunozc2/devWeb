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
public class EstudianteController {

	@Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/Estudiante")
    public List<Estudiante> getAllEstudiantes(){
        return estudianteRepository.findAll();
    }
    @GetMapping("/Estudiante/{id}")
    public Estudiante getEstudianteByID(@PathVariable String id) {
        return estudianteRepository.findById(id).get();
    }
    @PostMapping("/Estudiante")
    public Estudiante saveEstudiante(@RequestBody Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
    @PutMapping("/Estudiante/{codigo}")
    public Estudiante updateEstudiante(@PathVariable String codigo, @RequestBody Estudiante newEstudiante) {
        Estudiante estudiantedb = estudianteRepository.findById(codigo).get();

        estudiantedb.setCodigo(newEstudiante.getCodigo());
        estudiantedb.setNombres(newEstudiante.getNombres());
        estudiantedb.setApellidos(newEstudiante.getApellidos());

        estudiantedb.setCarrera(newEstudiante.getCelular());
        estudiantedb.setUsuario(newEstudiante.getUsuario());
        estudiantedb.setContrasenia(newEstudiante.getContrasenia());

        estudianteRepository.save(estudiantedb);
        return estudiantedb;
    }
    @PostMapping("/EstudiantePList")
    public List<Estudiante> saveListEstudiantes(@RequestBody List<Estudiante> estudiante) {
        return estudianteRepository.saveAll(estudiante);
    }
    @DeleteMapping("/Estudiante/{id}")
    public Estudiante deleteEstudianteById(@PathVariable String id) {
        Estudiante _estudinate= estudianteRepository.findById(id).get();
        estudianteRepository.deleteById(id);
        return  _estudinate;
    }

    @DeleteMapping("/EstudianteDList")
    public void deleteAll() {
        estudianteRepository.deleteAll();
	}
}
