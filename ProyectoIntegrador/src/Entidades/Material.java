package Entidades;

public class Material {

	private String cod_mt;
	private String nombre;
	private String des;
	private String tipo;
	private int Stock;

	public Material(String cod_mt, String nombre, String des, String tipo, int stock) {
		super();
		this.cod_mt = cod_mt;
		this.nombre = nombre;
		this.des = des;

		this.tipo = tipo;
		Stock = stock;
	}

	public String getCod_mt() {
		return cod_mt;
	}

	public void setCod_mt(String cod_mt) {
		this.cod_mt = cod_mt;
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

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

}
