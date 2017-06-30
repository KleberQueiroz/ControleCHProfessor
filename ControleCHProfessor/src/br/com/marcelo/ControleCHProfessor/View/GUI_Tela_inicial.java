package br.com.marcelo.ControleCHProfessor.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Tela_inicial {

	private JFrame frame;
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem mntmSair = new JMenuItem("Sair");
	private JMenuItem mntmCadastro = new JMenuItem("Cadastro");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Tela_inicial window = new GUI_Tela_inicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI_Tela_inicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		menuBar.add(mntmCadastro);
		
		
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		menuBar.add(mntmSair);
	}

	
			           

}
