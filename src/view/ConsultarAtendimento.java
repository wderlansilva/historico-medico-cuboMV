package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import negocio.Atendimento;
import negocio.Cadastro;
import persistencia.ControlaAtendimento;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ConsultarAtendimento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumeroAtendimento;
	private JTextField textField;
	private JTextField txtResultadoNome;
	private JTextField txtResultadoDiagnostico;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	public void mostrarNaTela(String nomePaciente, String nomeDiagnostico) {
		txtResultadoNome.setText(nomePaciente);
		txtResultadoDiagnostico.setText(nomeDiagnostico);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarAtendimento frame = new ConsultarAtendimento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsultarAtendimento() {

	}

	public ConsultarAtendimento(ControlaAtendimento controlaAtendimento) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Digite o numero do atendimento");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(70, 175, 212, 20);
		contentPane.add(lblNewLabel);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean verificaNumero = false;
				
				for (Atendimento atendimento : controlaAtendimento.verificaLista()) {

					if (atendimento.getNumeroAtendimento().equals(txtNumeroAtendimento.getText())) {

						verificaNumero = false;

						// metodo criado para consultar e mostrar na tela
						
						mostrarNaTela(atendimento.getNomePaciente(), atendimento.getDiagnostico());
						
						break;

					} else {
						verificaNumero = true;

					}
				}
				if (verificaNumero == true) {
					JOptionPane.showMessageDialog(null, "Número invalido!");

				}
			}
		});

		btnConsultar.setBounds(70, 255, 111, 37);
		contentPane.add(btnConsultar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.WHITE);
		btnSair.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				dispose();
				telaInicial.setVisible(true);
				telaInicial.setResizable(false);
			}
		});
		btnSair.setBounds(199, 255, 111, 37);
		contentPane.add(btnSair);

		txtNumeroAtendimento = new JTextField();
		txtNumeroAtendimento.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		txtNumeroAtendimento.setColumns(10);
		txtNumeroAtendimento.setBorder(null);
		txtNumeroAtendimento.setBackground(Color.LIGHT_GRAY);
		txtNumeroAtendimento.setBounds(70, 196, 241, 32);
		contentPane.add(txtNumeroAtendimento);

		textField = new JTextField();
		textField.setText("Bem vindo Dr." + Cadastro.nomeMedico);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(70, 28, 277, 56);
		contentPane.add(textField);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(400, 85, 482, 292);
		contentPane.add(panel);
		panel.setLayout(null);

		txtResultadoNome = new JTextField();
		txtResultadoNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtResultadoNome.setEditable(false);
		txtResultadoNome.setBorder(null);
		txtResultadoNome.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
		txtResultadoNome.setBounds(31, 71, 391, 41);
		panel.add(txtResultadoNome);
		txtResultadoNome.setColumns(10);

		txtResultadoDiagnostico = new JTextField();
		txtResultadoDiagnostico.setEditable(false);
		txtResultadoDiagnostico.setBorder(null);
		txtResultadoDiagnostico.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
		txtResultadoDiagnostico.setColumns(10);
		txtResultadoDiagnostico.setBounds(31, 168, 391, 41);
		panel.add(txtResultadoDiagnostico);

		lblNewLabel_1 = new JLabel("Nome do paciente");
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(31, 56, 161, 14);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Diagn\u00F3stico");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		lblNewLabel_2.setBounds(31, 152, 161, 14);
		panel.add(lblNewLabel_2);
	}

}
