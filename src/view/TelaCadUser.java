package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.UsuarioController;
import model.Usuario;

public class TelaCadUser extends JFrame {

	private static final long serialVersionUID = 5756598100844974336L;

	private JLabel nomeJLabel;
	private JLabel dataNascimentoJLabel;
	private JLabel cpfJLabel;
	private JLabel rgJLabel;
	private JLabel foneJLabel;
	private JLabel emailJLabel;
	private JLabel enderecoJLabel;
	private JTextField nomeJTxtField;
	private JTextField dataNascimentoJTxtField;
	private JTextField cpfJTxtField;
	private JTextField rgJTxtField;
	private JTextField foneJTxtField;
	private JTextField emailJTxtField;
	private JTextField enderecoJTxtField;

	public JButton cadastrarBtn;
	public JButton limparBtn;
	public JButton consultarBtn;
	public JButton alterarBtn;
	public JButton excluirBtn;

	public TelaCadUser() {
		super("Cadastro de Usuarios");

		nomeJLabel = new JLabel("Nome");
		nomeJTxtField = new JTextField();
		dataNascimentoJLabel = new JLabel("Data de Nascimento");
		dataNascimentoJTxtField = new JTextField();
		cpfJLabel = new JLabel("CPF");
		cpfJTxtField = new JTextField();
		rgJLabel = new JLabel("RG");
		rgJTxtField = new JTextField();
		foneJLabel = new JLabel("Telefone");
		foneJTxtField = new JTextField();
		emailJLabel = new JLabel("E-mail");
		emailJTxtField = new JTextField();
		enderecoJLabel = new JLabel("Endereço");
		enderecoJTxtField = new JTextField();

		cadastrarBtn = new JButton("Cadastrar");
		alterarBtn = new JButton("Alterar");
		limparBtn = new JButton("Limpar");
		consultarBtn = new JButton("Consultar");
		excluirBtn = new JButton("Excluir");

		setSize(530, 320); // (largura, altura)
		setTitle("Cadastro de Usuarios");
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		nomeJLabel.setBounds(10, 10, 100, 25); // (x, y, largura, altura)
		nomeJTxtField.setBounds(150, 10, 200, 25);
		dataNascimentoJLabel.setBounds(10, 40, 200, 25);
		dataNascimentoJTxtField.setBounds(150, 40, 200, 25);
		cpfJLabel.setBounds(10, 70, 100, 25);
		cpfJTxtField.setBounds(150, 70, 200, 25);
		rgJLabel.setBounds(10, 100, 100, 25);
		rgJTxtField.setBounds(150, 100, 200, 25);
		foneJLabel.setBounds(10, 130, 100, 25);
		foneJTxtField.setBounds(150, 130, 200, 25);
		emailJLabel.setBounds(10, 160, 100, 25);
		emailJTxtField.setBounds(150, 160, 200, 25);
		enderecoJLabel.setBounds(10, 190, 100, 25);
		enderecoJTxtField.setBounds(150, 190, 200, 25);

		cadastrarBtn.setBounds(20, 230, 95, 25);
		limparBtn.setBounds(125, 230, 80, 25);
		consultarBtn.setBounds(215, 230, 90, 25);
		alterarBtn.setBounds(315, 230, 90, 25);
		excluirBtn.setBounds(415, 230, 80, 25);

		add(nomeJLabel);
		add(nomeJTxtField);
		add(dataNascimentoJLabel);
		add(dataNascimentoJTxtField);
		add(cpfJLabel);
		add(cpfJTxtField);
		add(rgJLabel);
		add(rgJTxtField);
		add(foneJLabel);
		add(foneJTxtField);
		add(emailJLabel);
		add(emailJTxtField);
		add(enderecoJLabel);
		add(enderecoJTxtField);

		add(cadastrarBtn);
		add(limparBtn);
		add(consultarBtn);
		add(alterarBtn);
		add(excluirBtn);

		alterarBtn.setEnabled(false);
		excluirBtn.setEnabled(false);
		// incluirBtn.setEnabled(false);

		cadastrarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioController usuarioController = new UsuarioController();
					usuarioController.cadastrarUsuario(
							nomeJTxtField.getText(), 
							dataNascimentoJTxtField.getText(), 
							cpfJTxtField.getText(), 
							rgJTxtField.getText(), 
							foneJTxtField.getText(), 
							emailJTxtField.getText(),
							enderecoJTxtField.getText()
							);
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
					limparCampos();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				}
			}
		});

		consultarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioController usuarioController = new UsuarioController();
					int codUser = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do usuario"));
					Usuario usuario = usuarioController.consultarUsuario(codUser);
					if (usuario != null) {
						nomeJTxtField.setText(usuario.getNome());
						dataNascimentoJTxtField.setText(usuario.getDataNascimento());
						cpfJTxtField.setText(usuario.getCpf());
						rgJTxtField.setText(usuario.getRg());
						foneJTxtField.setText(usuario.getTelefone());
						emailJTxtField.setText(usuario.getEmail());
						enderecoJTxtField.setText(usuario.getEndereco());
						alterarBtn.setEnabled(true);
						excluirBtn.setEnabled(true);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				}
			}
		});

		alterarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioController usuarioController = new UsuarioController();
					int codUser = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do usuario"));
					usuarioController.alterarUsuario(
							codUser, nomeJTxtField.getText(), 
							dataNascimentoJTxtField.getText(), 
							cpfJTxtField.getText(), 
							rgJTxtField.getText(), 
							foneJTxtField.getText(), 
							emailJTxtField.getText(), 
							enderecoJTxtField.getText()
							);
					JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				}
			}
		});

		limparBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeJTxtField.setText("");
				dataNascimentoJTxtField.setText("");
				cpfJTxtField.setText("");
				rgJTxtField.setText("");
				foneJTxtField.setText("");
				emailJTxtField.setText("");
				enderecoJTxtField.setText("");
			}
		});

		excluirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioController usuarioController = new UsuarioController();
					int codUser = Integer
							.parseInt(JOptionPane.showInputDialog("Informe o id do usuario a ser excluído: "));
					usuarioController.excluirUsuario(codUser);
					JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso!");
					limparCampos();
				} catch (Exception ex) {
					JOptionPane.showInputDialog("null", "Erro: " + ex.getMessage());
				}
			}
		});
	}

	private void limparCampos() {
		nomeJTxtField.setText("");
		dataNascimentoJTxtField.setText("");
		cpfJTxtField.setText("");
		rgJTxtField.setText("");
		foneJTxtField.setText("");
		emailJTxtField.setText("");
		enderecoJTxtField.setText("");
	}
}