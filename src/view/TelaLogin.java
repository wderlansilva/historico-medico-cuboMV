package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import negocio.Cadastro;
import persistencia.ControlaCadastro;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public TelaLogin() {
		setIconImage(null);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Entrar ou criar conta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cascadia Code", Font.PLAIN, 19));
		lblNewLabel.setBounds(114, 123, 270, 38);
		contentPane.add(lblNewLabel);

		JFormattedTextField txtUsuario = new JFormattedTextField();
		txtUsuario.setBackground(Color.LIGHT_GRAY);
		txtUsuario.setBorder(null);
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setFont(new Font("Cascadia Code", Font.PLAIN, 13));
		txtUsuario.setBounds(88, 202, 296, 41);
		contentPane.add(txtUsuario);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		txtSenha.setBackground(Color.LIGHT_GRAY);
		txtSenha.setBorder(null);
		txtSenha.setBounds(88, 279, 296, 41);
		contentPane.add(txtSenha);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(88, 264, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(88, 188, 86, 14);
		contentPane.add(lblNewLabel_1_1);

		JButton btnLogar = new JButton("LOGAR");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o seu usu�rio!");
				} else if (txtSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Informe a sua senha!");
				} else {

					boolean loginInvalido = true;

					for (Cadastro cadastro : ControlaCadastro.cadastro) {
						if (cadastro.getUsuario().equals(txtUsuario.getText())
								&& Arrays.equals(cadastro.getSenha(), txtSenha.getPassword())) {

							loginInvalido = false;

							TelaInicial telaInicial = new TelaInicial();
							telaInicial.setVisible(true);
							setVisible(false);
							break;
						}
					}

					if (loginInvalido) {
						JOptionPane.showMessageDialog(null, "Usu�rio inv�lido, Cadastre-se! ");
					}
				}
			}

		});
		btnLogar.setBackground(Color.LIGHT_GRAY);
		btnLogar.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnLogar.setBounds(88, 367, 130, 29);
		contentPane.add(btnLogar);

		JButton btnCadastrase = new JButton("CADASTRE-SE");
		btnCadastrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastro telaCadastro = new TelaCadastro();

				telaCadastro.setVisible(true);
				telaCadastro.setResizable(false);
				dispose();

			}
		});
		btnCadastrase.setBackground(Color.LIGHT_GRAY);
		btnCadastrase.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnCadastrase.setBounds(254, 367, 130, 29);
		contentPane.add(btnCadastrase);

		JLabel lblNewLabel_2 = new JLabel("Hist\u00F3rico m\u00E9dico | Wderl\u00E3n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Cascadia Code", Font.BOLD, 22));
		lblNewLabel_2.setBounds(70, 28, 389, 38);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("v1.0.1");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(863, 436, 46, 14);
		contentPane.add(lblNewLabel_3);

		
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Integer.class);
		
	
		
		

	}
}
