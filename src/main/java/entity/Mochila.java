package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mochilas")
public class Mochila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	boolean libros;
	boolean estuche;
	boolean bocadillo;
	
	@OneToOne
	@JoinColumn(name="fk_alumno", referencedColumnName = "id")	
	Alumno alumno;
	
	public Mochila() {
		super();
	}
	public Mochila(boolean libros, boolean estuche, boolean bocadillo) {
		super();
		
		this.libros = libros;
		this.estuche = estuche;
		this.bocadillo = bocadillo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLibros() {
		return libros;
	}
	public void setLibros(boolean libros) {
		this.libros = libros;
	}
	public boolean isEstuche() {
		return estuche;
	}
	public void setEstuche(boolean estuche) {
		this.estuche = estuche;
	}
	public boolean isBocadillo() {
		return bocadillo;
	}
	public void setBocadillo(boolean bocadillo) {
		this.bocadillo = bocadillo;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}	
	
	
	
}
