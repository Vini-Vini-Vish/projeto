package com.projeto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Usuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsuarioGUI extends JFrame {

	private static final long serialVersionUID = -3802345951710679112L;
	
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPassword;
	
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnSair;
	
	private JRadioButton rdbtnAtivo;	
	private JRadioButton rdbtnAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioGUI frame = new UsuarioGUI();
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
	public UsuarioGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha:");
		
		passwordFieldPassword = new JPasswordField();
		
		//-----------------------------------------------------------------//			
		rdbtnAtivo = new JRadioButton("Ativo");
		
		rdbtnAdmin = new JRadioButton("Adimistrador");
		
		btnIncluir = new JButton("Incluir");
		
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncluirUsuario();
			}
		});
		
		btnAlterar = new JButton("Alterar");
		
		btnExcluir = new JButton("Excluir");
		
		btnSair = new JButton("Sair");
		//-----------------------------------------------------------------//	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnIncluir)
							.addGap(18)
							.addComponent(btnAlterar)
							.addGap(18)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEmail)
								.addComponent(lblNome)
								.addComponent(lblPassword))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldEmail))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(rdbtnAtivo)
									.addGap(42)
									.addComponent(rdbtnAdmin)))))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnAtivo)
						.addComponent(rdbtnAdmin))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(179, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		createEvents();
	}
	
	protected void IncluirUsuario() {
		
	}
	
	private void createEvents() {
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public Usuario PegarDadosUsuario() {
		Usuario usuario = new Usuario();
		
		usuario.setUsername(textFieldName.getText());
		usuario.setEmail(textFieldEmail.getText());
		usuario.setPassword(passwordFieldPassword.getSelectedText());
		
		if(rdbtnAtivo.isSelected()) {
			usuario.setAtivo(true);
		} else{
			usuario.setAtivo(false);
		}
		
		if(rdbtnAdmin.isSelected()) {
			usuario.setAdmin(true);
		} else{
			usuario.setAdmin(false);
		}
		
		return usuario;
	}
	
}
