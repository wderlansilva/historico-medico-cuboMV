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

public class RegistrarAtendimento extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtNomePaciente;
	private JTextField txtDiagnostico;
	private JTextField txtNumeroAtendimento;
	private JTextField textField;
	private JTextField txtNumeroTotal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarAtendimento frame = new RegistrarAtendimento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistrarAtendimento() {

	}

	public RegistrarAtendimento(ControlaAtendimento controlaAtendimento) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNomePaciente = new JTextField();
		txtNomePaciente.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		txtNomePaciente.setBorder(null);
		txtNomePaciente.setBackground(Color.LIGHT_GRAY);
		txtNomePaciente.setBounds(70, 120, 241, 32);
		contentPane.add(txtNomePaciente);
		txtNomePaciente.setColumns(10);

		JLabel lblDiagnostico = new JLabel("Diagn\u00F3stico");
		lblDiagnostico.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblDiagnostico.setForeground(Color.LIGHT_GRAY);
		lblDiagnostico.setBounds(70, 246, 173, 14);
		contentPane.add(lblDiagnostico);

		txtDiagnostico = new JTextField();
		txtDiagnostico.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		txtDiagnostico.setBorder(null);
		txtDiagnostico.setBackground(Color.LIGHT_GRAY);
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setBounds(70, 260, 241, 32);
		contentPane.add(txtDiagnostico);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.WHITE);
		btnVoltar.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				dispose();
				telaInicial.setVisible(true);
				telaInicial.setResizable(false);

			}
		});
		btnVoltar.setBounds(206, 397, 105, 37);
		contentPane.add(btnVoltar);

		txtNumeroAtendimento = new JTextField();
		txtNumeroAtendimento.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		txtNumeroAtendimento.setBackground(Color.LIGHT_GRAY);
		txtNumeroAtendimento.setBorder(null);
		txtNumeroAtendimento.setColumns(10);
		txtNumeroAtendimento.setBounds(70, 188, 241, 32);
		contentPane.add(txtNumeroAtendimento);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atendimento atendimento = new Atendimento();

				atendimento.setNomePaciente(txtNomePaciente.getText());
				atendimento.setNumeroAtendimento(txtNumeroAtendimento.getText());
				atendimento.setDiagnostico(txtDiagnostico.getText());

				controlaAtendimento.cadastrarAtendimento(atendimento);

				if (txtNomePaciente != null && txtDiagnostico != null && txtNumeroAtendimento != null) {
					JOptionPane.showMessageDialog(null, "Atendimento adicionado!");
					Atendimento.numeroTotalAtendimento++;
				}
				
				txtNomePaciente.setText("");
				txtNumeroAtendimento.setText("");
				txtDiagnostico.setText("");
				txtNomePaciente.requestFocus();
				txtNumeroTotal.setText("Atendimentos cadastrados hoje: " + Atendimento.numeroTotalAtendimento);
			}

		});


		btnRegistrar.setBounds(70, 397, 114, 37);
		contentPane.add(btnRegistrar);

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

		JLabel lblNmeroDoAtendimento = new JLabel("N\u00FAmero do atendimento");
		lblNmeroDoAtendimento.setForeground(Color.LIGHT_GRAY);
		lblNmeroDoAtendimento.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNmeroDoAtendimento.setBounds(70, 173, 173, 14);
		contentPane.add(lblNmeroDoAtendimento);

		JLabel lblNomeDoPaciente = new JLabel("Nome do paciente");
		lblNomeDoPaciente.setForeground(Color.LIGHT_GRAY);
		lblNomeDoPaciente.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNomeDoPaciente.setBounds(70, 105, 173, 14);
		contentPane.add(lblNomeDoPaciente);

		txtNumeroTotal = new JTextField();
		txtNumeroTotal.setBorder(null);
		txtNumeroTotal.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txtNumeroTotal.setForeground(Color.LIGHT_GRAY);
		txtNumeroTotal.setBackground(Color.DARK_GRAY);
		txtNumeroTotal.setEditable(false);
		txtNumeroTotal.setText("Atendimentos cadastrados hoje: " + Atendimento.numeroTotalAtendimento);
		txtNumeroTotal.setBounds(70, 329, 309, 20);
		contentPane.add(txtNumeroTotal);
		txtNumeroTotal.setColumns(10);

	}
}
