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

		// Exibe a tela de cadastro de usuário
		TelaCadUser userScreen = new TelaCadUser();
		userScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		userScreen.setVisible(true);

		// Exibe o próximo cadastro
		userScreen.cadastrarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//@formatter:off
                JOptionPane.showMessageDialog(null, "Cadastro de Pessoa concluído! Agora, prossiga com o cadastro de " +
                (ehProfissional ? "Profissional." : "Funcionário."));
                userScreen.dispose();

                if (ehProfissional) {
                    TelaCadProfissional profissionalScreen = new TelaCadProfissional();
                    profissionalScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    profissionalScreen.setVisible(true);

                    // Ação ao botão de cadastro do Profissional
                    profissionalScreen.cadastrarBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, "Cadastro de Profissional concluído! Retornando ao Login.");
                            profissionalScreen.dispose();
                            abrirTelaLogin();
                        }
                    });
                //@formatter:on
				} else {
					TelaCadFuncionario funcionarioScreen = new TelaCadFuncionario();
					funcionarioScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					funcionarioScreen.setVisible(true);

					// Ação ao botão de cadastro do Funcionário
					funcionarioScreen.cadastrarBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null,
									"Cadastro de Funcionário(a) concluído! Retornando ao Login.");
							funcionarioScreen.dispose();
							abrirTelaLogin();
						}
					});
				}
				dispose();
			}
		});
	}

	private void abrirTelaLogin() {
		TelaLogin loginScreen = new TelaLogin();
		loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginScreen.setVisible(true);
	}
}
