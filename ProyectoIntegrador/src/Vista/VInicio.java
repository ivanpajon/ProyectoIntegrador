package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CInicio;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

public class VInicio extends JFrame {

	public JPanel contentPane;
	public JButton btnEventos;
	public JButton btnProveedor;
	public JButton btnProyectos;
	public JButton btnUsuarios;
	public JButton btnReservas;
	public JButton btnPedidos;
	public JButton btnMaterial;
	public JButton btnMaquina;
	
	public VInicio() {		
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(pantalla.width/3, pantalla.height/5);
		//System.out.println("Ancho - " + pantalla.width/3);
		//System.out.println("Alto - " + pantalla.height/5);
		
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
		
		btnProveedor = new JButton("Proveedores");
		btnProveedor.setBounds(205, 13, 150, 40);
		contentPane.add(btnProveedor);
		
		btnProyectos = new JButton("Proyectos");
		btnProyectos.setBounds(205, 65, 150, 40);
		contentPane.add(btnProyectos);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(205, 115, 150, 40);
		contentPane.add(btnUsuarios);
		
		btnReservas = new JButton("Reservas");
		btnReservas.setBounds(205, 166, 150, 40);
		contentPane.add(btnReservas);
	}
	
	public void setControlador(CInicio c) {
		btnEventos.addActionListener(c);
		btnReservas.addActionListener(c);
		btnProveedor.addActionListener(c);
		btnMaquina.addActionListener(c);
		btnProyectos.addActionListener(c);
		btnMaterial.addActionListener(c);
	}
}