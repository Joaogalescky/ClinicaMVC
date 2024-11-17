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

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private LoginController loginController;

	public TelaLogin() {
		loginController = new LoginController();
		setTitle("Login");
		setSize(320, 200); // (largura, altura)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblUsername = new JLabel("Usuário:");
		lblUsername.setBounds(30, 30, 80, 25); // (x, y, largura, altura)
		add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(120, 30, 150, 25);
		add(txtUsername);

		JLabel lblPassword = new JLabel("Senha:");
		lblPassword.setBounds(30, 70, 80, 25);
		add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(120, 70, 150, 25);
		add(txtPassword);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(120, 120, 100, 25);
		add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());

				try {
					if (loginController.autenticar(username, password)) {
						JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
						new TelaPrincipal().setVisible(true); // Abre a tela principal
						dispose(); // Fecha a tela de login
					} else {
						JOptionPane.showMessageDialog(null, "Invalid username or password");
					}
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new TelaLogin().setVisible(true);
	}
}