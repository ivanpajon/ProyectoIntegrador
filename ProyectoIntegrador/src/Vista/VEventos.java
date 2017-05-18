package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controlador.CEventos;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VEventos extends JFrame {

	public JPanel contentPane;
	public JTable table;
	
	public VEventos() {
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error al aplicar estilo de ventana");
		}
		setTitle("Eventos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 155, 448, 119);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void setControlador(CEventos c) {
		
	}
}
