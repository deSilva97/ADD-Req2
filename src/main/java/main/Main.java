package main;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Alumno;
import entity.Contrato;
import entity.Mochila;
import entity.Profesor;
import entity.Tarea;

public class Main {

	public static void main(String[] args) {
		System.out.println("==== INICIO DEL PROGRAMA ====");
		System.out.println("Inicializando...");		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AlumnosJPA");
		EntityManager em = factory.createEntityManager();
			
		System.out.println("Inicialización completada!");		
		
		System.out.println("Generando elementos...");
		//Alumnos
		Alumno diego = new Alumno("Diego", new Date(0), null, null, null);
		Alumno pablo = new Alumno("Pablo", new Date(0), null, null, null);
		Alumno jorge = new Alumno("Jorge", new Date(0), null, null, null);
		Alumno javi = new Alumno("Javi", null, null, null, null);
		Alumno alex = new Alumno("Alex", null, null, null, null);
		//Mochilas
		Mochila mochilaDiego = new Mochila(false, false, false); 
		Mochila mochilaPablo = new Mochila(true, true, true);
		Mochila mochilaJorge = new Mochila(true, true, false);
		Mochila mochilaJavi = new Mochila(true, false, false);
		Mochila mochilaAlex = new Mochila(false, true, false);
		//Tareas
		Tarea tareaDiego1 = new Tarea("ADD", "terminar requerimiento 2", diego);
		Tarea tareaDiego2 = new Tarea("PMD", "terminar unity", diego);
		Tarea tareaDiego3 = new Tarea("DOP", "empezar DevOps...", diego);	
		Tarea tareaPablo1 = new Tarea("PMP", "corregir errores", pablo);
		Tarea tareaPablo2 = new Tarea("ADD", "terminar requerimiento 2", pablo);		
		Tarea tareaJorge1 = new Tarea("ADD", "terminar ADD", jorge);
		//Profesores
	
		Contrato profesor = new Contrato("Educación", "8h", 1200);
		Profesor felix = new Profesor("Felix", profesor, null);
		Profesor raquel = new Profesor("Raquel", profesor, null);
		Profesor raul = new Profesor("Raul", profesor, null);
		
		System.out.println("Generación completada!");
		
		System.out.println("Enlazando tablas... (1/2)");
		
		mochilaDiego.setAlumno(diego);
		mochilaPablo.setAlumno(pablo);
		mochilaJorge.setAlumno(jorge);
		mochilaJavi.setAlumno(javi);
		mochilaAlex.setAlumno(alex);
		
		diego.setMochila(mochilaDiego);
		pablo.setMochila(mochilaPablo);
		jorge.setMochila(mochilaJorge);
		javi.setMochila(null);
		alex.setMochila(mochilaAlex);		
		
			
		ArrayList<Tarea> tareasJorge = new ArrayList<Tarea>();
		tareasJorge.add(tareaJorge1);		
		
		ArrayList<Tarea> tareasDiego = new ArrayList<Tarea>();		
		tareasDiego.add(tareaDiego1);
		tareasDiego.add(tareaDiego2);
		tareasDiego.add(tareaDiego3);
		
		ArrayList<Tarea> tareasPablo = new ArrayList<Tarea>();
		tareasPablo.add(tareaPablo2);
		tareasPablo.add(tareaPablo1);
		
		diego.setTareas(tareasDiego);
		pablo.setTareas(tareasPablo);
		jorge.setTareas(tareasJorge);
		javi.setTareas(null);
		alex.setTareas(null);
		
		
		ArrayList<Profesor> profesoresEdix = new ArrayList<Profesor>();
		ArrayList<Alumno> alumnosEdix = new ArrayList<Alumno>();
		profesoresEdix.add(felix);
		profesoresEdix.add(raquel);
		profesoresEdix.add(raul);
		alumnosEdix.add(diego);
		alumnosEdix.add(pablo);
		alumnosEdix.add(jorge);
		
		diego.setProfesores(profesoresEdix);
		pablo.setProfesores(profesoresEdix);
		jorge.setProfesores(profesoresEdix);
		felix.setAlumnos(alumnosEdix);
		raquel.setAlumnos(alumnosEdix);
		raul.setAlumnos(alumnosEdix);
		
		System.out.println("Enlazando tablas... (2/2)");
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(diego);
		em.persist(pablo);
		em.persist(jorge);
		em.persist(javi);
		em.persist(alex);
		
		et.commit();
		System.out.println("Enlace completado!");
		
		em.close();
		System.out.println("==== FIN DEL PROGRAMA ====");
	}

}
