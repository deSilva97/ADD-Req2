package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;
		
	@Temporal(TemporalType.DATE)
	Date fechaMatricula;
	
	@OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL)
	Mochila mochila;

	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
	List<Tarea> tareas;
	
	@ManyToMany(mappedBy = "alumnos", cascade = CascadeType.PERSIST)
	List<Profesor> profesores;
	
	
	
	public Alumno(String nombre, Date fechaMatricula, Mochila mochila, List<Tarea> tareas,
			List<Profesor> profesores) {
		super();		
		this.nombre = nombre;
		this.fechaMatricula = fechaMatricula;
		this.mochila = mochila;
		this.tareas = tareas;
		this.profesores = profesores;
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

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Mochila getMochila() {
		return mochila;
	}

	public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	
	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	
	
	
}
