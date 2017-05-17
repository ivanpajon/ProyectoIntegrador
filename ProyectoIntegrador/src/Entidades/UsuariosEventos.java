package Entidades;

public class UsuariosEventos {
	private String id_soci;
	private String cod_ev;
	
	public UsuariosEventos(String id_soci, String cod_ev) {
		super();
		this.id_soci = id_soci;
		this.cod_ev = cod_ev;
	}

	public String getId_soci() {
		return id_soci;
	}

	public void setId_soci(String id_soci) {
		this.id_soci = id_soci;
	}

	public String getCod_ev() {
		return cod_ev;
	}

	public void setCod_ev(String cod_ev) {
		this.cod_ev = cod_ev;
	}
}
