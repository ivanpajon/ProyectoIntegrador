package Entidades;

public class Maquina {
	private String cod_ma;
	private String nombre;
	private String des;
	private String estado;
	
	public Maquina(String cod_ma, String nombre, String des, String estado) {
		this.cod_ma = cod_ma;
		this.nombre = nombre;
		this.des = des;
		this.estado = estado;
	}
	
	public Maquina() {
		this.cod_ma = "";
		this.nombre = "";
		this.des = "";
		this.estado = "";
	}

	public String getCod_ma() {
		return cod_ma;
	}

	public void setCod_ma(String cod_ma) {
		this.cod_ma = cod_ma;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
