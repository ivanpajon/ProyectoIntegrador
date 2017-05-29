package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.CProveedor;

public class VProveedor extends JFrame {

	public JPanel contentPane;
	public JTable table;

	public VProveedor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 250, 474, 166);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CIF", "Nombre", "Correo", "Teléfono", "Dirección", "Código Postal", "Descripción"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	public void setControlador(CProveedor c) {
		
	}
}
