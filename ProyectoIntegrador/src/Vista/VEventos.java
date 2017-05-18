package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CEventos;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VEventos extends JFrame {

	public JPanel contentPane;
	public JTable table;
	private JTextField tfCodigo;
	private JTextField tfLugar;
	private JTextField tfDescripcion;
	private JTextField tfFechaInicio;
	private JTextField tfFechaFin;
	
	public VEventos() {
		/*try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error al aplicar estilo de ventana");
		}*/
		
		setTitle("Eventos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 235, 448, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Lugar", "Descripci\u00F3n", "Fecha Inicio", "Fecha Fin"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(16, 20, 95, 18);
		contentPane.add(lblCodigo);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(16, 56, 95, 18);
		contentPane.add(lblLugar);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(16, 95, 95, 18);
		contentPane.add(lblDescripcion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(16, 137, 95, 18);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(16, 177, 95, 18);
		contentPane.add(lblFechaFin);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(123, 16, 167, 25);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfLugar = new JTextField();
		tfLugar.setBounds(123, 52, 167, 25);
		contentPane.add(tfLugar);
		tfLugar.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(123, 91, 167, 25);
		contentPane.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfFechaInicio = new JTextField();
		tfFechaInicio.setBounds(123, 133, 167, 25);
		contentPane.add(tfFechaInicio);
		tfFechaInicio.setColumns(10);
		
		tfFechaFin = new JTextField();
		tfFechaFin.setBounds(123, 173, 167, 25);
		contentPane.add(tfFechaFin);
		tfFechaFin.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(322, 14, 93, 40);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(322, 83, 93, 43);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(322, 155, 93, 40);
		contentPane.add(btnBorrar);
	}
	
	public void setControlador(CEventos c) {
		
	}
}
