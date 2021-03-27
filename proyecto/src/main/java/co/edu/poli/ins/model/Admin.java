package co.edu.poli.ins.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name ="Usuario")
	private String usuario;

	@Column(name ="Contraseña")
	private String contraseña;

	public  Admin () {}
	public Admin (String usuario, String contraseña) {
		this.usuario =  usuario;
		this.contraseña = contraseña;
	}
	//Getters y Setters de los atributos 
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
}
