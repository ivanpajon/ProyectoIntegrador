package Entidades;

public class ProyectosMaquina {
	private String cod_pr;
	private String cod_ma;
	private String fecha_inicio;
	private String fecha_fin;
	
	public ProyectosMaquina(String cod_pr, String cod_ma, String fecha_inicio, String fecha_fin) {
		this.cod_pr = cod_pr;
		this.cod_ma = cod_ma;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	
	public ProyectosMaquina() {
		this.cod_pr = "";
		this.cod_ma = "";
		this.fecha_inicio = "";
		this.fecha_fin = "";
	}

	public String getCod_pr() {
		return cod_pr;
	}

	public void setCod_pr(String cod_pr) {
		this.cod_pr = cod_pr;
	}

	public String getCod_ma() {
		return cod_ma;
	}

	public void setCod_ma(String cod_ma) {
		this.cod_ma = cod_ma;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
}
