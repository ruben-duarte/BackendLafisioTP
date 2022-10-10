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
@Table(name="historiaclinicas")
public class HistoriaClinica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1642737196780360955L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="antecedentes", length = 200)
	private String antecedentes;
	
	@Column(name="alergias", length = 200)
	private String alergias;
	
	@Column(name="vacunas", length = 200)
	private String vacunas;
	
	@Column(name="intervencionesQuirurgicas")
	private Boolean intervencionesQuirurgicas;
	
	@Column(name="peso")
	private Long peso;
	
	@Column(name="altura")
	private Long altura;
	
	@Column(name="enfermedades", length = 200)
	private String enfermedades;
	
	@Column(name="motivoConsulta", length = 200)
	private String motivoConsulta;
	
	@Column(name="observaciones", length = 200)
	private String observaciones;
	
	@ManyToOne
	@JoinColumn(name = "administrador")
	private Administrador administrador;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "cita")
	private Cita cita;

	
	public HistoriaClinica() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAntecedentes() {
		return antecedentes;
	}


	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}


	public String getAlergias() {
		return alergias;
	}


	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}


	public String getVacunas() {
		return vacunas;
	}


	public void setVacunas(String vacunas) {
		this.vacunas = vacunas;
	}


	public Boolean getIntervencionesQuirurgicas() {
		return intervencionesQuirurgicas;
	}


	public void setIntervencionesQuirurgicas(Boolean intervencionesQuirurgicas) {
		this.intervencionesQuirurgicas = intervencionesQuirurgicas;
	}


	public Long getPeso() {
		return peso;
	}


	public void setPeso(Long peso) {
		this.peso = peso;
	}


	public Long getAltura() {
		return altura;
	}


	public void setAltura(Long altura) {
		this.altura = altura;
	}


	public String getEnfermedades() {
		return enfermedades;
	}


	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}


	public String getMotivoConsulta() {
		return motivoConsulta;
	}


	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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


	public Cita getCita() {
		return cita;
	}


	public void setCita(Cita cita) {
		this.cita = cita;
	}


	@Override
	public int hashCode() {
		return Objects.hash(administrador, alergias, altura, antecedentes, cita, enfermedades, id,
				intervencionesQuirurgicas, motivoConsulta, observaciones, peso, usuario, vacunas);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoriaClinica other = (HistoriaClinica) obj;
		return Objects.equals(administrador, other.administrador) && Objects.equals(alergias, other.alergias)
				&& Objects.equals(altura, other.altura) && Objects.equals(antecedentes, other.antecedentes)
				&& Objects.equals(cita, other.cita) && Objects.equals(enfermedades, other.enfermedades)
				&& Objects.equals(id, other.id)
				&& Objects.equals(intervencionesQuirurgicas, other.intervencionesQuirurgicas)
				&& Objects.equals(motivoConsulta, other.motivoConsulta)
				&& Objects.equals(observaciones, other.observaciones) && Objects.equals(peso, other.peso)
				&& Objects.equals(usuario, other.usuario) && Objects.equals(vacunas, other.vacunas);
	}


	@Override
	public String toString() {
		return "HistoriaClinica [id=" + id + ", antecedentes=" + antecedentes + ", alergias=" + alergias + ", vacunas="
				+ vacunas + ", intervencionesQuirurgicas=" + intervencionesQuirurgicas + ", peso=" + peso + ", altura="
				+ altura + ", enfermedades=" + enfermedades + ", motivoConsulta=" + motivoConsulta + ", observaciones="
				+ observaciones + ", administrador=" + administrador + ", usuario=" + usuario + ", cita=" + cita + "]";
	}
	
}
