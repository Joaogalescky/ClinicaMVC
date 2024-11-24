package view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.LoginController;

public class TelaLogin extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private LoginController loginController;
	private JButton loginBtn;
	private JButton primeiroCadastroBtn;

	public TelaLogin() {
		loginController = new LoginController();
		setTitle("Login");
		setSize(370, 200); // (largura, altura)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblUsername = new JLabel("Usuário:");
		JLabel lblPassword = new JLabel("Senha:");
		usernameTxt = new JTextField();
		passwordTxt = new JPasswordField();
		loginBtn = new JButton("Login");
		primeiroCadastroBtn = new JButton("Primeiro Cadastro");
		
		lblUsername.setBounds(30, 30, 80, 25); // (x, y, largura, altura)
		lblPassword.setBounds(30, 70, 80, 25);
		usernameTxt.setBounds(120, 30, 150, 25);
		passwordTxt.setBounds(120, 70, 150, 25);
		loginBtn.setBounds(30, 120, 100, 25);
		primeiroCadastroBtn.setBounds(170, 120, 150, 25);
		
		add(lblUsername);
		add(lblPassword);
		add(usernameTxt);
		add(passwordTxt);
		add(loginBtn);
		add(primeiroCadastroBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTxt.getText();
				String password = new String(passwordTxt.getPassword());

				try {
					if (loginController.autenticar(username, password)) {
						JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
						new TelaPrincipal().setVisible(true); // Abre a tela principal
						dispose(); // Fecha a tela de login
					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		primeiroCadastroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaSelecaoCadastro().setVisible(true);;
                dispose();
            }
        });
	}

	public static void main(String[] args) {
		new TelaLogin().setVisible(true);
	}
}