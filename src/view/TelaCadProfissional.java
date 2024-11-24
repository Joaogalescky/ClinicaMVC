package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ProfissionalController;
import model.Profissional;

public class TelaCadProfissional extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel idProfissionalLabel;
    private JLabel especialidadeLabel;
    private JLabel crmEstadoLabel;
    private JLabel crmNumeroLabel;
    private JLabel horarioAtendLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JTextField idProfissionalJTextField;
    private JTextField especialidadeJTextField;
    private JTextField crmEstadoJTextField;
    private JTextField crmNumeroJTextField;
    private JTextField horarioAtendJTextField;
    private JTextField usernameJTextField;
    private JPasswordField passwordField;

    JButton cadastrarBtn;
    public JButton limparBtn;
    public JButton consultarBtn;
    public JButton alterarBtn;
    public JButton excluirBtn;

    public TelaCadProfissional() {
        super("Cadastro de Profissionais");

        idProfissionalLabel = new JLabel("Código do Usuário:");
        especialidadeLabel = new JLabel("Especialidade:");
        crmEstadoLabel = new JLabel("CRM Estado:");
        crmNumeroLabel = new JLabel("CRM Número:");
        horarioAtendLabel = new JLabel("Horário de Atendimento (HH:mm:ss):");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        idProfissionalJTextField = new JTextField();
        especialidadeJTextField = new JTextField();
        crmEstadoJTextField = new JTextField();
        crmNumeroJTextField = new JTextField();
        horarioAtendJTextField = new JTextField();
        usernameJTextField = new JTextField();
        passwordField = new JPasswordField();

        cadastrarBtn = new JButton("Cadastrar");
        alterarBtn = new JButton("Alterar");
        limparBtn = new JButton("Limpar");
        consultarBtn = new JButton("Consultar");
        excluirBtn = new JButton("Excluir");

        setSize(600, 400); // (largura, altura)
        setTitle("Cadastro de Profissionais");
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);

        idProfissionalLabel.setBounds(10, 10, 150, 25); // (x, y, largura, altura)
        idProfissionalJTextField.setBounds(230, 10, 300, 25);
        especialidadeLabel.setBounds(10, 40, 150, 25);
        especialidadeJTextField.setBounds(230, 40, 300, 25);
        crmEstadoLabel.setBounds(10, 70, 150, 25);
        crmEstadoJTextField.setBounds(230, 70, 300, 25);
        crmNumeroLabel.setBounds(10, 100, 150, 25);
        crmNumeroJTextField.setBounds(230, 100, 300, 25);
        horarioAtendLabel.setBounds(10, 130, 250, 25);
        horarioAtendJTextField.setBounds(230, 130, 300, 25);
        usernameLabel.setBounds(10, 160, 150, 25);
        usernameJTextField.setBounds(230, 160, 300, 25);
        passwordLabel.setBounds(10, 190, 150, 25);
        passwordField.setBounds(230, 190, 300, 25);

        cadastrarBtn.setBounds(20, 250, 100, 25);
        limparBtn.setBounds(130, 250, 80, 25);
        consultarBtn.setBounds(220, 250, 100, 25);
        alterarBtn.setBounds(330, 250, 100, 25);
        excluirBtn.setBounds(440, 250, 80, 25);

        add(idProfissionalLabel);
        add(idProfissionalJTextField);
        add(especialidadeLabel);
        add(especialidadeJTextField);
        add(crmEstadoLabel);
        add(crmEstadoJTextField);
        add(crmNumeroLabel);
        add(crmNumeroJTextField);
        add(horarioAtendLabel);
        add(horarioAtendJTextField);
        add(usernameLabel);
        add(usernameJTextField);
        add(passwordLabel);
        add(passwordField);

        add(cadastrarBtn);
        add(limparBtn);
        add(consultarBtn);
        add(alterarBtn);
        add(excluirBtn);

        cadastrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					//@formatter:off
                    ProfissionalController profissionalController = new ProfissionalController();
                    Time horarioAtendimento = Time.valueOf(horarioAtendJTextField.getText());
                    profissionalController.cadastrarProfissional(
                            Integer.parseInt(idProfissionalJTextField.getText()),
                            especialidadeJTextField.getText(),
                            crmEstadoJTextField.getText(),
                            crmNumeroJTextField.getText(),
                            horarioAtendimento,
                            usernameJTextField.getText(),
                            new String(passwordField.getPassword()));
					//@formatter:on
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
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
                    int idProfissional = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do usuário:"));
                    Profissional profissional = profissionalController.consultarProfissional(idProfissional);

                    if (profissional != null) {
                        idProfissionalJTextField.setText(String.valueOf(profissional.getIdProfissional()));
                        especialidadeJTextField.setText(profissional.getEspecialidade());
                        crmEstadoJTextField.setText(profissional.getCrm_estado());
                        crmNumeroJTextField.setText(profissional.getCrm_numero());
                        horarioAtendJTextField.setText(profissional.getHorarioAtend().toString());
                        usernameJTextField.setText(profissional.getUsername());
                        passwordField.setText(profissional.getPassword());
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
					//@formatter:off
                    ProfissionalController profissionalController = new ProfissionalController();
                    Time horarioAtendimento = Time.valueOf(horarioAtendJTextField.getText());
                    profissionalController.alterarProfissional(
                            Integer.parseInt(idProfissionalJTextField.getText()),
                            especialidadeJTextField.getText(),
                            crmEstadoJTextField.getText(),
                            crmNumeroJTextField.getText(),
                            horarioAtendimento,
                            usernameJTextField.getText(),
                            new String(passwordField.getPassword()));
                    JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
					//@formatter:on
                } catch (Exception ex) {
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
    }

    private void limparCampos() {
        idProfissionalJTextField.setText("");
        especialidadeJTextField.setText("");
        crmEstadoJTextField.setText("");
        crmNumeroJTextField.setText("");
        horarioAtendJTextField.setText("");
        usernameJTextField.setText("");
        passwordField.setText("");
    }
}
