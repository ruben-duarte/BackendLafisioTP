package com.lafisiotp.lafisiotp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cita")
public class Cita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6877038277981719734L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo", length = 100)
	private String tipo;
	
	@Column(name="confirmacion", length = 50)
	private String confirmacion;
	
	@Column(name="recordarCita", length = 50)
	private String recordarCita;
	
	@Column(name="control", length = 50)
	private String control;
	
	@ManyToOne
    @JoinColumn(name = "administrador")
	private Administrador administrador;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "calendario")
	private Calendario calendario;

	
	public Cita() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getConfirmacion() {
		return confirmacion;
	}


	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}


	public String getRecordarCita() {
		return recordarCita;
	}


	public void setRecordarCita(String recordarCita) {
		this.recordarCita = recordarCita;
	}


	public String getControl() {
		return control;
	}


	public void setControl(String control) {
		this.control = control;
	}


	public Administrador getAdministrador() {
		return administrador;
	}


	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Calendario getCalendario() {
		return calendario;
	}


	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}


	@Override
	public int hashCode() {
		return Objects.hash(administrador, calendario, confirmacion, control, id, recordarCita, tipo, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(administrador, other.administrador) && Objects.equals(calendario, other.calendario)
				&& Objects.equals(confirmacion, other.confirmacion) && Objects.equals(control, other.control)
				&& Objects.equals(id, other.id) && Objects.equals(recordarCita, other.recordarCita)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(usuario, other.usuario);
	}


	@Override
	public String toString() {
		return "Cita [id=" + id + ", tipo=" + tipo + ", confirmacion=" + confirmacion + ", recordarCita=" + recordarCita
				+ ", control=" + control + ", administrador=" + administrador + ", usuario=" + usuario + ", calendario="
				+ calendario + "]";
	}
}
