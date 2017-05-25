package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;

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
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VReservas extends JFrame {
	public JPanel contentPane;
	public JTable table;
	public JTextField tfCodigoProyecto;
	public JDateChooser dateChooserInicio;
	public JDateChooser dateChooserFin;
	public JComboBox<String> cmbProyecto;
	public JButton btnInsertar;
	public JComboBox<String> cmbMaquina;
	public JLabel lblError;
	public JButton btnBorrar;
	public JButton btnModificar;

	public VReservas() {
		setTitle("Reservas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(pantalla.width/3, pantalla.height/5);
		
		JLabel lblNombreProyecto = new JLabel("Nombre Proyecto");
		lblNombreProyecto.setBounds(10, 24, 110, 14);
		contentPane.add(lblNombreProyecto);
		//System.out.println("Ancho - " + pantalla.width/3);
		//System.out.println("Alto - " + pantalla.height/5);
		
		JLabel lblCodigoProyecto = new JLabel("Código Proyecto");
		lblCodigoProyecto.setBounds(10, 63, 110, 14);
		contentPane.add(lblCodigoProyecto);
		
		JLabel lblCodigoMaquina = new JLabel("Código Máquina");
		lblCodigoMaquina.setBounds(10, 98, 110, 14);
		contentPane.add(lblCodigoMaquina);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(10, 138, 110, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(10, 178, 110, 14);
		contentPane.add(lblFechaFin);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 222, 414, 14);
		contentPane.add(lblError);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 414, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Código Proyecto", "Código Máquina", "Fecha Inicio", "Fecha Fin"
			}
		));
		scrollPane.setViewportView(table);
		
		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(145, 132, 145, 20);
		contentPane.add(dateChooserInicio);
		
		dateChooserFin = new JDateChooser();
		dateChooserFin.setBounds(145, 172, 145, 20);
		contentPane.add(dateChooserFin);
		
		tfCodigoProyecto = new JTextField();
		tfCodigoProyecto.setBounds(145, 60, 145, 20);
		contentPane.add(tfCodigoProyecto);
		tfCodigoProyecto.setColumns(10);
		
		cmbProyecto = new JComboBox<String>();
		cmbProyecto.setBounds(145, 21, 145, 20);
		contentPane.add(cmbProyecto);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(315, 20, 89, 35);
		contentPane.add(btnInsertar);
		
		cmbMaquina = new JComboBox<String>();
		cmbMaquina.setBounds(145, 95, 145, 20);
		contentPane.add(cmbMaquina);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(315, 89, 89, 35);
		contentPane.add(btnBorrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(315, 157, 89, 35);
		contentPane.add(btnModificar);
	}
	
	public void setControlador(CReservas c) {
		btnInsertar.addActionListener(c);
		btnBorrar.addActionListener(c);
		btnModificar.addActionListener(c);
		table.addMouseListener(c);
		cmbProyecto.addActionListener(c);
	}
}
