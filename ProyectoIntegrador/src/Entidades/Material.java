package Entidades;

import java.sql.Date;

public class Material {
	private int Cod_mt;
	private Date Fecha;
	private String Nombre;
	private String Descripccion;
	private String Tipo;
	private int Stock;
	
	
	public Material(int cod_mt, Date fecha, String nombre, String descripccion, String tipo, int stock) {
		super();
		Cod_mt = cod_mt;
		Fecha = fecha;
		Nombre = nombre;
		Descripccion = descripccion;
		Tipo = tipo;
		Stock = stock;
	}



	public Material() {
		
	}


	public int getCod_mt() {
		return Cod_mt;
	}


	public void setCod_mt(int cod_mt) {
		Cod_mt = cod_mt;
	}


	public Date getFecha() {
		return Fecha;
	}


	public void setFecha(Date fecha) {
		Fecha = fecha;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getDescripccion() {
		return Descripccion;
	}


	public void setDescripccion(String descripccion) {
		Descripccion = descripccion;
	}


	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public void setStock(int Stock) {
	    this.Stock = Stock;
	}


	public int getStock() {
	    return this.Stock;
	}
	  
}