package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ProfissionalController;
import model.Profissional;

public class TelaCadProfissional extends JFrame {

    private static final long serialVersionUID = 1L;

    // Usuário
    private JLabel nomeLabel;
    private JLabel dataNascimentoLabel;
    private JLabel cpfLabel;
    private JLabel rgLabel;
    private JLabel foneLabel;
    private JLabel emailLabel;
    private JLabel enderecoLabel;

    private JTextField nomeJTxtField;
    private JTextField dataNascimentoJTxtField;
    private JTextField cpfJTxtField;
    private JTextField rgJTxtField;
    private JTextField foneJTxtField;
    private JTextField emailJTxtField;
    private JTextField enderecoJTxtField;
    
    // Profissional
    private JLabel especialidadeLabel;
    private JLabel crmEstadoLabel;
    private JLabel crmNumeroLabel;
    private JLabel horarioAtendLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JTextField especialidadeJTxtField;
    private JTextField crmEstadoJTxtField;
    private JTextField crmNumeroJTxtField;
    private JTextField horarioAtendJTxtField;
    private JTextField usernameJTxtField;
    private JPasswordField passwordField;

    // Funcionário
    private JLabel tipoCadastroLabel;
    private JComboBox<String> tipoCadastroComboBox;
    
    // Botões
    JButton cadastrarBtn;
    public JButton limparBtn;
    public JButton consultarBtn;
    public JButton alterarBtn;
    public JButton excluirBtn;

    public TelaCadProfissional() {
        super("Cadastro de Profissionais");

        // Campos de Usuário
        nomeLabel = new JLabel("Nome:");
        dataNascimentoLabel = new JLabel("Data de Nascimento:");
        cpfLabel = new JLabel("CPF:");
        rgLabel = new JLabel("RG:");
        foneLabel = new JLabel("Telefone:");
        emailLabel = new JLabel("E-mail:");
        enderecoLabel = new JLabel("Endereço:");
  
        nomeJTxtField = new JTextField();
        dataNascimentoJTxtField = new JTextField();
        cpfJTxtField = new JTextField();
        rgJTxtField = new JTextField();
        foneJTxtField = new JTextField();
        emailJTxtField = new JTextField();
        enderecoJTxtField = new JTextField();
       
        // Campos de Profissional
        especialidadeLabel = new JLabel("Especialidade:");
        crmEstadoLabel = new JLabel("CRM Estado:");
        crmNumeroLabel = new JLabel("CRM Número:");
        horarioAtendLabel = new JLabel("Horário de Atendimento (HH:mm:ss):");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        especialidadeJTxtField = new JTextField();
        crmEstadoJTxtField = new JTextField();
        crmNumeroJTxtField = new JTextField();
        horarioAtendJTxtField = new JTextField();
        usernameJTxtField = new JTextField();
        passwordField = new JPasswordField();
        
        // Campos de Funcionário
        tipoCadastroLabel = new JLabel("Tipo de Cadastro:");
        tipoCadastroComboBox = new JComboBox<>(new String[] { "Profissional (Médico)", "Funcionário" });

        // Botões
        cadastrarBtn = new JButton("Cadastrar");
        alterarBtn = new JButton("Alterar");
        limparBtn = new JButton("Limpar");
        consultarBtn = new JButton("Consultar");
        excluirBtn = new JButton("Excluir");

        setSize(630, 550); // (largura, altura)
        setTitle("Cadastro de Profissionais");
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        // Campos de Usuário
        nomeLabel.setBounds(10, 10, 150, 25);
        nomeJTxtField.setBounds(230, 10, 340, 25);
        dataNascimentoLabel.setBounds(10, 40, 150, 25);
        dataNascimentoJTxtField.setBounds(230, 40, 340, 25);
        cpfLabel.setBounds(10, 70, 150, 25);
        cpfJTxtField.setBounds(230, 70, 340, 25);
        rgLabel.setBounds(10, 100, 150, 25);
        rgJTxtField.setBounds(230, 100, 340, 25);
        foneLabel.setBounds(10, 130, 150, 25);
        foneJTxtField.setBounds(230, 130, 340, 25);
        emailLabel.setBounds(10, 160, 150, 25);
        emailJTxtField.setBounds(230, 160, 340, 25);
        enderecoLabel.setBounds(10, 190, 150, 25);
        enderecoJTxtField.setBounds(230, 190, 340, 25);

        add(nomeLabel);
        add(nomeJTxtField);
        add(dataNascimentoLabel);
        add(dataNascimentoJTxtField);
        add(cpfLabel);
        add(cpfJTxtField);
        add(rgLabel);
        add(rgJTxtField);
        add(foneLabel);
        add(foneJTxtField);
        add(emailLabel);
        add(emailJTxtField);
        add(enderecoLabel);
        add(enderecoJTxtField);
        
        // Campos de Profissional
        especialidadeLabel.setBounds(10, 220, 150, 25); // (x, y, largura, altura)
        especialidadeJTxtField.setBounds(230, 220, 340, 25);
        crmEstadoLabel.setBounds(10, 250, 150, 25);
        crmEstadoJTxtField.setBounds(230, 250, 340, 25);
        crmNumeroLabel.setBounds(10, 280, 150, 25);
        crmNumeroJTxtField.setBounds(230, 280, 340, 25);
        horarioAtendLabel.setBounds(10, 310, 150, 25);
        horarioAtendJTxtField.setBounds(230, 310, 340, 25);
        usernameLabel.setBounds(10, 340, 250, 25);
        usernameJTxtField.setBounds(230, 340, 340, 25);
        passwordLabel.setBounds(10, 370, 150, 25);
        passwordField.setBounds(230, 370, 340, 25);

        add(especialidadeLabel);
        add(especialidadeJTxtField);
        add(crmEstadoLabel);
        add(crmEstadoJTxtField);
        add(crmNumeroLabel);
        add(crmNumeroJTxtField);
        add(horarioAtendLabel);
        add(horarioAtendJTxtField);
        add(usernameLabel);
        add(usernameJTxtField);
        add(passwordLabel);
        add(passwordField);
        
        // Campos de Funcionário
        tipoCadastroLabel.setBounds(470, 10, 150, 25); // Canto superior direito
        tipoCadastroComboBox.setBounds(470, 40, 150, 25);
        
        add(tipoCadastroLabel);
        add(tipoCadastroComboBox);

        // Botões
        cadastrarBtn.setBounds(10, 420, 120, 25);
        limparBtn.setBounds(140, 420, 100, 25);
        consultarBtn.setBounds(250, 420, 100, 25);
        alterarBtn.setBounds(360, 420, 100, 25);
        excluirBtn.setBounds(470, 420, 100, 25);

        add(cadastrarBtn);
        add(limparBtn);
        add(consultarBtn);
        add(alterarBtn);
        add(excluirBtn);

        cadastrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                    if (especialidadeJTxtField.getText().isEmpty() ||
                        crmEstadoJTxtField.getText().isEmpty() ||
                        crmNumeroJTxtField.getText().isEmpty() ||
                        horarioAtendJTxtField.getText().isEmpty() ||
                        usernameJTxtField.getText().isEmpty() ||
                        passwordField.getPassword().length == 0 ||
                        nomeJTxtField.getText().isEmpty() ||
                        dataNascimentoJTxtField.getText().isEmpty() ||
                        cpfJTxtField.getText().isEmpty() ||
                        rgJTxtField.getText().isEmpty() ||
                        foneJTxtField.getText().isEmpty() ||
                        emailJTxtField.getText().isEmpty() ||
                        enderecoJTxtField.getText().isEmpty()) {
                        throw new Exception("Todos os campos devem ser preenchidos.");
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    dateFormat.setLenient(false);
                    Date parsedDate = dateFormat.parse(dataNascimentoJTxtField.getText());
                    java.sql.Date sqlDateDataNascimento = new java.sql.Date(parsedDate.getTime());

                    // Instanciar o controlador de profissional
                    ProfissionalController profissionalController = new ProfissionalController();

                    // Cadastro integrado
                    profissionalController.cadastrarProfissionalComUsuario(
                        nomeJTxtField.getText(),
                        sqlDateDataNascimento,
                        cpfJTxtField.getText(),
                        rgJTxtField.getText(),
                        foneJTxtField.getText(),
                        emailJTxtField.getText(),
                        enderecoJTxtField.getText(),
                        especialidadeJTxtField.getText(),
                        crmEstadoJTxtField.getText(),
                        crmNumeroJTxtField.getText(),
                        Time.valueOf(horarioAtendJTxtField.getText()),
                        usernameJTxtField.getText(),
                        new String(passwordField.getPassword())
                    );

                    JOptionPane.showMessageDialog(null, "Cadastro de usuário e profissional realizado com sucesso!");
                    limparCampos();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
                }
            }
        });

        consultarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					//@formatter:off
                    ProfissionalController profissionalController = new ProfissionalController();
                    int idProfissional = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do profissional:"));
                    Profissional profissional = profissionalController.consultarProfissionalComUsuario(idProfissional);

                    if (profissional != null) {
                        especialidadeJTxtField.setText(profissional.getEspecialidade());
                        crmEstadoJTxtField.setText(profissional.getCrm_estado());
                        crmNumeroJTxtField.setText(profissional.getCrm_numero());
                        horarioAtendJTxtField.setText(profissional.getHorarioAtend().toString());
                        usernameJTxtField.setText(profissional.getUsername());
                        passwordField.setText(profissional.getPassword());

                        nomeJTxtField.setText(profissional.getNome());
                        dataNascimentoJTxtField.setText(profissional.getDataNascimento().toString());
                        cpfJTxtField.setText(profissional.getCpf());
                        rgJTxtField.setText(profissional.getRg());
                        foneJTxtField.setText(profissional.getTelefone());
                        emailJTxtField.setText(profissional.getEmail());
                        enderecoJTxtField.setText(profissional.getEndereco());

                        alterarBtn.setEnabled(true);
                        excluirBtn.setEnabled(true);
    				//@formatter:on
                    } else {
                        JOptionPane.showMessageDialog(null, "Profissional não encontrado!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
                }
            }
        });

        alterarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idProfissional = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do profissional a ser alterado:"));
                    ProfissionalController profissionalController = new ProfissionalController();
                    Profissional profissional = profissionalController.consultarProfissionalComUsuario(idProfissional);

                    if (profissional == null) {
                        JOptionPane.showMessageDialog(null, "Profissional não encontrado.");
                        return;
                    }

                    // Atualiza os dados do profissional com os valores dos campos de texto
                    profissional.setNome(nomeJTxtField.getText());
                    profissional.setDataNascimento(java.sql.Date.valueOf(dataNascimentoJTxtField.getText()));
                    profissional.setCpf(cpfJTxtField.getText());
                    profissional.setRg(rgJTxtField.getText());
                    profissional.setTelefone(foneJTxtField.getText());
                    profissional.setEmail(emailJTxtField.getText());
                    profissional.setEndereco(enderecoJTxtField.getText());

                    profissional.setEspecialidade(especialidadeJTxtField.getText());
                    profissional.setCrm_estado(crmEstadoJTxtField.getText());
                    profissional.setCrm_numero(crmNumeroJTxtField.getText());
                    profissional.setHorarioAtend(Time.valueOf(horarioAtendJTxtField.getText()));
                    profissional.setUsername(usernameJTxtField.getText());
                    profissional.setPassword(new String(passwordField.getPassword()));

                    // Chama o método para alterar os dados do profissional no banco
                    profissionalController.alterarProfissionalComUsuario(
                    	idProfissional,
                        profissional.getNome(),
                        profissional.getDataNascimento(),
                        profissional.getCpf(),
                        profissional.getRg(),
                        profissional.getTelefone(),
                        profissional.getEmail(),
                        profissional.getEndereco(),
                        profissional.getEspecialidade(),
                        profissional.getCrm_estado(),
                        profissional.getCrm_numero(),
                        profissional.getHorarioAtend(),
                        profissional.getUsername(),
                        profissional.getPassword()

                    );

                    // Exibe uma mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");

                } catch (Exception ex) {
                    // Exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
                }
            }
        });


        excluirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					//@formatter:off
                    ProfissionalController profissionalController = new ProfissionalController();
                    int idProfissional = Integer
                            .parseInt(JOptionPane.showInputDialog("Informe o código do usuário a ser excluído:"));
                    profissionalController.excluirProfissional(idProfissional);
					//@formatter:on
                    JOptionPane.showMessageDialog(null, "Profissional excluído com sucesso!");
                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
                }
            }
        });

        limparBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    
        tipoCadastroComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selecionado = (String) tipoCadastroComboBox.getSelectedItem();
				
				if (selecionado.equals("Funcionário")) {
					crmEstadoLabel.setEnabled(false);
					crmEstadoJTxtField.setEnabled(false);
					crmNumeroLabel.setEnabled(false);
					crmNumeroJTxtField.setEnabled(false);
					
		            crmEstadoJTxtField.setText("");
		            crmNumeroJTxtField.setText("");
				} else if (selecionado.equals("Profissional")) {
		            crmEstadoLabel.setEnabled(true);
		            crmEstadoJTxtField.setEnabled(true);
		            crmNumeroLabel.setEnabled(true);
		            crmNumeroJTxtField.setEnabled(true);
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
        especialidadeJTxtField.setText("");
        crmEstadoJTxtField.setText("");
        crmNumeroJTxtField.setText("");
        horarioAtendJTxtField.setText("");
        usernameJTxtField.setText("");
        passwordField.setText("");
    }
}
