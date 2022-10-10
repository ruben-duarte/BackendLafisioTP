package com.lafisiotp.lafisiotp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name="calendario")
public class Calendario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9065020740016514730L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="dia")
	private Date dia;
	
	@Column(name="horainicio")
	private LocalDateTime horaInicio;
	
	@Column(name="horafin")
	private LocalDateTime horaFin;
	
	@Column(name="estado")
	private Boolean estado;
	
	@ManyToOne
    @JoinColumn(name = "administrador")
	private Administrador administrador;

	public Calendario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalDateTime horaFin) {
		this.horaFin = horaFin;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(administrador, dia, estado, horaFin, horaInicio, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendario other = (Calendario) obj;
		return Objects.equals(administrador, other.administrador) && Objects.equals(dia, other.dia)
				&& Objects.equals(estado, other.estado) && Objects.equals(horaFin, other.horaFin)
				&& Objects.equals(horaInicio, other.horaInicio) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Calendario [id=" + id + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", estado=" + estado + ", administrador=" + administrador + "]";
	}
	
	
	
}
