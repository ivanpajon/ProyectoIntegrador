package Entidades;

public class Usuarios {
	private int ID_Socio;
	private String Nombre;
	private String Apellido;
	private String Correo;
	private int TLFN;
	private String Tipo;
	
	public Usuarios(int iD_Socio, String nombre, String apellido, String correo, int tLFN, String tipo) {
		this.ID_Socio = iD_Socio;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Correo = correo;
		this.TLFN = tLFN;
		this.Tipo = tipo;
	}


	public Usuarios() {
		this.ID_Socio = 0;
		this.Nombre = "";
		this.Apellido = "";
		this.Correo = "";
		this.TLFN = 0;
		this.Tipo = "";
	}
	
	public int getID_Socio() {
		return ID_Socio;
	}
	
	public void setID_Socio(int iD_Socio) {
		ID_Socio = iD_Socio;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getApellido() {
		return Apellido;
	}
	
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public String getCorreo() {
		return Correo;
	}
	
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	public int getTLFN() {
		return TLFN;
	}
	
	public void setTLFN(int tLFN) {
		TLFN = tLFN;
	}
	
	public String getTipo() {
		return Tipo;
	}
	
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
}
