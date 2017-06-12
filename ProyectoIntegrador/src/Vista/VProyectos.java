package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.CProyectos;

public class VProyectos extends JFrame {

	public JPanel contentPane;
	public JTextField tfCodigo;
	public JTextField tfNombre;
	public JTextField tfDescripcion;
	public JLabel lblError;
	public JTable table;

	public VProyectos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(25, 30, 90, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 65, 94, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(25, 100, 90, 14);
		contentPane.add(lblDescripcion);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(125, 27, 170, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(125, 62, 170, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(125, 97, 170, 20);
		contentPane.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 135, 444, 14);
		contentPane.add(lblError);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 444, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Nombre", "Descripción"
			}
		));
		scrollPane.setViewportView(table);
	}

	public void setControlador(CProyectos c) {
		table.addMouseListener(c);
		//btnInsertar.addActionListener(c);
		//btnModificar.addActionListener(c);
		//btnBorrar.addActionListener(c);
	}
}
