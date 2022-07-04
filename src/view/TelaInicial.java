package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negocio.Cadastro;
import persistencia.ControlaAtendimento;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeMedico;

	ControlaAtendimento controlaAtendimento = new ControlaAtendimento();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrarAtendimento = new JButton("Registrar atendimento");
		btnRegistrarAtendimento.setBorder(null);
		btnRegistrarAtendimento.setForeground(Color.BLACK);
		btnRegistrarAtendimento.setBackground(Color.LIGHT_GRAY);
		btnRegistrarAtendimento.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		btnRegistrarAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RegistrarAtendimento registrarAtendimento = new RegistrarAtendimento(controlaAtendimento);
				dispose();
				registrarAtendimento.setVisible(true);
				registrarAtendimento.setResizable(false);

			}
		});
		btnRegistrarAtendimento.setBounds(70, 118, 238, 37);
		contentPane.add(btnRegistrarAtendimento);

		JButton btnSair = new JButton("SAIR");
		btnSair.setBackground(Color.WHITE);
		btnSair.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaLogin telaLogin = new TelaLogin();

				dispose();
				telaLogin.setVisible(true);
				telaLogin.setResizable(false);

			}
		});
		btnSair.setBounds(70, 395, 123, 37);
		contentPane.add(btnSair);

		JButton btnRemoverAtendimento = new JButton("Remover atendimento");
		btnRemoverAtendimento.setForeground(Color.BLACK);
		btnRemoverAtendimento.setBackground(Color.LIGHT_GRAY);
		btnRemoverAtendimento.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		btnRemoverAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RemoverAtendimento removerAtendimento = new RemoverAtendimento(controlaAtendimento);
				dispose();
				removerAtendimento.setVisible(true);
				removerAtendimento.setResizable(false);
			}
		});
		btnRemoverAtendimento.setBounds(70, 294, 238, 37);
		contentPane.add(btnRemoverAtendimento);

		JButton btnConsultarAtendimento = new JButton("Consultar atendimento");
		btnConsultarAtendimento.setForeground(Color.BLACK);
		btnConsultarAtendimento.setBackground(Color.LIGHT_GRAY);
		btnConsultarAtendimento.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		btnConsultarAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConsultarAtendimento consultarAtendimento = new ConsultarAtendimento(controlaAtendimento);

				dispose();
				consultarAtendimento.setVisible(true);
				consultarAtendimento.setResizable(false);

			}
		});
		btnConsultarAtendimento.setBounds(70, 204, 238, 37);
		contentPane.add(btnConsultarAtendimento);

		txtNomeMedico = new JTextField();
		txtNomeMedico.setBorder(null);
		txtNomeMedico.setForeground(Color.WHITE);
		txtNomeMedico.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
		txtNomeMedico.setBackground(Color.DARK_GRAY);
		txtNomeMedico.setText("Bem vindo Dr. " + Cadastro.nomeMedico);
		txtNomeMedico.setEditable(false);
		txtNomeMedico.setBounds(70, 28, 277, 56);
		contentPane.add(txtNomeMedico);
		txtNomeMedico.setColumns(10);

		JLabel lblNewLabel = new JLabel("v1.0.1");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(863, 436, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
