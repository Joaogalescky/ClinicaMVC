package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 5420355494474613004L;

	private JMenuBar barMenu; // cria a barra de menus
	private JMenu cadastroMenu; // cria o menu Cadastro
	private JMenu compraMenu; // cria o menu Compra
	private JMenu ajudaMenu; // cria o menu Compra
	private JMenuItem usuarioMenuItem; // cria o item de menu usuario
	private JMenuItem fornecedorMenuItem; // cria o item de menu fornecedor
	private JMenuItem produtoMenuItem; // cria o item de menu produto
	private JMenuItem sobreMenuItem; // cria o item de menu sobre
	private JMenuItem sairMenuItem; // cria o item de menu sair

	public TelaPrincipal() {

		super("Loja IFPR");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.NORMAL);

		setLayout(new BorderLayout());

		barMenu = new JMenuBar();
		cadastroMenu = new JMenu("Cadastro");
		compraMenu = new JMenu("Compra");
		ajudaMenu = new JMenu("Ajuda");

		usuarioMenuItem = new JMenuItem("Userente");
		fornecedorMenuItem = new JMenuItem("Fornecedor");
		produtoMenuItem = new JMenuItem("Produto");
		sobreMenuItem = new JMenuItem("Sobre");
		sairMenuItem = new JMenuItem("Sair");

		cadastroMenu.setMnemonic('C');// configura o mnemônico como C
		compraMenu.setMnemonic('o');// configura o mnemônico como o
		ajudaMenu.setMnemonic('A'); // configura o mnemônico como A

		setJMenuBar(barMenu); // adiciona uma barra de menu na tela
		barMenu.add(cadastroMenu);
		barMenu.add(compraMenu);
		barMenu.add(ajudaMenu);

		cadastroMenu.add(usuarioMenuItem);
		cadastroMenu.add(fornecedorMenuItem);
		cadastroMenu.add(produtoMenuItem);
		ajudaMenu.add(sobreMenuItem);
		ajudaMenu.add(sairMenuItem);

		sobreMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sobre) {
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Este é um exemplo\n" + "do uso de menus.");
			}
		});
		sairMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				System.exit(0);
			}
		});
		usuarioMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent sair) {
				TelaCadUser cadUsuario = new TelaCadUser();
			}
		});
	}
}