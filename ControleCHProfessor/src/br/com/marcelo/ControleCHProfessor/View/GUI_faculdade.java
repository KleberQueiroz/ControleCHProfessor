package br.com.marcelo.ControleCHProfessor.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.event.spi.ClearEvent;
import org.hibernate.event.spi.ClearEventListener;

import br.com.marcelo.ControleCHProfessor.DAO.FaculdadeDAO;
import br.com.marcelo.ControleCHProfessor.modelo.Faculdade;
import br.com.marcelo.ControleCHProfessor.util.FaculdadeTableModel;

public class GUI_faculdade extends JFrame {

	private JPanel contentPane;
	private JTable jtableFaculdade;
	private JTextField textField_nome;
	private JTextField textField_Campus;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_faculdade frame = new GUI_faculdade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_faculdade() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kleber\\Pictures\\icon_folhaDePagamento.jpg"));
		setTitle("Cadastro de Faculdade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCadastroDeFaculdade = new JLabel("CADASTRO DE FACULDADE");
		lblCadastroDeFaculdade.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		

		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
				EntityManager em = factory.createEntityManager();
				
				Faculdade faculdade= new Faculdade();
		           
		          faculdade.setNome(textField_nome.getText());
		          faculdade.setCampus(textField_Campus.getText());
		          
		          em.getTransaction().begin();
		          em.persist(faculdade);
		          em.getTransaction().commit();
		          
		          ArrayList dados = new ArrayList();
				String[] colunas= new String []{"ID", "NOME", "SIGLA"};

				em.close();
		        JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
			}
		});
				
		
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
				EntityManager em = factory.createEntityManager();
			       
				//SFaculdadeDAO.getInstance().remove(faculdade.);
				//getInstance().remove(Integer.parseInt(textField_nome.getName()));
				
		          
			}
		});
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_nome = new JTextField();
		textField_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_nome.setColumns(10);
		
		JLabel lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_Campus = new JTextField();
		textField_Campus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Campus.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLimpar)
					.addGap(38))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblCampus))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_Campus)
						.addComponent(textField_nome, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(173)
					.addComponent(lblCadastroDeFaculdade)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblCadastroDeFaculdade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_Campus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCampus))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpar)
						.addComponent(btnBuscar)
						.addComponent(btnExcluir)
						.addComponent(btnInserir))
					.addContainerGap())
		);
		
		jtableFaculdade = new JTable();
		jtableFaculdade.setFont(new Font("Symbol", Font.PLAIN, 14));
		jtableFaculdade.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jtableFaculdade.setBackground(Color.LIGHT_GRAY);
		jtableFaculdade.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod", "Nome", "Campus"
			}
		));
		scrollPane.setViewportView(jtableFaculdade);
		contentPane.setLayout(gl_contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, scrollPane, jtableFaculdade}));
	}
}
