package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CReservas;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VReservas extends JFrame {
	public JPanel contentPane;
	public JTable table;
	public JTextField tfCodigoMaquina;
	public JTextField tfCodigoProyecto;
	public JDateChooser dateChooserInicio;
	public JDateChooser dateChooserFin;

	public VReservas() {
		setTitle("Reservas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblCodigoProyecto = new JLabel("Código Proyecto");
		lblCodigoProyecto.setBounds(10, 25, 110, 14);
		contentPane.add(lblCodigoProyecto);
		
		JLabel lblCodigoMaquina = new JLabel("Código Máquina");
		lblCodigoMaquina.setBounds(10, 60, 110, 14);
		contentPane.add(lblCodigoMaquina);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(10, 100, 110, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(10, 140, 110, 14);
		contentPane.add(lblFechaFin);
		
		JLabel lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 184, 414, 14);
		contentPane.add(lblError);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 414, 145);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código Proyecto", "Código Máquina", "Fecha Inicio", "Fecha Fin"
			}
		));
		scrollPane.setViewportView(table);
		
		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(145, 94, 145, 20);
		contentPane.add(dateChooserInicio);
		
		dateChooserFin = new JDateChooser();
		dateChooserFin.setBounds(145, 134, 145, 20);
		contentPane.add(dateChooserFin);
		
		tfCodigoMaquina = new JTextField();
		tfCodigoMaquina.setBounds(145, 57, 145, 20);
		contentPane.add(tfCodigoMaquina);
		tfCodigoMaquina.setColumns(10);
		
		tfCodigoProyecto = new JTextField();
		tfCodigoProyecto.setBounds(145, 22, 145, 20);
		contentPane.add(tfCodigoProyecto);
		tfCodigoProyecto.setColumns(10);
	}
	
	public void setControlador(CReservas c) {
		
	}
}
