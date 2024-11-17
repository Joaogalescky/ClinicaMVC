package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.ProntuarioDAO;

public class TelaProntuario extends JFrame {

	private static final long serialVersionUID = 4885450894371296820L;

	private JTextField txtProfissional;
	private JTextField txtPaciente;
	private JTable tblResultados;
	private ProntuarioDAO prontuarioDAO;

	public TelaProntuario() {
		super("Prontuario");

		setTitle("Prontuário Médico");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Painel superior para busca
		JPanel pnlBusca = new JPanel(new GridLayout(2, 3, 10, 10));
		pnlBusca.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblProfissional = new JLabel("Buscar por Profissional:");
		txtProfissional = new JTextField();
		JButton btnBuscarProfissional = new JButton("Buscar");

		JLabel lblPaciente = new JLabel("Buscar por Paciente:");
		txtPaciente = new JTextField();
		JButton btnBuscarPaciente = new JButton("Buscar");

		pnlBusca.add(lblProfissional);
		pnlBusca.add(txtProfissional);
		pnlBusca.add(btnBuscarProfissional);
		pnlBusca.add(lblPaciente);
		pnlBusca.add(txtPaciente);
		pnlBusca.add(btnBuscarPaciente);

		add(pnlBusca, BorderLayout.NORTH);

		// Tabela para exibição dos resultados
		tblResultados = new JTable();
		add(new JScrollPane(tblResultados), BorderLayout.CENTER);

		// Conectar ao banco de dados e instanciar o DAO
//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "");
//			prontuarioDAO = new ProntuarioDAO(connection);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
//		}

		// Ações dos botões
		btnBuscarProfissional.addActionListener(e -> buscarPorProfissional());
		btnBuscarPaciente.addActionListener(e -> buscarPorPaciente());
	}

	private void buscarPorProfissional() {
		String profissional = txtProfissional.getText();
		try {
			List<String[]> resultados = prontuarioDAO.getPacientesPorProfissional(profissional);
			atualizarTabela(resultados, new String[] { "Paciente", "Data Atendimento", "Especialidade" });
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + e.getMessage());
		}
	}

	private void buscarPorPaciente() {
		String paciente = txtPaciente.getText();
		try {
			List<String[]> resultados = prontuarioDAO.getProfissionaisPorPaciente(paciente);
			atualizarTabela(resultados, new String[] { "Profissional", "Data Atendimento", "Especialidade" });
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + e.getMessage());
		}
	}

	private void atualizarTabela(List<String[]> dados, String[] colunas) {
		DefaultTableModel model = new DefaultTableModel(colunas, 0);
		for (String[] linha : dados) {
			model.addRow(linha);
		}
		tblResultados.setModel(model);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TelaProntuario().setVisible(true));
	}
}
