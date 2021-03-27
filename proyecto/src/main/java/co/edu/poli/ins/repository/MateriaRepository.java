package co.edu.poli.ins.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.ins.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, String>{

	@Query("FROM Materia WHERE nrc = ?1")
	List<Materia> findByMateriaId(String materia_id);
	

	@Query("FROM Materia WHERE facultad LIKE %?1%")
	List<Materia> findByFacultad(String f);
	
}
