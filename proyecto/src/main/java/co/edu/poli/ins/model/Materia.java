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
	private Long nrc;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "MATERIA")
	private String materia;

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
						joinColumns = {@JoinColumn(name = "Estudiante_ID")},
						inverseJoinColumns = {@JoinColumn(name = "Materia_ID")})
	private Set<Estudiante> estudiantes;
	
	
	
	public Materia() {}

	public Materia(Long nrc,String titulo, String materia,String horasCredito,String campus,String periodoAsociado,
			String metodoEducativo) {

		this.nrc = nrc;
		this.titulo = titulo;
		this.materia = materia;
		this.horasCredito = horasCredito;
		this.campus = campus;
		this.periodoAsociado = periodoAsociado;
		this.metodoEducativo = metodoEducativo;

	}
	//Getters y Setters de los atributos 

	public Long getNrc() {
		return nrc;
	}

	public void setNrc(Long nrc) {
		this.nrc = nrc;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
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
	//

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}


}
