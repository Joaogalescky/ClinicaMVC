package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaSelecaoCadastro extends JFrame {
	private static final long serialVersionUID = 1L;

	public TelaSelecaoCadastro() {
		setTitle("Seleção de Cadastro");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel label = new JLabel("Escolha o tipo de cadastro:");
		JButton profissionalButton = new JButton("Profissional");
		JButton funcionarioButton = new JButton("Funcionário");

		label.setBounds(100, 10, 200, 25);
		profissionalButton.setBounds(70, 50, 120, 25);
		funcionarioButton.setBounds(210, 50, 120, 25);

		add(label);
		add(profissionalButton);
		add(funcionarioButton);

		profissionalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCompleto(true);
				dispose();
			}
		});

		funcionarioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCompleto(false);
				dispose();
			}
		});
	}
}
