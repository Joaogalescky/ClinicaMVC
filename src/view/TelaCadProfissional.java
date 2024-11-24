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

    private JTextField idProfissionalField;
    private JTextField especialidadeField;
    private JTextField crmEstadoField;
    private JTextField crmNumeroField;
    private JTextField horarioAtendField;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public JButton cadastrarBtn;
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

        idProfissionalField = new JTextField();
        especialidadeField = new JTextField();
        crmEstadoField = new JTextField();
        crmNumeroField = new JTextField();
        horarioAtendField = new JTextField();
        usernameField = new JTextField();
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
        idProfissionalField.setBounds(230, 10, 300, 25);
        especialidadeLabel.setBounds(10, 40, 150, 25);
        especialidadeField.setBounds(230, 40, 300, 25);
        crmEstadoLabel.setBounds(10, 70, 150, 25);
        crmEstadoField.setBounds(230, 70, 300, 25);
        crmNumeroLabel.setBounds(10, 100, 150, 25);
        crmNumeroField.setBounds(230, 100, 300, 25);
        horarioAtendLabel.setBounds(10, 130, 250, 25);
        horarioAtendField.setBounds(230, 130, 300, 25);
        usernameLabel.setBounds(10, 160, 150, 25);
        usernameField.setBounds(230, 160, 300, 25);
        passwordLabel.setBounds(10, 190, 150, 25);
        passwordField.setBounds(230, 190, 300, 25);

        cadastrarBtn.setBounds(20, 250, 100, 25);
        limparBtn.setBounds(130, 250, 80, 25);
        consultarBtn.setBounds(220, 250, 100, 25);
        alterarBtn.setBounds(330, 250, 100, 25);
        excluirBtn.setBounds(440, 250, 80, 25);

        add(idProfissionalLabel);
        add(idProfissionalField);
        add(especialidadeLabel);
        add(especialidadeField);
        add(crmEstadoLabel);
        add(crmEstadoField);
        add(crmNumeroLabel);
        add(crmNumeroField);
        add(horarioAtendLabel);
        add(horarioAtendField);
        add(usernameLabel);
        add(usernameField);
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
                    Time horarioAtendimento = Time.valueOf(horarioAtendField.getText());
                    profissionalController.cadastrarProfissional(
                            Integer.parseInt(idProfissionalField.getText()),
                            especialidadeField.getText(),
                            crmEstadoField.getText(),
                            crmNumeroField.getText(),
                            horarioAtendimento,
                            usernameField.getText(),
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
                        idProfissionalField.setText(String.valueOf(profissional.getIdProfissional()));
                        especialidadeField.setText(profissional.getEspecialidade());
                        crmEstadoField.setText(profissional.getCrm_estado());
                        crmNumeroField.setText(profissional.getCrm_numero());
                        horarioAtendField.setText(profissional.getHorarioAtend().toString());
                        usernameField.setText(profissional.getUsername());
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
                    Time horarioAtendimento = Time.valueOf(horarioAtendField.getText());
                    profissionalController.alterarProfissional(
                            Integer.parseInt(idProfissionalField.getText()),
                            especialidadeField.getText(),
                            crmEstadoField.getText(),
                            crmNumeroField.getText(),
                            horarioAtendimento,
                            usernameField.getText(),
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
        idProfissionalField.setText("");
        especialidadeField.setText("");
        crmEstadoField.setText("");
        crmNumeroField.setText("");
        horarioAtendField.setText("");
        usernameField.setText("");
        passwordField.setText("");
    }
}
