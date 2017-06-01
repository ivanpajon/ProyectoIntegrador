package Entidades;

public class Maquina {
	private String cod_ma;
	private String nombre;
	private String des;
	private String tipo;
	
	public Maquina(String cod_ma, String nombre, String des, String tipo) {
		this.cod_ma = cod_ma;
		this.nombre = nombre;
		this.des = des;
		this.tipo = tipo;
	}
	
	public Maquina() {
		this.cod_ma = "";
		this.nombre = "";
		this.des = "";
		this.tipo = "";
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
