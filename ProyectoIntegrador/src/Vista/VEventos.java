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
import javax.swing.SwingConstants;

public class VEventos extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JTextField tfCodigo;
	public JTextField tfFecha;
	public JTextField tfMentor;
	public JTextField tfCategoria;
	public JTextField tfDuracion;
	public JTextField tfLugar;
	public JButton btnInsertar;
	public JButton btnModificar;
	public JButton btnBorrar;
	public JLabel lblLblerror;
	
	public VEventos() {
		/*try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error al aplicar estilo de ventana");
		}*/
		
		setTitle("Eventos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 305, 448, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Fecha", "Mentor", "Categor\u00EDa", "Duraci\u00F3n", "Lugar"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(16, 20, 95, 18);
		contentPane.add(lblCodigo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(16, 56, 95, 18);
		contentPane.add(lblFecha);
		
		JLabel lblMentor = new JLabel("Mentor");
		lblMentor.setBounds(16, 95, 95, 18);
		contentPane.add(lblMentor);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(16, 137, 95, 18);
		contentPane.add(lblCategoria);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(16, 177, 95, 18);
		contentPane.add(lblDuracion);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(123, 16, 167, 25);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfFecha = new JTextField();
		tfFecha.setBounds(123, 52, 167, 25);
		contentPane.add(tfFecha);
		tfFecha.setColumns(10);
		
		tfMentor = new JTextField();
		tfMentor.setBounds(123, 91, 167, 25);
		contentPane.add(tfMentor);
		tfMentor.setColumns(10);
		
		tfCategoria = new JTextField();
		tfCategoria.setBounds(123, 133, 167, 25);
		contentPane.add(tfCategoria);
		tfCategoria.setColumns(10);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(123, 173, 167, 25);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(322, 14, 93, 40);
		contentPane.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(322, 83, 93, 43);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(322, 155, 93, 40);
		contentPane.add(btnBorrar);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(16, 220, 56, 18);
		contentPane.add(lblLugar);
		
		tfLugar = new JTextField();
		tfLugar.setBounds(123, 216, 167, 25);
		contentPane.add(tfLugar);
		tfLugar.setColumns(10);
		
		lblLblerror = new JLabel("");
		lblLblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblLblerror.setBounds(0, 265, 434, 18);
		contentPane.add(lblLblerror);
	}
	
	public void setControlador(CEventos c) {
		btnInsertar.addActionListener(c);
		btnModificar.addActionListener(c);
		btnBorrar.addActionListener(c);
	}
}
