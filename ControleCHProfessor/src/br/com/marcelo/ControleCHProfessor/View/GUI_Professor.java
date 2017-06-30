package br.com.marcelo.ControleCHProfessor.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import br.com.marcelo.ControleCHProfessor.modelo.Professor;

public class GUI_Professor extends JFrame {

	private JPanel contentPane;
	private JTable jtableProfessor;
	private JTextField textField_nome;
	private JTextField textField_email;

	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Professor frame = new GUI_Professor();
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
	public GUI_Professor() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kleber\\Pictures\\icon_folhaDePagamento.jpg"));
		setTitle("Cadastro de Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCadastroDeProfessor = new JLabel("CADASTRO DE Professor");
		lblCadastroDeProfessor.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
				EntityManager em = factory.createEntityManager();
				
				Professor Professor= new Professor();
		           
		          Professor.setNome(textField_nome.getText());
		          Professor.setEmail(textField_email.getText());
		          
		          em.getTransaction().begin();
		          em.persist(Professor);
		          em.getTransaction().commit();
		          
		          
		          em.close();
		      
		          JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
				
		          
				
			}
		});
		
				
	/*	public void preeencherTabela(String Sql){
			ArrayList dados = new ArrayList();
			String []colunas = new String[]{"Id","NOME", "email"};
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
			EntityManager em = factory.createEntityManager();
			 em.getTransaction().begin();
	        // TableModel modelo 
			  em.close();
			try{
		
			}catch (SQLException ex) {
				JOptionPane.showMessageDialog(, message);
			}
			}
			*/
		
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				((DefaultTableModel) jtableProfessor.getModel()).removeRow(jtableProfessor.getSelectedRow());
				
			}
		});
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnSair = new JButton("SAIR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_nome = new JTextField();
		textField_nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_nome.setColumns(10);
		
		JLabel lblemail = new JLabel("email");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_email = new JTextField();
		textField_email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_email.setColumns(10);
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
					.addComponent(btnSair)
					.addGap(38))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(lblemail))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_email)
						.addComponent(textField_nome, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(173)
					.addComponent(lblCadastroDeProfessor)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblCadastroDeProfessor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblemail))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnBuscar)
						.addComponent(btnExcluir)
						.addComponent(btnInserir))
					.addContainerGap())
		);
		
		jtableProfessor = new JTable();
		jtableProfessor.setFont(new Font("Symbol", Font.PLAIN, 14));
		jtableProfessor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jtableProfessor.setBackground(Color.LIGHT_GRAY);
		jtableProfessor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod", "Nome", "email", "login", "CPF"
			}
		));
		scrollPane.setViewportView(jtableProfessor);
		contentPane.setLayout(gl_contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, scrollPane, jtableProfessor}));
	}
}
