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
			insertarReserva();
		}
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
		System.out.println(codMaquina);
		
		if (rangoAvailable) {
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
			//this.vReservas.btnModificar.setEnabled(true);
			//this.vReservas.btnBorrar.setEnabled(true);
			
			int fila = vReservas.table.rowAtPoint(e.getPoint());
			
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
