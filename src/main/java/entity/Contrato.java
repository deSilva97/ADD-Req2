package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contrato {

	String tipo;
	String horario;
	int salario;
	
	public Contrato() {
		super();
	}

	public Contrato(String tipo, String horario, int salario) {
		super();
		this.tipo = tipo;
		this.horario = horario;
		this.salario = salario;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
}
