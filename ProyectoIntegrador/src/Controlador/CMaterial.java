package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;

import Entidades.Material;
import OracleAccess.OracleAccess;
import Vista.VMaterial;
import Vista.VPedidos;

public class CMaterial implements ActionListener, MouseListener {
	VMaterial vM;
	GMaterial gMaterial;
	ArrayList <Material> material = new ArrayList<Material>();
	OracleAccess conexionBBDD;
	
	public CMaterial(VMaterial vM, OracleAccess conexionBBDD) {
		this.vM = vM;
		this.conexionBBDD = conexionBBDD;
		this.gMaterial = new GMaterial(conexionBBDD.getCn());
		this.gMaterial.cargarArrayMaterial(material);
		
		rellenarTabla();
	}
	
	public void rellenarTabla() {
		DefaultTableModel tablaModelo = 
				(DefaultTableModel) vM.table.getModel();
		for (Material m : material){
			tablaModelo.addRow(new Object[]{m.getCod_mt(), m.getNombre(), m.getDescripccion(),m.getTipo(),m.getStock()});
		}
	
	}
	
	public void limpiarCampos(){
		vM.textFieldCodigo.setText("");
		vM.textFieldNombre.setText("");;
		vM.textFieldDescripccion.setText("");
		vM.textFieldTipo.setText("");
		vM.spinner.setValue((0)); 
		vM.textFieldBuscar.setText("");
	}
	
	private void Limpiar_Tabla() {
		DefaultTableModel tablaModelo = (DefaultTableModel) vM.table.getModel();
        while(tablaModelo.getRowCount()>0){
        	tablaModelo.removeRow(0);
        }
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == vM.btnAñadir ){
			Añadir();
			Limpiar_Tabla();
			rellenarTabla();  // Metodo de aqui para rellenar la tabla despues de añadir y limpiar
		}else if(obj == vM.btnBorrar){
			Borrar();
			Limpiar_Tabla();
			rellenarTabla();
		}else if(obj == vM.btnModificar){
			modificar();
			Limpiar_Tabla();
			rellenarTabla();
		}else if(obj == vM.btnBuscar){
			Buscar();
		}else if(obj == vM.btnPedirMaterial){
			pedirMaterial();
		}else if(obj == vM.btnMostrar){
			limpiarCampos();
			Limpiar_Tabla();
			material.clear();
			gMaterial.cargarArrayMaterial(material);
			rellenarTabla();
		}else if(obj == vM.btnSalir){
			conexionBBDD.cerrarBBDD();
			System.exit(0);  // Para evitar que intentes abrir otra ventana, ya que la conexion BBDD se cerro
			//vM.dispose();
		}
	}
	
	private void pedirMaterial() {
		VPedidos vPedidos = new VPedidos();
		CPedidos cPedidos = new CPedidos(vPedidos, conexionBBDD);
		
		vPedidos.setControlador(cPedidos);
		vPedidos.setVisible(true);
	}
	
	private void modificar() {
		int fila= vM.table.getSelectedRow();
		DefaultTableModel table=
				(DefaultTableModel) vM.table.getModel();
		Material m = new Material();
		m.setCod_mt(Integer.parseInt(vM.textFieldCodigo.getText()));
		m.setNombre(vM.textFieldNombre.getText());
		m.setDescripccion(vM.textFieldDescripccion.getText());
		m.setTipo(vM.textFieldTipo.getText());
		m.setStock((int)vM.spinner.getValue());
		System.out.println(m.getStock());
		material.set( fila, m);
		
		table.setValueAt(m.getCod_mt(), fila, 0);
		table.setValueAt(m.getNombre(), fila, 1);	
		table.setValueAt(m.getDescripccion(), fila, 2);
		table.setValueAt(m.getTipo(), fila, 3);
		table.setValueAt(m.getStock(), fila, 4);
		
		limpiarCampos();
		gMaterial.ModificarMaterial(m);;
		vM.btnModificar.setVisible(false);
		
	}
		
	private void Borrar() {
		int fila= vM.table.getSelectedRow();
		DefaultTableModel table=(DefaultTableModel) vM.table.getModel();
		table.removeRow(fila);
		gMaterial.BorrarMaterial(material.get(fila).getCod_mt());
		material.remove(fila);
		limpiarCampos();
	}
		
	private void Añadir() {
		try{
			Material Mat = new Material();
			
			if(vM.textFieldCodigo.getText().equals("")){
				vM.lblAviso.setText("El Codigo no puede estar Vacio");
				vM.lblAviso.setVisible(true);
			}
			else if(vM.textFieldTipo.getText().equals("")){
				vM.lblAviso.setText("El Tipo no puede estar Vacio");
				vM.lblAviso.setVisible(true);
			}
			else if((int)vM.spinner.getValue() == 0){ //PREGUNTAR JAIRO
				vM.lblAviso.setText("El Stock se ha agotado o el campo esta Vacio");
				vM.lblAviso.setVisible(true);
			}
			else if(vM.textFieldNombre.getText().equals("")){
				vM.lblAviso.setText("El Nombre no puede estar Vacio");
				vM.lblAviso.setVisible(true);
			}
			else if(vM.textFieldDescripccion.getText().equals("")){
				vM.lblAviso.setText("La Descripccion no puede estar Vacia");
				vM.lblAviso.setVisible(true);
			}
			else {
				Mat.setCod_mt(Integer.parseInt(vM.textFieldCodigo.getText()));	
				Mat.setNombre(vM.textFieldNombre.getText());
				Mat.setTipo(vM.textFieldTipo.getText());
				Mat.setDescripccion(vM.textFieldDescripccion.getText());
				Mat.setStock((int)vM.spinner.getValue());
				
				DefaultTableModel tablaModelo = (DefaultTableModel) vM.table.getModel();
					tablaModelo.addRow(new Object[]{
									Mat.getCod_mt(),
									Mat.getNombre(),
									Mat.getDescripccion(),
									Mat.getTipo(),
									Mat.getStock()
									});
				
				limpiarCampos();
				gMaterial.InsertaMaterial(Mat);
				vM.lblAviso.setVisible(false);
			}
		}
		catch(Exception e){
			System.out.println("Ocurrió un error añadiendo el material");
		}
	}
		
	private void Buscar() {
		try {
			//Material Mat = new Material();
			ArrayList<Material> array = new ArrayList<Material>();
			gMaterial.BuscarMaterial(Integer.parseInt(vM.textFieldBuscar.getText()), array);
			
			/*vM.textFieldCodigo.setText(""+Mat.getCod_mt());
			vM.textFieldNombre.setText(Mat.getNombre());
			vM.textFieldDescripccion.setText(Mat.getDescripccion());
			vM.textFieldTipo.setText(Mat.getTipo());
			vM.spinner.setValue(Mat.getStock());*/
			
			Limpiar_Tabla();
			material = array;
			rellenarTabla();
			
			vM.lblAviso.setText("");
			vM.lblAviso.setVisible(false);
		}
		catch(NumberFormatException e) {
			vM.lblAviso.setText("El valor debe ser numérico");
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {  //Metodo para clicar el dato de la tabla y visualizarlo en los campos de texto
		Object obj = e.getSource();
		if (obj == vM.table){
			int fila = vM.table.rowAtPoint(e.getPoint());
			//System.out.println(fila);
			Material m = new Material();
			m = material.get(fila);
			vM.textFieldCodigo.setText(""+m.getCod_mt());
			vM.textFieldNombre.setText(""+m.getNombre());
			vM.textFieldDescripccion.setText(""+m.getDescripccion());
			vM.textFieldTipo.setText(""+m.getTipo());
			vM.spinner.setValue(m.getStock());
			vM.btnModificar.setVisible(true);
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
	


