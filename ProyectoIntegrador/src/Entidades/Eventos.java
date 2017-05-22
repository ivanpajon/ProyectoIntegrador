package Entidades;

public class Eventos {
	private String cod_ev;
	private String fecha;
	private String mentor;
	private String categoria;
	private String duracion;
	private String lugar;
	
	public Eventos(String cod_ev, String fecha, String mentor, String categoria, String duracion, String lugar) {
		this.cod_ev = cod_ev;
		this.fecha = fecha;
		this.mentor = mentor;
		this.categoria = categoria;
		this.duracion = duracion;
		this.lugar = lugar;
	}
	
	public Eventos() {
		this.cod_ev = "";
		this.fecha = "";
		this.mentor = "";
		this.categoria = "";
		this.duracion = "";
		this.lugar = "";
	}

	public String getCod_ev() {
		return cod_ev;
	}

	public void setCod_ev(String cod_ev) {
		this.cod_ev = cod_ev;
	}

	public String getFecha() {
		return fecha;
	}
	
	public String getFechaFormatted() {
		return fecha.substring(0, fecha.indexOf(' '));
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
