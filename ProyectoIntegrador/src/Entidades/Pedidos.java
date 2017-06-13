package Entidades;

import java.util.Date;

public class Pedidos {
	private int cod_pd;
	private Date Fecha;
	private float Tot_importe;
	private String Cif;
	
	public Pedidos(int cod_pd, Date fecha, float tot_importe, String cif) {
		this.cod_pd = cod_pd;
		this.Fecha = fecha;
		this.Tot_importe = tot_importe;
		this.Cif = cif;
	}
	
	public Pedidos() {
		this.cod_pd = 0;
		this.Fecha = new Date();
		this.Tot_importe = 0;
		this.Cif = "";
	}
	
	public int getCod_pd() {
		return cod_pd;
	}
	
	public void setCod_pd(int cod_pd) {
		this.cod_pd = cod_pd;
	}
	
	public Date getFecha() {
		return Fecha;
	}
	
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	public float getTot_importe() {
		return Tot_importe;
	}
	
	public void setTot_importe(float tot_importe) {
		Tot_importe = tot_importe;
	}
	
	public String getCif() {
		return Cif;
	}
	
	public void setCif(String cif) {
		Cif = cif;
	}
}