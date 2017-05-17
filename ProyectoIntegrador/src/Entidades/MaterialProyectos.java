package Entidades;

public class MaterialProyectos {

	private String cod_mt;
	private String cod_pr;
	private int cantidad;

	public MaterialProyectos(String cod_mt, String cod_pr, int cantidad) {
		super();
		this.cod_mt = cod_mt;
		this.cod_pr = cod_pr;
		this.cantidad = cantidad;
	}

	public String getCod_mt() {
		return cod_mt;
	}

	public void setCod_mt(String cod_mt) {
		this.cod_mt = cod_mt;
	}

	public String getCod_pr() {
		return cod_pr;
	}

	public void setCod_pr(String cod_pr) {
		this.cod_pr = cod_pr;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
