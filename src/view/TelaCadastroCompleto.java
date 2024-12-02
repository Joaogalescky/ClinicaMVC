package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaCadastroCompleto extends JFrame {
	private static final long serialVersionUID = 1L;

	public TelaCadastroCompleto(boolean ehProfissional) {
		setTitle(ehProfissional ? "Cadastro de Profissional" : "Cadastro de Funcionário(a)");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		if (ehProfissional) {
			TelaCadProfissional profissional = new TelaCadProfissional();
			profissional.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			profissional.setVisible(true);

			profissional.cadastrarBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JOptionPane.showMessageDialog(null, "Cadastro de Profissional concluído! Retornando ao Login.");
						profissional.dispose();
						abrirTelaLogin();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro no cadastro: " + ex.getMessage());
					}
				}
			});
		} else {
			TelaCadFuncionario funcionario = new TelaCadFuncionario();
			funcionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			funcionario.setVisible(true);

			funcionario.cadastrarBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						JOptionPane.showMessageDialog(null, "Cadastro de Funcionário(a) concluído! Retornando ao Login.");
						funcionario.dispose();
						abrirTelaLogin();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro no cadastro: " + ex.getMessage());
					}
				}
			});
		}
	}

	private void abrirTelaLogin() {
		TelaLogin loginScreen = new TelaLogin();
		loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginScreen.setVisible(true);
	}
}
