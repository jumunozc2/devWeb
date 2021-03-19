package co.edu.poli.ins.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="Estudinates")
public class Estudiante {

	@Id
	@Column(name="CODIGO_ESTUDIANTIL")
	private Long codigo;

	@Column(name = "NOMBRES")
	private String nombres;


	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "CARRERA")
	private String carrera;

	@Column(name = "NUMERO_CELULAR")
	private Long celular;

	@ManyToMany (mappedBy="estudiantes")
	@JsonIgnore
	private Set<Materia> materias;
	

	public  Estudiante () {}

	public  Estudiante (Long codigo,String nombres,String apellidos,String carrera,Long celular ) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.carrera = carrera;
		this.celular = celular;

	}
	//Getters y Setters de los atributos 

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}
	//

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}
}
