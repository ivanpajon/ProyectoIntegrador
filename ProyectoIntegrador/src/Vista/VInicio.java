package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Controlador.CInicio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInicio extends JFrame {

	public JPanel contentPane;
	public JButton btnEventos;
	public JButton btnProveedor;
	public JButton btnProyectos;
	public JButton btnUsuarios;
	public JButton btnUsuariosEventos;
	public JButton btnPedidos;
	public JButton btnMaterial;
	public JButton btnMaquina;
	
	public VInicio() {		
		try {
			//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error al aplicar estilo de ventana");
		}
		
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEventos = new JButton("Eventos");
		btnEventos.setBounds(30, 13, 150, 40);
		contentPane.add(btnEventos);
		
		btnMaquina = new JButton("Maquina");
		btnMaquina.setBounds(30, 64, 150, 40);
		contentPane.add(btnMaquina);
		
		btnMaterial = new JButton("Material");
		btnMaterial.setBounds(30, 115, 150, 40);
		contentPane.add(btnMaterial);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(30, 166, 150, 40);
		contentPane.add(btnPedidos);
		
		btnProveedor = new JButton("Proveedor");
		btnProveedor.setBounds(205, 13, 150, 40);
		contentPane.add(btnProveedor);
		
		btnProyectos = new JButton("Proyectos");
		btnProyectos.setBounds(205, 65, 150, 40);
		contentPane.add(btnProyectos);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(205, 115, 150, 40);
		contentPane.add(btnUsuarios);
		
		btnUsuariosEventos = new JButton("Usuarios Eventos");
		btnUsuariosEventos.setBounds(205, 166, 150, 40);
		contentPane.add(btnUsuariosEventos);
	}
	
	public void setControlador(CInicio c) {
		btnEventos.addActionListener(c);
	}
		
}
