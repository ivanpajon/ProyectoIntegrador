package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Entidades.Usuarios;
import OracleAccess.OracleAccess;
import Vista.VUsuarios;

public class CUsuarios implements ActionListener, MouseListener {
	VUsuarios vU;
	GUsuarios gUsuarios;
	ArrayList <Usuarios> usuarios = new ArrayList<Usuarios>();
	OracleAccess conexionBBDD;
	//int cod_mat=0;
	
	public CUsuarios(VUsuarios vU, OracleAccess conexionBBDD) {
		this.vU = vU;
		this.conexionBBDD = conexionBBDD;
		this.gUsuarios = new GUsuarios(conexionBBDD.getCn());
		this.gUsuarios.cargarArrayListUsuarios(usuarios);
		
		rellenarTabla();
	}


	public void rellenarTabla() {
		DefaultTableModel tablaModelo = 
				(DefaultTableModel) vU.table.getModel();
		for (Usuarios u : usuarios){
			tablaModelo.addRow(new Object[]
				{u.getID_Socio(), u.getNombre(), u.getApellido(),u.getCorreo(),u.getTLFN(),u.getTipo()});
		}
	
	}
	
	public void limpiarCampos(){
		vU.textFieldID.setText("");
		vU.textFieldNombre.setText("");;
		vU.textFieldApellido.setText("");
		vU.textFieldCorreo.setText("");
		vU.textFieldTFNO.setText("");
		vU.textFieldTipo.setText("");
	}
	
	private void Limpiar_Tabla() {
		DefaultTableModel tablaModelo = (DefaultTableModel) vU.table.getModel();
        while(tablaModelo.getRowCount()>0){
        	tablaModelo.removeRow(0);
        }
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == vU.btnInsertar ){
			insertarUsu();
			Limpiar_Tabla();
			rellenarTabla();  // Metodo de aqui para rellenar la tabla despues de añadir y limpiar
		}else if(obj == vU.btnBorrar){
			Borrar();
			Limpiar_Tabla();
			rellenarTabla();
		}else if(obj == vU.btnModificar){
			modificar();
			Limpiar_Tabla();
			rellenarTabla();
		}
	}
	
	private void modificar() {
		int fila= vU.table.getSelectedRow();
		DefaultTableModel table=
				(DefaultTableModel) vU.table.getModel();
		Usuarios u = new Usuarios();
		u.setID_Socio(Integer.parseInt(vU.textFieldID.getText()));
		u.setNombre(vU.textFieldNombre.getText());
		u.setApellido(vU.textFieldApellido.getText());
		u.setCorreo(vU.textFieldCorreo.getText());
		u.setTLFN(Integer.parseInt(vU.textFieldTFNO.getText()));
		u.setTipo(vU.textFieldTipo.getText());
		usuarios.set( fila,u);
		
		table.setValueAt(u.getID_Socio(), fila, 0);
		table.setValueAt(u.getNombre(), fila, 1);	
		table.setValueAt(u.getApellido(), fila, 2);
		table.setValueAt(u.getCorreo(), fila, 3);
		table.setValueAt(u.getTLFN(), fila, 4);
		table.setValueAt(u.getTipo(), fila, 5);
		
		limpiarCampos();
		gUsuarios.modificarUsu(u);;
		vU.btnModificar.setVisible(false);
	}
		
	private void Borrar() {			
		int fila= vU.table.getSelectedRow();
		DefaultTableModel table=
				(DefaultTableModel) vU.table.getModel();
		table.removeRow(fila);
		gUsuarios.BorrarUsu(usuarios.get(fila).getID_Socio());
		usuarios.remove(fila);
		limpiarCampos();
	}
		
	private void insertarUsu() {
		try{
			Usuarios Usu = new Usuarios();
			
			if (vU.textFieldID.getText().equals("")) {
			vU.lblAviso.setText("El Codigo no puede estar Vacio");
				vU.lblAviso.setVisible(true);
			}
			else if (vU.textFieldTipo.getText().equals("")) {
			vU.lblAviso.setText("El Tipo no puede estar Vacio");
				vU.lblAviso.setVisible(true);
			}
			else if (vU.textFieldNombre.getText().equals("")) {
			vU.lblAviso.setText("El Nombre no puede estar Vacio");
				vU.lblAviso.setVisible(true);
			}
			else if (vU.textFieldApellido.getText().equals("")) {
			vU.lblAviso.setText("El Apellido no puede estar Vacia");
				vU.lblAviso.setVisible(true);
			}
			else {
				try {
					Usu.setID_Socio(Integer.parseInt(vU.textFieldID.getText()));	
					Usu.setNombre(vU.textFieldNombre.getText());
					Usu.setApellido(vU.textFieldApellido.getText());
					Usu.setCorreo(vU.textFieldCorreo.getText());
					Usu.setTLFN(Integer.parseInt(vU.textFieldTFNO.getText()));
					Usu.setTipo(vU.textFieldTipo.getText());
					
					if (gUsuarios.insertarUsu(Usu)) {
						usuarios.add(Usu);
						DefaultTableModel tablaModelo = (DefaultTableModel) vU.table.getModel();
						tablaModelo.addRow(new Object[]{Usu.getID_Socio(), Usu.getNombre(),	Usu.getApellido(), Usu.getCorreo(),	Usu.getTLFN(), Usu.getTipo()});
						
						limpiarCampos();
						
						vU.lblAviso.setVisible(false);
					}
					else {
						vU.lblAviso.setVisible(true);
						vU.lblAviso.setText("No se pudo añadir el usuario");
					}
					
				}
				catch(NumberFormatException e) {
					vU.lblAviso.setText("Los campos ID y Telefono deben ser numéricos");
				}
			}
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Ha habido un error al Insertar...");
		}
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {  //Metodo para clicar el dato de la tabla y visualizarlo en los campos de texto
		Object obj = e.getSource();
		if (obj == vU.table) {
			int fila = vU.table.rowAtPoint(e.getPoint());
			//System.out.println(fila);
			Usuarios u = new Usuarios();
			u = usuarios.get(fila);
			vU.textFieldID.setText(""+u.getID_Socio());
			vU.textFieldNombre.setText(""+u.getNombre());
			vU.textFieldApellido.setText(""+u.getApellido());
			vU.textFieldCorreo.setText(""+u.getCorreo());
			vU.textFieldTFNO.setText(""+u.getTLFN());
			vU.textFieldTipo.setText(""+u.getTipo());
			vU.btnModificar.setVisible(true);
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