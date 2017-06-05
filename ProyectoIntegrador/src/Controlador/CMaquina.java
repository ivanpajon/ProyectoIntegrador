package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Entidades.Maquina;
import OracleAccess.OracleAccess;
import Vista.VMaquina;

public class CMaquina implements ActionListener, MouseListener {
	VMaquina vMaquina;
	GMaquina gMaquina;
	OracleAccess bbdd;
	ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
	
	public CMaquina (VMaquina vMaquina, OracleAccess bbdd) {
		this.vMaquina = vMaquina;
		this.bbdd = bbdd;
		this.gMaquina = new GMaquina(bbdd.getCn());
		this.gMaquina.consultarMaquinas(maquinas);
		
		vMaquina.tfCodigo.setEnabled(false);
		vMaquina.btnModificar.setEnabled(false);
		vMaquina.btnBorrar.setEnabled(false);
		
		cargarMaquinas();
	}

	private void cargarMaquinas() {
		for (Maquina m : maquinas) {
			DefaultTableModel tabla = (DefaultTableModel) vMaquina.table.getModel();
			tabla.addRow(new Object[] {m.getCod_ma(), m.getNombre(), m.getDes(), m.getTipo()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == vMaquina.btnInsertar) {
			if (vMaquina.btnInsertar.getText().equals("Insertar")) {
				String codigo = String.valueOf(Integer.parseInt(maquinas.get(maquinas.size()-1).getCod_ma())+1);
				vMaquina.btnInsertar.setText("Guardar");
				vMaquina.btnModificar.setEnabled(false);
				vMaquina.btnBorrar.setEnabled(false);
				limpiar();
				vMaquina.tfCodigo.setText(codigo);
			}
			else {
				vMaquina.btnInsertar.setText("Insertar");
				insertarMaquina();
				limpiar();
			}
		}
		else if (obj == vMaquina.btnModificar) {
			modificarMaquina();
		}
		else if (obj == vMaquina.btnBorrar) {
			borrarMaquina();
		}
	}

	private void borrarMaquina() {
		int fila = vMaquina.table.getSelectedRow();
		
		maquinas.remove(fila);
		DefaultTableModel tabla = (DefaultTableModel) vMaquina.table.getModel();
		tabla.removeRow(fila);
		gMaquina.borrarMaquina(vMaquina.tfCodigo.getText());
		
		this.vMaquina.btnBorrar.setEnabled(false);
		this.vMaquina.btnModificar.setEnabled(false);
		limpiar();
	}

	private void modificarMaquina() {
		Maquina m = new Maquina();
		m.setCod_ma(vMaquina.tfCodigo.getText());
		m.setNombre(vMaquina.tfNombre.getText());
		m.setDes(vMaquina.tfDescripcion.getText());
		m.setTipo(vMaquina.tfTipo.getText());
		
		if (gMaquina.modificarMaquina(m)) {
			DefaultTableModel tabla = (DefaultTableModel) vMaquina.table.getModel();
			int fila = vMaquina.table.getSelectedRow();
			
			maquinas.set(fila, m);
			tabla.setValueAt(m.getCod_ma(), fila, 0);
			tabla.setValueAt(m.getNombre(), fila, 1);
			tabla.setValueAt(m.getDes(), fila, 2);
			tabla.setValueAt(m.getTipo(), fila, 3);
			
			vMaquina.lblError.setForeground(Color.GREEN.darker());
			vMaquina.lblError.setText("La máquina se ha modificado correctamente");
		}
		else {
			vMaquina.lblError.setForeground(Color.RED);
			vMaquina.lblError.setText("Error modificando la máquina");
		}
	}

	private void insertarMaquina() {
		Maquina m = new Maquina();
		m.setCod_ma(vMaquina.tfCodigo.getText());
		m.setNombre(vMaquina.tfNombre.getText());
		m.setDes(vMaquina.tfDescripcion.getText());
		m.setTipo(vMaquina.tfTipo.getText());
		
		if (vMaquina.tfCodigo.getText().equals("") || vMaquina.tfNombre.getText().equals("") || vMaquina.tfDescripcion.getText().equals("") || vMaquina.tfTipo.getText().equals("")) {
			vMaquina.lblError.setForeground(Color.RED);
			vMaquina.lblError.setText("Rellene todos los campos por favor");
		}
		else {
			if (gMaquina.añadirMaquina(m)) {
				DefaultTableModel tabla = (DefaultTableModel) vMaquina.table.getModel();
				tabla.addRow(new Object[] {m.getCod_ma(), m.getNombre(), m.getDes(), m.getTipo()});
				maquinas.add(m);
				
				vMaquina.lblError.setForeground(Color.GREEN.darker());
				vMaquina.lblError.setText("Maquina añadida correctamente");
			}
			else {
				vMaquina.lblError.setForeground(Color.RED);
				vMaquina.lblError.setText("Ocurrió un error al guardar la maquina");
			}
		}
		
	}

	private void limpiar() {
		vMaquina.tfCodigo.setText("");
		vMaquina.tfNombre.setText("");
		vMaquina.tfDescripcion.setText("");
		vMaquina.tfTipo.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vMaquina.table) {
			int fila = vMaquina.table.getSelectedRow();
			
			vMaquina.tfCodigo.setText(maquinas.get(fila).getCod_ma());
			vMaquina.tfNombre.setText(maquinas.get(fila).getNombre());
			vMaquina.tfDescripcion.setText(maquinas.get(fila).getDes());
			vMaquina.tfTipo.setText(maquinas.get(fila).getTipo());
			
			vMaquina.btnModificar.setEnabled(true);
			vMaquina.btnBorrar.setEnabled(true);
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
