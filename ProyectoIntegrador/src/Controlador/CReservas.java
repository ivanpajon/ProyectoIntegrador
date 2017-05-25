package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import Entidades.Maquina;
import Entidades.Proyectos;
import Entidades.ProyectosMaquina;
import OracleAccess.OracleAccess;
import Vista.VReservas;

public class CReservas implements ActionListener, MouseListener {
	VReservas vReservas;
	GReservas gReservas;
	OracleAccess bbdd;
	ArrayList<ProyectosMaquina> reservas = new ArrayList<ProyectosMaquina>();
	ArrayList<Proyectos> proyectos = new ArrayList<Proyectos>();
	ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
	
	public CReservas(VReservas vReservas, OracleAccess bbdd) {
		this.vReservas = vReservas;
		this.bbdd = bbdd;
		this.gReservas = new GReservas(bbdd.getCn());
		this.gReservas.consultarProyectos(proyectos);
		this.gReservas.consultarMaquinas(maquinas);
		
		this.vReservas.tfCodigoProyecto.setEnabled(false);
		this.vReservas.cmbMaquina.setEnabled(false);
		
		this.vReservas.dateChooserInicio.getJCalendar().setTodayButtonVisible(true);
		this.vReservas.dateChooserInicio.getJCalendar().setTodayButtonText("Hoy");
		
		this.vReservas.dateChooserFin.getJCalendar().setTodayButtonVisible(true);
		this.vReservas.dateChooserFin.getJCalendar().setTodayButtonText("Hoy");
		
		cargarProyectos();  // Se añaden los nombres de los proyectos existentes a su combobox
		cargarMaquinas();  // Se añaden los codigos de las maquinas existentes a su combobox
	}
	
	private void cargarProyectos() {
		for (Proyectos p : proyectos) {
			vReservas.cmbProyecto.addItem(p.getNombre());
		}
	}
	
	private void cargarMaquinas() {
		for (Maquina m : maquinas) {
			vReservas.cmbMaquina.addItem(m.getNombre());
		}
	}
	
	private void cargarReservas(String nombreProyecto) {
		reservas.clear();  // Vaciamos el array
		// Eliminamos una por una las filas de la tabla
		while(vReservas.table.getRowCount()>0) {
			DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
			tabla.removeRow(0);
        } 
		gReservas.consultarReservas(reservas, nombreProyecto);  // Cargamos las reservas que haya para el nombre de proyecto seleccionado en el array
		// Mostramos las reservas en la tabla
		for (ProyectosMaquina r : reservas) {
			DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
			tabla.addRow(new Object[] {r.getNombre(), r.getCod_pr(), r.getCod_ma(), r.getFecha_inicioFormatted(), r.getFecha_finFormatted()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == vReservas.cmbProyecto) {
			String nombreProyecto = vReservas.cmbProyecto.getSelectedItem().toString();
			//System.out.println(nombreProyecto);
			cargarReservas(nombreProyecto);
		}
		else if (obj == vReservas.btnInsertar) {
			if (vReservas.btnInsertar.getText().equals("Insertar")) {
				vReservas.btnInsertar.setText("Guardar");
				vReservas.cmbMaquina.setEnabled(true);
				vReservas.btnModificar.setEnabled(false);
				vReservas.btnBorrar.setEnabled(false);
			}
			else {
				vReservas.btnInsertar.setText("Insertar");
				vReservas.cmbMaquina.setEnabled(false);
				vReservas.btnModificar.setEnabled(true);
				vReservas.btnBorrar.setEnabled(true);
				insertarReserva();
			}
		}
		else if (obj == vReservas.btnBorrar) {
			borrarReserva();
		}
		else if (obj == vReservas.btnModificar) {
			if (vReservas.btnModificar.getText().equals("Modificar")) {
				vReservas.btnModificar.setText("Guardar");
				vReservas.cmbMaquina.setEnabled(true);
				vReservas.btnInsertar.setEnabled(false);
				vReservas.btnBorrar.setEnabled(false);
			}
			else {
				vReservas.btnModificar.setText("Modificar");
				vReservas.cmbMaquina.setEnabled(false);
				vReservas.btnInsertar.setEnabled(true);
				vReservas.btnBorrar.setEnabled(true);
				modificarReserva();
			}
		}
	}

	private void modificarReserva() {
		String fechaInicio = vReservas.dateChooserInicio.getJCalendar().getYearChooser().getYear() + "-" +
                (vReservas.dateChooserInicio.getJCalendar().getMonthChooser().getMonth()+1) + "-" +
                vReservas.dateChooserInicio.getJCalendar().getDayChooser().getDay();
		String fechaFin = vReservas.dateChooserFin.getJCalendar().getYearChooser().getYear() + "-" +
                (vReservas.dateChooserFin.getJCalendar().getMonthChooser().getMonth()+1) + "-" +
                vReservas.dateChooserFin.getJCalendar().getDayChooser().getDay();
		
		ProyectosMaquina r = new ProyectosMaquina();
		r.setCod_ma(vReservas.cmbMaquina.getSelectedItem().toString());
		r.setCod_pr(vReservas.tfCodigoProyecto.getText());
		r.setFecha_fin(fechaFin);
		r.setFecha_inicio(fechaInicio);
		r.setNombre(vReservas.cmbProyecto.getSelectedItem().toString());
		
		if (gReservas.modificarReserva(r)) {
			DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
			int fila = vReservas.table.getSelectedRow();
			
			reservas.set(fila, r);
			tabla.setValueAt(r.getNombre(), fila, 0);
			tabla.setValueAt(r.getCod_pr(), fila, 1);
			tabla.setValueAt(r.getCod_ma(), fila, 2);
			tabla.setValueAt(r.getFecha_inicio(), fila, 3);
			tabla.setValueAt(r.getFecha_fin(), fila, 4);
			
			vReservas.lblError.setForeground(Color.GREEN.darker());
			vReservas.lblError.setText("La reserva se ha modificado correctamente");
		}
		else {
			vReservas.lblError.setForeground(Color.RED);
			vReservas.lblError.setText("Error modificando la reserva");
		}
	}

	private void borrarReserva() {
		int fila = vReservas.table.getSelectedRow();
		
		reservas.remove(fila);
		DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
		tabla.removeRow(fila);
		gReservas.borrarReserva(vReservas.tfCodigoProyecto.getText(), vReservas.cmbMaquina.getSelectedItem().toString());
		
		this.vReservas.btnBorrar.setEnabled(false);
	}

	private void insertarReserva() {
		String fechaInicio = vReservas.dateChooserInicio.getJCalendar().getYearChooser().getYear() + "-" +
                (vReservas.dateChooserInicio.getJCalendar().getMonthChooser().getMonth()+1) + "-" +
                vReservas.dateChooserInicio.getJCalendar().getDayChooser().getDay();
		String fechaFin = vReservas.dateChooserFin.getJCalendar().getYearChooser().getYear() + "-" +
                (vReservas.dateChooserFin.getJCalendar().getMonthChooser().getMonth()+1) + "-" +
                vReservas.dateChooserFin.getJCalendar().getDayChooser().getDay();
		int codMaquina = Integer.parseInt(vReservas.cmbMaquina.getSelectedItem().toString());
		boolean rangoAvailable = gReservas.comprobarFecha(fechaInicio, fechaFin, codMaquina);
		
		ProyectosMaquina r = new ProyectosMaquina();
		r.setCod_ma(vReservas.cmbMaquina.getSelectedItem().toString());
		r.setCod_pr(vReservas.tfCodigoProyecto.getText());
		r.setFecha_fin(fechaFin);
		r.setFecha_inicio(fechaInicio);
		r.setNombre(vReservas.cmbProyecto.getSelectedItem().toString());
		reservas.add(r);
		
		if (rangoAvailable) {
			gReservas.añadirReserva(r);
			DefaultTableModel tabla = (DefaultTableModel) vReservas.table.getModel();
			tabla.addRow(new Object[] {r.getNombre(), r.getCod_pr(), r.getCod_ma(), r.getFecha_inicio(), r.getFecha_fin()});
			
			vReservas.lblError.setForeground(Color.GREEN.darker());
			vReservas.lblError.setText("Reserva añadida correctamente");
		}
		else {
			vReservas.lblError.setForeground(Color.RED);
			vReservas.lblError.setText("Existe una reserva para el rango de fechas seleccionado");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if (obj == vReservas.table) {
			this.vReservas.btnBorrar.setEnabled(true);
			this.vReservas.btnModificar.setEnabled(true);
			
			int fila = vReservas.table.getSelectedRow();
			
			vReservas.tfCodigoProyecto.setText(reservas.get(fila).getCod_pr());
			vReservas.cmbMaquina.setSelectedIndex(Integer.parseInt(reservas.get(fila).getCod_ma())-1);
			
			// Este try-catch pone las fechas de la fila seleccionada en sus dateChooser
			try {
				Date dateInicio = new SimpleDateFormat("yyyy-MM-dd").parse(reservas.get(fila).getFecha_inicioFormatted());
				vReservas.dateChooserInicio.setDate(dateInicio);
				
				Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(reservas.get(fila).getFecha_fin());
				vReservas.dateChooserFin.setDate(dateFin);
			}
			catch (ParseException ex) {
				System.out.println("Error obteniendo fecha - " + ex);
			}
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
