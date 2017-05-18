package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import OracleAccess.OracleAccess;
import Vista.VEventos;
import Vista.VInicio;

public class CInicio implements ActionListener {
	VInicio vInicio;
	OracleAccess bbdd;

	public CInicio(VInicio vInicio, OracleAccess bbdd) {
		this.vInicio = vInicio;
		this.bbdd = bbdd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == vInicio.btnEventos) {
			abrirEventos();
		}
	}

	private void abrirEventos() {
		VEventos vEventos = new VEventos();
		CEventos cEventos = new CEventos(vEventos, bbdd);
		
		vEventos.setControlador(cEventos);
		vEventos.setVisible(true);
	}

}
