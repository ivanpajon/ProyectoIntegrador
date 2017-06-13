package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import OracleAccess.OracleAccess;
import Vista.VEventos;
import Vista.VInicio;
import Vista.VMaquina;
import Vista.VMaterial;
import Vista.VPedidos;
import Vista.VProveedor;
import Vista.VProyectos;
import Vista.VReservas;
import Vista.VUsuarios;

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
		else if (obj == vInicio.btnReservas) {
			abrirReservas();
		}
		else if (obj == vInicio.btnProveedor) {
			abrirProveedores();
		}
		else if (obj == vInicio.btnMaquina) {
			abrirMaquinas();
		}
		else if (obj == vInicio.btnProyectos) {
			abrirProyectos();
		}
		else if (obj == vInicio.btnMaterial) {
			abrirMateriales();
		}
		else if (obj == vInicio.btnPedidos) {
			abrirPedidos();
		}
		else if (obj == vInicio.btnUsuarios) {
			abrirUsuarios();
		}
	}

	private void abrirUsuarios() {
		VUsuarios vUsuarios = new VUsuarios();
		CUsuarios cUsuarios = new CUsuarios(vUsuarios, bbdd);
		
		vUsuarios.setControlador(cUsuarios);
		vUsuarios.setVisible(true);
	}

	private void abrirPedidos() {
		VPedidos vPedidos = new VPedidos();
		CPedidos cPedidos = new CPedidos(vPedidos, bbdd);
		
		vPedidos.setControlador(cPedidos);
		vPedidos.setVisible(true);
	}

	private void abrirMateriales() {
		VMaterial vMaterial = new VMaterial();
		CMaterial cMaterial = new CMaterial(vMaterial, bbdd);
		
		vMaterial.setControlador(cMaterial);
		vMaterial.setVisible(true);
	}

	private void abrirProyectos() {
		VProyectos vProyectos = new VProyectos();
		CProyectos cProyectos = new CProyectos(vProyectos, bbdd);
		
		vProyectos.setControlador(cProyectos);
		vProyectos.setVisible(true);
	}

	private void abrirMaquinas() {
		VMaquina vMaquina = new VMaquina();
		CMaquina cMaquina = new CMaquina(vMaquina, bbdd);
		
		vMaquina.setControlador(cMaquina);
		vMaquina.setVisible(true);
	}

	private void abrirProveedores() {
		VProveedor vProveedor = new VProveedor();
		CProveedor cProveedor = new CProveedor(vProveedor, bbdd);
		
		vProveedor.setControlador(cProveedor);
		vProveedor.setVisible(true);
	}

	private void abrirReservas() {
		VReservas vReservas = new VReservas();
		CReservas cReservas = new CReservas(vReservas, bbdd);
		
		vReservas.setControlador(cReservas);
		vReservas.setVisible(true);
	}

	private void abrirEventos() {
		VEventos vEventos = new VEventos();
		CEventos cEventos = new CEventos(vEventos, bbdd);
		
		vEventos.setControlador(cEventos);
		vEventos.setVisible(true);
	}

}
