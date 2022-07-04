package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocio.Cadastro;
import persistencia.ControlaCadastro;

public class TelaCadastro extends JFrame {

	ControlaCadastro controlaCadastro = new ControlaCadastro();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JTextField txtUsuario;
	private JTextField txtCrm;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastro() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Crie sua conta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
		lblNewLabel.setBounds(70, 28, 252, 22);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome completo:");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(70, 110, 233, 14);
		contentPane.add(lblNewLabel_1);

		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txtNomeCompleto.setBorder(null);
		txtNomeCompleto.setBackground(Color.LIGHT_GRAY);
		txtNomeCompleto.setBounds(70, 126, 318, 29);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(Color.LIGHT_GRAY);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(70, 183, 318, 28);
		contentPane.add(txtUsuario);

		txtCrm = new JTextField();
		txtCrm.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txtCrm.setBorder(null);
		txtCrm.setBackground(Color.LIGHT_GRAY);
		txtCrm.setColumns(10);
		txtCrm.setBounds(70, 291, 318, 28);
		contentPane.add(txtCrm);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txtSenha.setBackground(Color.LIGHT_GRAY);
		txtSenha.setBorder(null);
		txtSenha.setBounds(70, 238, 318, 28);
		contentPane.add(txtSenha);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin telaLogin = new TelaLogin();
				dispose();
				telaLogin.setVisible(true);
				telaLogin.setResizable(false);
			}
		});
		btnVoltar.setBounds(253, 360, 135, 36);
		contentPane.add(btnVoltar);

		JButton btnCriarConta = new JButton("Criar conta");
		btnCriarConta.setBackground(Color.WHITE);
		btnCriarConta.setBorder(null);
		btnCriarConta.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnCriarConta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Cadastro cadastro = new Cadastro();
				
				
				String senha = Arrays.toString(txtSenha.getPassword());
				
				if (txtUsuario.getText().isEmpty() || senha.equals("[]")){
					JOptionPane.showMessageDialog(null, "Informe os campos obrigatórios!");
				} else {

					cadastro.setNome(txtNomeCompleto.getText());
					cadastro.setUsuario(txtUsuario.getText());
					cadastro.setSenha(txtSenha.getPassword());
					cadastro.setCrm(txtCrm.getText());
					Cadastro.nomeMedico = txtUsuario.getText();

					controlaCadastro.cadastraUsuario(cadastro);

//					Printa o usuario e senha, apenas para não esquecer
//					System.out.println(cadastro.getUsuario());
//					System.out.println(cadastro.getSenha());

					TelaLogin telaInicial = new TelaLogin();

					telaInicial.setVisible(true);
					setVisible(false);

				}
			}
		});
		btnCriarConta.setBounds(70, 360, 135, 36);
		contentPane.add(btnCriarConta);

		JLabel lblNewLabel_1_1 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(70, 166, 96, 14);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Senha:");
		lblNewLabel_1_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(70, 222, 233, 14);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("CRM:");
		lblNewLabel_1_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(70, 277, 233, 14);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("*");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(129, 166, 96, 6);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("*");
		lblNewLabel_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(113, 222, 96, 6);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("v1.0.1");
		lblNewLabel_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(863, 436, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
