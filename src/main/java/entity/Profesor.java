package entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;	
	
	@Embedded
	Contrato contrato;
	
	@ManyToMany
	@JoinTable(name = "profesores_alumnos",
		joinColumns = {@JoinColumn(name = "fk_profesor", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name="fk_alumno", referencedColumnName = "id")}
	)		
	List<Alumno> alumnos;

	

	public Profesor(String nombre, Contrato contrato, List<Alumno> alumnos) {
		super();		
		this.nombre = nombre;
		this.contrato = contrato;
		this.alumnos = alumnos;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Contrato getContrato() {
		return contrato;
	}


	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
