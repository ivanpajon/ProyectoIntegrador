package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CMaquina;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class VMaquina extends JFrame {

	public JPanel contentPane;
	public JTextField tfCodigo;
	public JTextField tfNombre;
	public JTextField tfDescripcion;
	public JTextField tfTipo;
	public JTable table;
	public JLabel lblError;
	public JButton btnInsertar;
	public JButton btnModificar;
	public JButton btnBorrar;
	
	public VMaquina() {
		setTitle("Maquinas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(pantalla.width/3, pantalla.height/5);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(10, 11, 110, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 46, 110, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(10, 80, 110, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 111, 110, 14);
		contentPane.add(lblTipo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(130, 8, 120, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(130, 43, 120, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(130, 77, 120, 20);
		contentPane.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(130, 108, 120, 20);
		contentPane.add(tfTipo);
		tfTipo.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 148, 414, 14);
		contentPane.add(lblError);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 414, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Código", "Nombre", "Descripción", "Tipo"
			}
		));
		scrollPane.setViewportView(table);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(299, 11, 89, 35);
		contentPane.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(299, 57, 89, 35);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(299, 105, 89, 35);
		contentPane.add(btnBorrar);
	}
	
	public void setControlador(CMaquina c) {
		table.addMouseListener(c);
		btnInsertar.addActionListener(c);
		btnModificar.addActionListener(c);
		btnBorrar.addActionListener(c);
	}
}
