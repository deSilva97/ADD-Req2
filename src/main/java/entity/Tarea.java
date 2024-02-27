package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tareas")
public class Tarea {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String titulo;
	String descripcion;	
	
	@ManyToOne
	@JoinColumn(name = "fk_alumno", referencedColumnName = "id")
	Alumno alumno;

	
	
	public Tarea(String titulo, String descripcion, Alumno alumno) {
		super();		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.alumno = alumno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
}
