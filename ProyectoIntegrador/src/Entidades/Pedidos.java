package Entidades;

public class Pedidos {

	private String cod_pd;
	private String fecha;
	private int tot_importe;
	private String cif;

	public Pedidos(String cod_pd, String fecha, int tot_importe, String cif) {
		super();
		this.cod_pd = cod_pd;
		this.fecha = fecha;
		this.tot_importe = tot_importe;
		this.cif = cif;
	}

	public String getCod_pd() {
		return cod_pd;
	}

	public void setCod_pd(String cod_pd) {
		this.cod_pd = cod_pd;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getTot_importe() {
		return tot_importe;
	}

	public void setTot_importe(int tot_importe) {
		this.tot_importe = tot_importe;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

}
