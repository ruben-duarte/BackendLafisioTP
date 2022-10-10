package com.lafisiotp.lafisiotp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4236282722886006737L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cedula")
	private Long cedula;
	
	@Column(name="nombre", length = 50)
	private String nombre;
	
	@Column(name="apellido", length = 50)
	private String apellido;
	
	@Column(name="contrasenia", length = 50)
	private String contrasenia;

	
	public Administrador() {
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCedula() {
		return cedula;
	}

	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellido, cedula, contrasenia, id, nombre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(cedula, other.cedula)
				&& Objects.equals(contrasenia, other.contrasenia) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre);
	}


	@Override
	public String toString() {
		return "Administrador [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", contrasenia=" + contrasenia + "]";
	}
	
	
}
