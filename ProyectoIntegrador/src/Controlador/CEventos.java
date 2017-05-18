package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import OracleAccess.OracleAccess;
import Vista.VEventos;

public class CEventos implements ActionListener {
	VEventos vEventos;
	OracleAccess bbdd;
	
	public CEventos(VEventos vEventos, OracleAccess bbdd) {
		this.vEventos = vEventos;
		this.bbdd = bbdd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
