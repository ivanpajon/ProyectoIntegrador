package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import Controlador.CPedidos;

public class VPedidos extends JFrame {

	public JPanel contentPane;
	public JTextField textFieldCodigo;
	public JTextField textFieldImporte;
	public JTextField textFieldCif;
	public JTextField textFieldBuscar;
	public JTable table;
	public JButton btnAñadir;
	public JButton btnModificar;
	public JButton btnBorrar;
	public JButton btnSalir;
	public JLabel lblAviso;
	public JDateChooser dateChooser;

	
	public VPedidos() {
		setTitle("Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 739, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(pantalla.width/3, pantalla.height/5);
		//System.out.println("Ancho - " + pantalla.width/3);
		//System.out.println("Alto - " + pantalla.height/5);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(12, 502, 97, 25);
		contentPane.add(btnAñadir);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(136, 502, 97, 25);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(258, 502, 97, 25);
		contentPane.add(btnBorrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(612, 502, 97, 25);
		contentPane.add(btnSalir);
		
		lblAviso = new JLabel("");
		lblAviso.setForeground(Color.RED);
		lblAviso.setBounds(296, 154, 413, 69);
		contentPane.add(lblAviso);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(12, 25, 70, 16);
		contentPane.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(94, 22, 172, 22);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(12, 75, 70, 16);
		contentPane.add(lblFecha);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(12, 133, 70, 16);
		contentPane.add(lblImporte);
		
		textFieldImporte = new JTextField();
		textFieldImporte.setBounds(94, 130, 172, 22);
		contentPane.add(textFieldImporte);
		textFieldImporte.setColumns(10);
		
		JLabel lblCif = new JLabel("CIF/DNI:");
		lblCif.setBounds(12, 188, 70, 16);
		contentPane.add(lblCif);
		
		textFieldCif = new JTextField();
		textFieldCif.setBounds(94, 181, 172, 22);
		contentPane.add(textFieldCif);
		textFieldCif.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 253, 697, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod_Pedido", "Fecha", "Importe/€", "CIF/DNI"
			}
		));
		scrollPane.setViewportView(table);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(94, 71, 169, 20);
		contentPane.add(dateChooser);
	}
	
	public void setControlador(CPedidos Vp){
		btnAñadir.addActionListener(Vp);
		btnModificar.addActionListener(Vp);
		btnBorrar.addActionListener(Vp);
		btnSalir.addActionListener(Vp);
		table.addMouseListener(Vp);
	}
}
