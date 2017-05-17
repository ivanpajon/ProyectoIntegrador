package Entidades;

public class ProyectosUsuarios {
	private String cod_pr;
	private String id_soci;
	
	public ProyectosUsuarios(String cod_pr, String id_soci) {
		super();
		this.cod_pr = cod_pr;
		this.id_soci = id_soci;
	}

	public String getCod_pr() {
		return cod_pr;
	}

	public void setCod_pr(String cod_pr) {
		this.cod_pr = cod_pr;
	}

	public String getId_soci() {
		return id_soci;
	}

	public void setId_soci(String id_soci) {
		this.id_soci = id_soci;
	}
}
