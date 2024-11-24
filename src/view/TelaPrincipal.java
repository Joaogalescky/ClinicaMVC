package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 5420355494474613004L;

	private JMenuBar barMenu;
	private JMenu cadastrarMenu;
	private JMenu prontuarioMenu;
	private JMenu ajudaMenu;

	private JMenuItem cadastrarUsuarioMenuItem;
	private JMenuItem cadastrarProfissionalMenuItem;
	private JMenuItem cadastrarFuncionarioMenuItem;
	private JMenuItem agendamentoMenuItem;
	private JMenuItem sobreMenuItem;
	private JMenuItem sairMenuItem;

	public TelaPrincipal() {

		super("Clínica Multidisciplinar");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.NORMAL);

		setLayout(new BorderLayout());

		barMenu = new JMenuBar();
		cadastrarMenu = new JMenu("Cadastrar");
		prontuarioMenu = new JMenu("Prontuario");
		ajudaMenu = new JMenu("Ajuda");

		cadastrarUsuarioMenuItem = new JMenuItem("Usuario");
		cadastrarProfissionalMenuItem = new JMenuItem("Profissional");
		cadastrarFuncionarioMenuItem = new JMenuItem("Funcionario");
		agendamentoMenuItem = new JMenuItem("Agendamento");
		sobreMenuItem = new JMenuItem("Sobre");
		sairMenuItem = new JMenuItem("Sair");

		cadastrarMenu.setMnemonic('U'); // configura o mnemônico como U
		prontuarioMenu.setMnemonic('P');
		ajudaMenu.setMnemonic('A');

		setJMenuBar(barMenu); // adiciona uma barra de menu na tela
		barMenu.add(cadastrarMenu);
		barMenu.add(prontuarioMenu);
		barMenu.add(ajudaMenu);

		cadastrarMenu.add(cadastrarUsuarioMenuItem);
		cadastrarMenu.add(cadastrarProfissionalMenuItem);
		cadastrarMenu.add(cadastrarFuncionarioMenuItem);
		cadastrarMenu.add(agendamentoMenuItem);
		ajudaMenu.add(sobreMenuItem);
		ajudaMenu.add(sairMenuItem);

		cadastrarUsuarioMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				TelaCadUser cadUsuario = new TelaCadUser();
			}
		});
		cadastrarProfissionalMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				TelaCadProfissional cadProfissional = new TelaCadProfissional();
			}
		});
		cadastrarFuncionarioMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				TelaCadFuncionario cadFuncionario = new TelaCadFuncionario();
			}
		});
		agendamentoMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				TelaCadAgendamento cadAgendamento = new TelaCadAgendamento();
			}
		});
		prontuarioMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent sair) {
				TelaProntuario telaProntuario = new TelaProntuario();
                telaProntuario.setVisible(true);
			}
		});
		sobreMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sobre) {
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Este é um exemplo do uso de menus.");
			}
		});
		sairMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				System.exit(0);
			}
		});
	}
}