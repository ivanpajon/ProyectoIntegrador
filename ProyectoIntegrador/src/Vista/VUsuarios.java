package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.CUsuarios;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class VUsuarios extends JFrame {

	public JPanel contentPane;
	public JTable table;
	public JTextField textFieldID;
	public JTextField textFieldNombre;
	public JTextField textFieldApellido;
	public JTextField textFieldCorreo;
	public JTextField textFieldTFNO;
	public JTextField textFieldTipo;
	public JButton btnInsertar;
	public JButton btnModificar;
	public JButton btnBorrar;
	public JLabel lblAviso;


	public VUsuarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 247, 626, 251);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_Socio", "Nombre", "Apellido", "Correo", "TFNO", "Tipo"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblID = new JLabel("ID_Socio:");
		lblID.setBounds(12, 13, 81, 16);
		contentPane.add(lblID);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 42, 81, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 71, 81, 16);
		contentPane.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(12, 100, 81, 16);
		contentPane.add(lblCorreo);
		
		JLabel lblTfno = new JLabel("TFNO:");
		lblTfno.setBounds(12, 129, 81, 16);
		contentPane.add(lblTfno);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(12, 158, 81, 16);
		contentPane.add(lblTipo);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(118, 13, 192, 22);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(118, 42, 192, 22);
		contentPane.add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(118, 68, 192, 22);
		contentPane.add(textFieldApellido);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(118, 97, 192, 22);
		contentPane.add(textFieldCorreo);
		
		textFieldTFNO = new JTextField();
		textFieldTFNO.setColumns(10);
		textFieldTFNO.setBounds(118, 126, 192, 22);
		contentPane.add(textFieldTFNO);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(118, 155, 192, 22);
		contentPane.add(textFieldTipo);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(541, 33, 97, 25);
		contentPane.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(541, 67, 97, 25);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(541, 105, 97, 25);
		contentPane.add(btnBorrar);
		
		lblAviso = new JLabel("");
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(12, 208, 409, 16);
		contentPane.add(lblAviso);
	}
	public void setControlador(CUsuarios c){
		btnInsertar.addActionListener(c);
		btnModificar.addActionListener(c);
		btnBorrar.addActionListener(c);
		table.addMouseListener(c);
}
}

