package Entidades;

public class Proyectos {

	private String cod_pr;
	private String nombre;
	private String des;

	public Proyectos(String cod_pr, String nombre, String des) {
		super();
		this.cod_pr = cod_pr;
		this.nombre = nombre;
		this.des = des;
	}

	public String getCod_pr() {
		return cod_pr;
	}

	public void setCod_pr(String cod_pr) {
		this.cod_pr = cod_pr;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
