package br.com.marcelo.ControleCHProfessor.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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
import javax.swing.table.TableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.com.marcelo.ControleCHProfessor.modelo.Faculdade;

public class GUI_Coordenacao_curso extends JFrame {

	private JPanel contentPane;
	private JTable jtableCurso;
	private JTextField textField_nome;
	private JTextField textField_Descricao;
	private JTextField textFieldHoras_semestre;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Coordenacao_curso frame = new GUI_Coordenacao_curso();
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
	public GUI_Coordenacao_curso() {
		
		
		setFont(new Font("Arial", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Kleber\\Pictures\\icon_folhaDePagamento.jpg"));
		setTitle("Cadastro de Faculdade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblCadastroCoordenacao_curso = new JLabel("CADASTRO DE CURSO");
		lblCadastroCoordenacao_curso.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("folhaPersistence");
				EntityManager em = factory.createEntityManager();
				
				Faculdade faculdade= new Faculdade();
		           
		          faculdade.setNome(textField_nome.getText());
		          faculdade.setCampus(textField_Descricao.getText());
		          
		          em.getTransaction().begin();
		          em.persist(faculdade);
		          em.getTransaction().commit();
		          
		          
		          em.close();
		      
		          JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
				
		          
				
			}
		});
		
				
	/*	public void preeencherTabela(String Sql){
			ArrayList dados = new ArrayList();
			String []colunas = new String[]{"Id","NOME", "CAMPUS"};
			
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
				
				((DefaultTableModel) jtableCurso.getModel()).removeRow(jtableCurso.getSelectedRow());
				
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
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_Descricao = new JTextField();
		textField_Descricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Descricao.setColumns(10);
		
		JLabel lblHorasSemastre = new JLabel("Horas Semastre");
		lblHorasSemastre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textFieldHoras_semestre = new JTextField();
		textFieldHoras_semestre.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldHoras_semestre.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(btnInserir)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLimpar)
					.addGap(38))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(173)
					.addComponent(lblCadastroCoordenacao_curso)
					.addContainerGap(234, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblHorasSemastre))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDescricao))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNome)))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldHoras_semestre)
						.addComponent(textField_Descricao)
						.addComponent(textField_nome, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
					.addGap(84))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
					.addGap(23))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCadastroCoordenacao_curso)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_Descricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescricao))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHorasSemastre)
						.addComponent(textFieldHoras_semestre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpar)
						.addComponent(btnBuscar)
						.addComponent(btnExcluir)
						.addComponent(btnInserir))
					.addContainerGap())
		);
		
		jtableCurso = new JTable();
		jtableCurso.setFont(new Font("Symbol", Font.PLAIN, 14));
		jtableCurso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		jtableCurso.setBackground(Color.LIGHT_GRAY);
		jtableCurso.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod", "Nome", "Campus"
			}
		));
		scrollPane.setViewportView(jtableCurso);
		contentPane.setLayout(gl_contentPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, scrollPane, jtableCurso}));
	}
}
