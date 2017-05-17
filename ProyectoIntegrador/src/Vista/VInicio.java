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

	protected JPanel contentPane;
	protected JButton btnEventos;
	protected JButton btnLineaPedido;
	protected JButton btnProveedor;
	protected JButton btnProyectos;
	protected JButton btnProyectosMaquina;
	protected JButton btnProyectosUsuarios;
	protected JButton btnUsuarios;
	protected JButton btnUsuariosEventos;
	protected JButton btnPedidos;
	protected JButton btnMaterialProyecto;
	protected JButton btnMaterial;
	protected JButton btnMaquina;
	
	public VInicio() {
		/*try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				//System.out.println(info.getName());
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error al aplicar estilo de ventana - " + e);
		}*/
		
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			System.out.println("Error al aplicar estilo de ventana");
		}
		
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEventos = new JButton("Eventos");
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEventos.setBounds(30, 13, 150, 40);
		contentPane.add(btnEventos);
		
		btnLineaPedido = new JButton("Linea Pedidos");
		btnLineaPedido.setBounds(30, 65, 150, 40);
		contentPane.add(btnLineaPedido);
		
		btnMaquina = new JButton("Maquina");
		btnMaquina.setBounds(30, 117, 150, 40);
		contentPane.add(btnMaquina);
		
		btnMaterial = new JButton("Material");
		btnMaterial.setBounds(30, 169, 150, 40);
		contentPane.add(btnMaterial);
		
		btnMaterialProyecto = new JButton("Material Proyecto");
		btnMaterialProyecto.setBounds(30, 221, 150, 40);
		contentPane.add(btnMaterialProyecto);
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(30, 273, 150, 40);
		contentPane.add(btnPedidos);
		
		btnProveedor = new JButton("Proveedor");
		btnProveedor.setBounds(205, 13, 150, 40);
		contentPane.add(btnProveedor);
		
		btnProyectos = new JButton("Proyectos");
		btnProyectos.setBounds(205, 65, 150, 40);
		contentPane.add(btnProyectos);
		
		btnProyectosMaquina = new JButton("Proyectos Maquina");
		btnProyectosMaquina.setBounds(205, 117, 150, 40);
		contentPane.add(btnProyectosMaquina);
		
		btnProyectosUsuarios = new JButton("Proyectos Usuarios");
		btnProyectosUsuarios.setBounds(205, 169, 150, 40);
		contentPane.add(btnProyectosUsuarios);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(205, 221, 150, 40);
		contentPane.add(btnUsuarios);
		
		btnUsuariosEventos = new JButton("Usuarios Eventos");
		btnUsuariosEventos.setBounds(205, 273, 150, 40);
		contentPane.add(btnUsuariosEventos);
	}
	
	public void setControlador(CInicio c) {
		btnEventos.addActionListener(c);
	}
		
}
