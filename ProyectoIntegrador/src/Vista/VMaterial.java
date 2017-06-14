package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.CMaterial;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

public class VMaterial extends JFrame{

	public JPanel contentPane;
	public JTable table;
	public JTextField textFieldCodigo;
	public JTextField textFieldNombre;
	public JTextField textFieldDescripccion;
	public JTextField textFieldTipo;
	public JButton btnAñadir;
	public JButton btnModificar;
	public JButton btnBorrar;
	public JButton btnSalir;
	public JButton btnPedirMaterial;
	public JLabel lblAviso;
	public JButton btnBuscar;
	public JSpinner spinner;
	public JTextField textFieldBuscar;
	public JButton btnMostrar;
	

	
	public VMaterial() {
		setTitle("Materiales");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(pantalla.width/3, pantalla.height/5);
		//System.out.println("Ancho - " + pantalla.width/3);
		//System.out.println("Alto - " + pantalla.height/5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 194, 699, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Descripccion", "Tipo", "Stock"
			}
		));
		scrollPane.setViewportView(table);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(12, 419, 97, 25);
		contentPane.add(btnAñadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(137, 419, 97, 25);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(260, 419, 97, 25);
		contentPane.add(btnBorrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(614, 419, 97, 25);
		contentPane.add(btnSalir);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(12, 24, 77, 16);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(101, 21, 196, 22);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 67, 77, 16);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(101, 64, 196, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDescripccion = new JLabel("Descripccion:");
		lblDescripccion.setBounds(12, 107, 84, 16);
		contentPane.add(lblDescripccion);
		
		textFieldDescripccion = new JTextField();
		textFieldDescripccion.setBounds(101, 104, 196, 22);
		contentPane.add(textFieldDescripccion);
		textFieldDescripccion.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(380, 24, 56, 16);
		contentPane.add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(443, 21, 178, 22);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(380, 67, 56, 16);
		contentPane.add(lblStock);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner.setBounds(443, 64, 178, 22);
		contentPane.add(spinner);
		
		btnPedirMaterial = new JButton("Pedir Material");
		btnPedirMaterial.setBounds(491, 419, 111, 25);
		contentPane.add(btnPedirMaterial);
		
		lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(12, 139, 699, 48);
		contentPane.add(lblAviso);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(380, 103, 97, 26);
		contentPane.add(btnBuscar);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(486, 104, 206, 25);
		contentPane.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(382, 419, 97, 25);
		contentPane.add(btnMostrar);
	}
	public void setControlador(CMaterial vM){
		btnAñadir.addActionListener(vM);
		btnModificar.addActionListener(vM);
		btnBorrar.addActionListener(vM);
		btnSalir.addActionListener(vM);
		btnPedirMaterial.addActionListener(vM);
		btnBuscar.addActionListener(vM);
		btnMostrar.addActionListener(vM);
		table.addMouseListener(vM);
	}
}
