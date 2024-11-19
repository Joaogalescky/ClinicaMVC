package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadAgendamento extends JFrame {

	private static final long serialVersionUID = -4998166069381980343L;

	private JLabel idpacienteJLabel;
	private JLabel idprofissionalJLabel;
	private JLabel dataHoraAgendamentoJLabel;
	private JLabel statusJLabel;

	private JTextField idpacienteJTxtField;
	private JTextField idprofissionalJTxtField;
	private JTextField dataHoraAgendamentoJTxtField;
	private JTextField statusJTxtField;

	public JButton agendarBtn;
	public JButton limparBtn;
	public JButton consultarBtn;
	public JButton alterarBtn;
	public JButton excluirBtn;

	public TelaCadAgendamento() {
		super("Cadastro de Agendamentos");

		idpacienteJLabel = new JLabel("Código Paciente");
		idpacienteJTxtField = new JTextField();
		idprofissionalJLabel = new JLabel("Codigo Profissional");
		idprofissionalJTxtField = new JTextField();
		dataHoraAgendamentoJLabel = new JLabel("Data e Hora");
		dataHoraAgendamentoJTxtField = new JTextField();
		statusJLabel = new JLabel("Status");
		statusJTxtField = new JTextField();

		agendarBtn = new JButton("Agendar");
		alterarBtn = new JButton("Alterar");
		limparBtn = new JButton("Limpar");
		consultarBtn = new JButton("Consultar");
		excluirBtn = new JButton("Excluir");

		setSize(530, 320); // (largura, altura)
		setTitle("Cadastro de Agendamento");
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		idpacienteJLabel.setBounds(10, 10, 100, 25); // (x, y, largura, altura)
		idpacienteJTxtField.setBounds(150, 10, 200, 25);
		idprofissionalJLabel.setBounds(10, 40, 200, 25);
		idprofissionalJTxtField.setBounds(150, 40, 200, 25);
		dataHoraAgendamentoJLabel.setBounds(10, 70, 100, 25);
		dataHoraAgendamentoJTxtField.setBounds(150, 70, 200, 25);
		statusJLabel.setBounds(10, 100, 100, 25);
		statusJTxtField.setBounds(150, 100, 200, 25);

		agendarBtn.setBounds(20, 230, 95, 25);
		limparBtn.setBounds(125, 230, 80, 25);
		consultarBtn.setBounds(215, 230, 90, 25);
		alterarBtn.setBounds(315, 230, 90, 25);
		excluirBtn.setBounds(415, 230, 80, 25);

		add(idpacienteJLabel);
		add(idpacienteJTxtField);
		add(idprofissionalJLabel);
		add(idprofissionalJTxtField);
		add(dataHoraAgendamentoJLabel);
		add(dataHoraAgendamentoJTxtField);
		add(statusJLabel);
		add(statusJTxtField);

		add(agendarBtn);
		add(limparBtn);
		add(consultarBtn);
		add(alterarBtn);
		add(excluirBtn);

		alterarBtn.setEnabled(false);
		excluirBtn.setEnabled(false);
	}
}