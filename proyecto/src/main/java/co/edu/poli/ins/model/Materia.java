package co.edu.poli.ins.model;

import java.util.Set;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="materias")
public class Materia {

	//llave primaria 
	@Id
	@Column(name="NRC")
	private String nrc;

	@Column(name = "MATERIA")
	private String materia;

	@Column(name = "FACULTAD")
	private String facultad;

	@Column(name = "HORAS_CREDITO")
	private String horasCredito;

	@Column(name = "CAMPUS")
	private String campus;

	@Column(name = "PERIODO_ASOCIADO")
	private String periodoAsociado;

	@Column(name = "METODO_EDUCATIVO")
	private String metodoEducativo;




	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name ="Estudiante_Materia",
						joinColumns = {@JoinColumn(name = "Materia_ID")},
						inverseJoinColumns = {@JoinColumn(name = "Estudiante_ID")})
	private Set<Estudiante> estudiantes;
	
	
	
	public Materia() {}

	public Materia(String nrc,String facultad, String materia,String horasCredito,String campus,String periodoAsociado,
			String metodoEducativo) {

		this.nrc = nrc;
		this.facultad= facultad;
		this.materia = materia;
		this.horasCredito = horasCredito;
		this.campus = campus;
		this.periodoAsociado = periodoAsociado;
		this.metodoEducativo = metodoEducativo;
	

	}
	//Getters y Setters de los atributos 

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getHorasCredito() {
		return horasCredito;
	}

	public void setHorasCredito(String horasCredito) {
		this.horasCredito = horasCredito;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodoAsociado() {
		return periodoAsociado;
	}

	public void setPeriodoAsociado(String periodoAsociado) {
		this.periodoAsociado = periodoAsociado;
	}

	public String getMetodoEducativo() {
		return metodoEducativo;
	}

	public void setMetodoEducativo(String metodoEducativo) {
		this.metodoEducativo = metodoEducativo;
	}

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
