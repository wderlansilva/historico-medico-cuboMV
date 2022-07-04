package view;

import java.awt.EventQueue;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RemoverAtendimento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBemVindoDr;
	private JTextField txtNumeroAtendimento;

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

	public RemoverAtendimento() {

	}

	public RemoverAtendimento(ControlaAtendimento controlaAtendimento) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 935, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtBemVindoDr = new JTextField();
		txtBemVindoDr.setForeground(Color.WHITE);
		txtBemVindoDr.setBorder(null);
		txtBemVindoDr.setBackground(Color.DARK_GRAY);
		txtBemVindoDr.setFont(new Font("JetBrains Mono", Font.PLAIN, 22));
		txtBemVindoDr.setText("Bem vindo Dr." + Cadastro.nomeMedico);
		txtBemVindoDr.setBounds(70, 28, 295, 36);
		contentPane.add(txtBemVindoDr);
		txtBemVindoDr.setColumns(10);

		JLabel lblNewLabel = new JLabel("Digite o numero do atendimento");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		lblNewLabel.setBounds(70, 131, 212, 20);
		contentPane.add(lblNewLabel);

		txtNumeroAtendimento = new JTextField();
		txtNumeroAtendimento.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		txtNumeroAtendimento.setBorder(null);
		txtNumeroAtendimento.setBackground(Color.LIGHT_GRAY);
		txtNumeroAtendimento.setBounds(70, 149, 233, 41);
		contentPane.add(txtNumeroAtendimento);
		txtNumeroAtendimento.setColumns(10);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnRemover.setBorder(null);
		btnRemover.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				boolean atendimentoInvalido = false;
				for (Atendimento atendimento : controlaAtendimento.verificaLista()) {

					if (atendimento.getNumeroAtendimento().equals(txtNumeroAtendimento.getText())) {
						atendimentoInvalido = true;
						controlaAtendimento.removeAtendimento(atendimento);

						JOptionPane.showMessageDialog(null, "Atendimento removido!");
						txtNumeroAtendimento.setText("");
						break;
					}
				}
				if (atendimentoInvalido == false) {
					JOptionPane.showMessageDialog(null, "Número de atendimento não encontrado!");
				}
			}

		});
		btnRemover.setBounds(70, 243, 89, 36);
		contentPane.add(btnRemover);

		JButton btnSair = new JButton("Sair");
		btnSair.setBackground(Color.WHITE);
		btnSair.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
		btnSair.setBorder(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial telaInicial = new TelaInicial();
				dispose();
				telaInicial.setVisible(true);
				telaInicial.setResizable(false);
			}
		});
		btnSair.setBounds(209, 243, 89, 36);
		contentPane.add(btnSair);
	}

}
