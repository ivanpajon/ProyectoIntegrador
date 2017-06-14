package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import Entidades.Pedidos;
import OracleAccess.OracleAccess;
import Vista.VPedidos;

public class CPedidos implements ActionListener, MouseListener {
	VPedidos Vp;
	GPedidos gPedidos;
	ArrayList<Pedidos> pedid = new ArrayList<>();
	OracleAccess conexionBBDD;
	
	public CPedidos(VPedidos Vp, OracleAccess conexionBBDD) {
		this.Vp = Vp;
		this.conexionBBDD = conexionBBDD;
		this.gPedidos = new GPedidos(conexionBBDD.getCn());
		this.gPedidos.cargarArrayListPedido(pedid);
		
		this.Vp.dateChooser.getJCalendar().setTodayButtonVisible(true);
		this.Vp.dateChooser.getJCalendar().setTodayButtonText("Hoy");
		
		rellenarTabla();
	} 
	
	public void rellenarTabla() {
		DefaultTableModel tablaModelo = 
				(DefaultTableModel) Vp.table.getModel();
		for (Pedidos p : pedid){
			tablaModelo.addRow(new Object[]
				{p.getCod_pd(), p.getFecha(), p.getTot_importe(),p.getCif()});
		}
	}
	
	public void limpiarCampos(){
		Vp.textFieldCodigo.setText("");
		//Vp.Fecha.setText("");
		//Vp.dateChooser.setDate("");
		Vp.textFieldImporte.setText("");
		Vp.textFieldCif.setText("");
	}
	
	private void Limpiar_Tabla() {
		DefaultTableModel tablaModelo = (DefaultTableModel) Vp.table.getModel();
        while(tablaModelo.getRowCount()>0){
        	tablaModelo.removeRow(0);
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == Vp.btnAñadir ){
			Añadir();
			Limpiar_Tabla();
			rellenarTabla();
		}
		else if(obj == Vp.btnBorrar){
			Borrar();
		}
		else if(obj == Vp.btnModificar){
			modificar();
		}
		else if(obj == Vp.btnSalir){
			conexionBBDD.cerrarBBDD();
			System.exit(0);  // Para evitar que intentes abrir otra ventana, ya que la conexion BBDD se cerro
			//Vp.dispose();
		}
	}
	
	private void modificar() {
		if (this.Vp.textFieldCodigo.getText().equals("")) {
			Vp.lblAviso.setForeground(Color.RED);
			Vp.lblAviso.setText("Seleccione una Fecha correcta");
		}
		else {
			String fecha = Vp.dateChooser.getJCalendar().getYearChooser().getYear() + "-" +
			              (Vp.dateChooser.getJCalendar().getMonthChooser().getMonth()+1) + "-" +
			              Vp.dateChooser.getJCalendar().getDayChooser().getDay();
		int fila= Vp.table.getSelectedRow();
		DefaultTableModel table=
				(DefaultTableModel) Vp.table.getModel();
		Pedidos p = new Pedidos();
		p.setCod_pd(Integer.parseInt(Vp.textFieldCodigo.getText()));
		Vp.dateChooser.setDate(p.getFecha());
		p.setTot_importe((Float.parseFloat(Vp.textFieldImporte.getText())));
		p.setCif(Vp.textFieldCif.getText());
		pedid.set( fila, p);
		
		table.setValueAt(p.getCod_pd(), fila, 0);
		table.setValueAt(fecha, fila, 1);	
		table.setValueAt(p.getTot_importe(), fila, 2);
		table.setValueAt(p.getCif(), fila, 3);
		
		gPedidos.modificarPedido(p);
		limpiarCampos();
		Vp.btnModificar.setVisible(false);
		}
	}
	private void Borrar() {
		try{
			int fila= Vp.table.getSelectedRow();
			DefaultTableModel table=
					(DefaultTableModel) Vp.table.getModel();
			table.removeRow(fila);
			gPedidos.BorrarPedido(pedid.get(fila).getCod_pd());
			pedid.remove(fila);
			limpiarCampos();
		}catch(IndexOutOfBoundsException e){
			
		}
	}
	
	private void Añadir() {
		Pedidos Ped = new Pedidos();
		if(Vp.textFieldCif.getText().equals("")){
			Vp.lblAviso.setText("El DNI/CIF no puede estar Vacio");
			Vp.lblAviso.setVisible(true);
		}else if(gPedidos.comprobar_DNI_CIF(Vp.textFieldCif.getText())){
			Vp.lblAviso.setText("El DNI/CIF ya existe en la BBDD");
			Vp.lblAviso.setVisible(true);
		}else{
		Ped.setCif(Vp.textFieldCif.getText());
		if(Vp.textFieldCodigo.getText().equals("")){
			Vp.lblAviso.setText("El Codigo no puede estar Vacio");
			Vp.lblAviso.setVisible(true);
		}else{
			try {
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date today = new Date();
				System.out.println(dateFormat.format(today));
				Vp.dateChooser.setDate(today);
			}
			catch (Exception ex) {
				System.out.println("Error obteniendo fecha - " + ex);
			}
		}
		
		Ped.setTot_importe(Float.parseFloat(Vp.textFieldImporte.getText()));
		pedid.add(Ped);
		DefaultTableModel tablaModelo = (DefaultTableModel) Vp.table.getModel();
			tablaModelo.addRow(new Object[]{
							Ped.getCod_pd(),
							Ped.getFecha(),
							Ped.getTot_importe(),
							Ped.getCif()});
				limpiarCampos();
				gPedidos.insertarPedido(Ped);
				Vp.lblAviso.setVisible(false);
				}
			}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == Vp.table){
			int fila = Vp.table.rowAtPoint(e.getPoint());
			//System.out.println(fila);
			Pedidos p = new Pedidos();
			p = pedid.get(fila);
			Vp.textFieldCodigo.setText(""+p.getCod_pd());
			Vp.dateChooser.setDate(p.getFecha());
			Vp.textFieldImporte.setText(""+p.getTot_importe());
			Vp.textFieldCif.setText(""+p.getCif());
			Vp.btnModificar.setVisible(true);
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}

