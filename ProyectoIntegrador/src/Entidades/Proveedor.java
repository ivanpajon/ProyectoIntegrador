package Entidades;

public class Proveedor {

	private String cif;
	private String nombre;
	private String correo;
	private String tfno;
	private String direc;
	private String cod_po;
	private String desc;

	public Proveedor(String cif, String nombre, String correo, String tfno, String direc, String cod_po, String desc) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.correo = correo;
		this.tfno = tfno;
		this.direc = direc;
		this.cod_po = cod_po;
		this.desc = desc;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getDirec() {
		return direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public String getCod_po() {
		return cod_po;
	}

	public void setCod_po(String cod_po) {
		this.cod_po = cod_po;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
