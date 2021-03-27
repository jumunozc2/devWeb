package co.edu.poli.ins.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="Estudiantes")
public class Estudiante {

	@Id
	@Column(name="CODIGO_ESTUDIANTIL")
	private String codigo;

	@Column(name = "NOMBRES")
	private String nombres;


	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "CARRERA")
	private String carrera;

	@Column(name = "NUMERO_CELULAR")
	private String celular;
	
	@Column(name ="Usuario")
	private String usuario;
	
	@Column(name ="Contraseña")
	private String contraseña;

	@ManyToMany (mappedBy="estudiantes")
	@JsonIgnore
	private Set<Materia> materias;
	

	public  Estudiante () {}

	public  Estudiante (String codigo,String nombres,String apellidos,String carrera,String celular
			,String usuario, String contraseña) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.carrera = carrera;
		this.celular = celular;
		this.usuario =  usuario;
		this.contraseña = contraseña;

	}
	//Getters y Setters de los atributos 

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

	
}
