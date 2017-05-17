package Entidades;

public class Linea_Pedido {

	private String cod_pr;
	private String cod_mt;
	private int cantidad;
	private int precio_unidad;

	public Linea_Pedido(String cod_pr, String cod_mt, int cantidad, int precio_unidad) {
		super();
		this.cod_pr = cod_pr;
		this.cod_mt = cod_mt;
		this.cantidad = cantidad;
		this.precio_unidad = precio_unidad;
	}

	public String getCod_pr() {
		return cod_pr;
	}

	public void setCod_pr(String cod_pr) {
		this.cod_pr = cod_pr;
	}

	public String getCod_mt() {
		return cod_mt;
	}

	public void setCod_mt(String cod_mt) {
		this.cod_mt = cod_mt;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio_unidad() {
		return precio_unidad;
	}

	public void setPrecio_unidad(int precio_unidad) {
		this.precio_unidad = precio_unidad;
	}

}
