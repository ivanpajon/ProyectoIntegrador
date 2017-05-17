package Entidades;

public class Usuarios {
	private String id_soci;
	private String nombre;
	private String apell;
	private String correo;
	private String tfno;
	private String tipo_us;
	
	public Usuarios(String id_soci, String nombre, String apell, String correo, String tfno, String tipo_us) {
		super();
		this.id_soci = id_soci;
		this.nombre = nombre;
		this.apell = apell;
		this.correo = correo;
		this.tfno = tfno;
		this.tipo_us = tipo_us;
	}

	public String getId_soci() {
		return id_soci;
	}

	public void setId_soci(String id_soci) {
		this.id_soci = id_soci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApell() {
		return apell;
	}

	public void setApell(String apell) {
		this.apell = apell;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getTipo_us() {
		return tipo_us;
	}

	public void setTipo_us(String tipo_us) {
		this.tipo_us = tipo_us;
	}
}
