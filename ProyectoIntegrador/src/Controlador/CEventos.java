package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Entidades.Eventos;
import OracleAccess.OracleAccess;
import Vista.VEventos;

public class CEventos implements ActionListener, MouseListener {
	VEventos vEventos;
	GEventos gEventos;
	OracleAccess bbdd;
	ArrayList<Eventos> eventos = new ArrayList<Eventos>();
	
	public CEventos(VEventos vEventos, OracleAccess bbdd) {
		this.vEventos = vEventos;
		this.bbdd = bbdd;
		this.gEventos = new GEventos(bbdd.getCn());
		this.gEventos.consultarEventos(eventos);
		
		this.vEventos.tfCodigo.setEnabled(false);
		
		cargarEventos();
	}
	
	private void cargarEventos() {
		for (Eventos e : eventos) {
			DefaultTableModel tabla = (DefaultTableModel) vEventos.table.getModel();
			tabla.addRow(new Object[] {e.getCod_ev(), e.getFecha().substring(0, e.getFecha().indexOf(' ')), e.getMentor(), e.getCategoria(), e.getDuracion(), e.getLugar()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == vEventos.btnInsertar) {
			if (vEventos.btnInsertar.getText().equals("Insertar")) {
				limpiar();
				vEventos.tfCodigo.setText(String.valueOf(Integer.parseInt(eventos.get(eventos.size()-1).getCod_ev())+1));
				vEventos.btnInsertar.setText("Guardar");
				vEventos.btnModificar.setEnabled(false);
				vEventos.btnBorrar.setEnabled(false);
			}
			else if (vEventos.btnInsertar.getText().equals("Guardar")) {
				añadirEvento();
				vEventos.btnInsertar.setText("Insertar");
				vEventos.btnModificar.setEnabled(true);
				vEventos.btnBorrar.setEnabled(true);
			}
		}
		else if (obj == vEventos.btnBorrar) {
			eliminarEvento();
		}
		else if (obj == vEventos.btnModificar) {
			modificarEvento();
		}
	}
	
	private void modificarEvento() {
		Eventos e = new Eventos(vEventos.tfCodigo.getText(), vEventos.tfFecha.getText(), vEventos.tfMentor.getText(), vEventos.tfCategoria.getText(), vEventos.tfDuracion.getText(), vEventos.tfLugar.getText());
		gEventos.modificarEvento(vEventos, e);
		
		DefaultTableModel tabla = (DefaultTableModel) vEventos.table.getModel();
		int fila = vEventos.table.getSelectedRow();
		tabla.setValueAt(e.getCod_ev(), fila, 0);
		tabla.setValueAt(e.getFecha(), fila, 1);
		tabla.setValueAt(e.getMentor(), fila, 2);
		tabla.setValueAt(e.getCategoria(), fila, 3);
		tabla.setValueAt(e.getDuracion(), fila, 4);
		tabla.setValueAt(e.getLugar(), fila, 5);
	}

	private void eliminarEvento() {
		if (vEventos.tfCodigo.getText().equals("")) {
			vEventos.lblError.setForeground(Color.RED);
			vEventos.lblError.setText("Haga clic en el evento que desea borrar por favor");
		}
		
		else {
			int cod = Integer.parseInt(vEventos.tfCodigo.getText());
			// Eliminar el evento de la base de datos
			if (gEventos.eliminarEvento(cod)) {
				// Eliminar el evento de la tabla
				DefaultTableModel tabla = (DefaultTableModel) vEventos.table.getModel();
				int fila = vEventos.table.getSelectedRow();
				tabla.removeRow(fila);
				eventos.remove(fila);
				
				vEventos.lblError.setForeground(Color.GREEN.darker());
				vEventos.lblError.setText("Evento eliminado correctamente");
			}
			
			else {
				vEventos.lblError.setForeground(Color.RED);
				vEventos.lblError.setText("El evento no se pudo eliminar");
			}
			limpiar();
		}
	}

	private void añadirEvento() {
		if (vEventos.table.getRowCount() >= 0) {
			vEventos.btnBorrar.setEnabled(true);
			vEventos.btnModificar.setEnabled(true);
		}
		if (this.vEventos.tfCodigo.getText().equals("") || this.vEventos.tfFecha.getText().equals("") || this.vEventos.tfMentor.getText().equals("") || this.vEventos.tfCategoria.getText().equals("") || this.vEventos.tfDuracion.getText().equals("") || this.vEventos.tfLugar.getText().equals("")) {
			vEventos.lblError.setForeground(Color.RED);
			vEventos.lblError.setText("Rellene todos los campos por favor");
			//JOptionPane.showMessageDialog(null, "Rellene todos los campos por favor");
			limpiar();
		}
		else {
			Eventos e = new Eventos(vEventos.tfCodigo.getText(), vEventos.tfFecha.getText(), vEventos.tfMentor.getText(), vEventos.tfCategoria.getText(), vEventos.tfDuracion.getText(), vEventos.tfLugar.getText());
			eventos.add(e);
			
			// Añadir el evento a la tabla
			DefaultTableModel tabla = (DefaultTableModel) vEventos.table.getModel();
			tabla.addRow(new Object[] {e.getCod_ev(), e.getFecha(), e.getMentor(), e.getCategoria(), e.getDuracion(), e.getLugar()});
			
			// Añadir el evento a la base de datos
			gEventos.añadirEvento(e);
			limpiar();
			vEventos.lblError.setForeground(Color.GREEN.darker());
			vEventos.lblError.setText("Evento añadido correctamente");
		}
	}
	
	public void limpiar() {
		vEventos.tfCodigo.setText("");
		vEventos.tfFecha.setText("");
		vEventos.tfMentor.setText("");
		vEventos.tfCategoria.setText("");
		vEventos.tfDuracion.setText("");
		vEventos.tfLugar.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vEventos.table) {
			int fila = vEventos.table.rowAtPoint(e.getPoint());
			
			vEventos.tfCodigo.setText(eventos.get(fila).getCod_ev());
			vEventos.tfFecha.setText(eventos.get(fila).getFecha());
			vEventos.tfMentor.setText(eventos.get(fila).getMentor());
			vEventos.tfCategoria.setText(eventos.get(fila).getCategoria());
			vEventos.tfDuracion.setText(eventos.get(fila).getDuracion());
			vEventos.tfLugar.setText(eventos.get(fila).getLugar());
			
			// Necesario para que eclipse no la detecte como una fecha y añada HH:MM:SS al final del campo
			vEventos.tfFecha.setText(eventos.get(fila).getFecha().substring(0, 10));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
