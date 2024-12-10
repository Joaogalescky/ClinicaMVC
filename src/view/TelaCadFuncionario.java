//package view;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//
//import controller.FuncionarioController;
//import model.Funcionario;
//
//public class TelaCadFuncionario extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//
//	private JLabel codUserJLabel;
//	private JLabel usernameJLabel;
//	private JLabel passwordJLabel;
//    
//    private JTextField codUserJTextField;
//    private JTextField usernameJTextField;
//    private JPasswordField passwordField;
//
//    JButton cadastrarBtn;
//    private JButton limparBtn;
//    private JButton consultarBtn;
//    private JButton alterarBtn;
//    private JButton excluirBtn;
//
//    public TelaCadFuncionario() {
//        super("Cadastro de Funcionários");
//
//        codUserJLabel = new JLabel("ID");
//        usernameJLabel = new JLabel("Username");
//        passwordJLabel = new JLabel("Password");
//        
//        codUserJTextField = new JTextField();
//        usernameJTextField = new JTextField();
//        passwordField = new JPasswordField();
//
//        cadastrarBtn = new JButton("Cadastrar");
//        alterarBtn = new JButton("Alterar");
//        limparBtn = new JButton("Limpar");
//        consultarBtn = new JButton("Consultar");
//        excluirBtn = new JButton("Excluir");
//
//        setSize(550, 240); // (largura, altura)
//        setTitle("Cadastro de Funcionários");
//        setVisible(true);
//        setLayout(null);
//        setLocationRelativeTo(null);
//
//        codUserJLabel.setBounds(10, 10, 100, 25); // (x, y, largura, altura)
//        codUserJTextField.setBounds(100, 10, 300, 25);
//        usernameJLabel.setBounds(10, 40, 100, 25);
//        usernameJTextField.setBounds(100, 40, 300, 25);
//        passwordJLabel.setBounds(10, 70, 100, 25); 
//        passwordField.setBounds(100, 70, 300, 25);
//
//        cadastrarBtn.setBounds(10, 130, 100, 25);
//        limparBtn.setBounds(120, 130, 80, 25);
//        consultarBtn.setBounds(210, 130, 100, 25);
//        alterarBtn.setBounds(320, 130, 100, 25);
//        excluirBtn.setBounds(430, 130, 80, 25);
//
//        add(codUserJLabel);
//        add(usernameJLabel);
//        add(passwordJLabel);
//        
//        add(codUserJTextField);
//        add(usernameJTextField);
//        add(passwordField);
//
//        add(cadastrarBtn);
//        add(limparBtn);
//        add(consultarBtn);
//        add(alterarBtn);
//        add(excluirBtn);
//
//        cadastrarBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    FuncionarioController funcionarioController = new FuncionarioController();
//                    funcionarioController.cadastrarFuncionario(
//                        Integer.parseInt(codUserJTextField.getText()),
//                        usernameJTextField.getText(),
//                        new String(passwordField.getPassword())
//                    );
//                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
//                    limparCampos();
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + ex.getMessage());
//                }
//            }
//        });
//
//        consultarBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//					//@formatter:off
//                    FuncionarioController funcionarioController = new FuncionarioController();
//                    int idFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do funcionário:"));
//                    Funcionario funcionario = funcionarioController.consultarFuncionario(idFuncionario);
//
//                    if (funcionario != null) {
//                        codUserJTextField.setText(String.valueOf(funcionario.getIdFuncionario()));
//                        usernameJTextField.setText(funcionario.getUsername());
//                        passwordField.setText(funcionario.getPassword());
//                        alterarBtn.setEnabled(true);
//                        excluirBtn.setEnabled(true);
//    				//@formatter:on
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
//                    }
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao consultar: " + ex.getMessage());
//                }
//            }
//        });
//
//        alterarBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//					//@formatter:off
//                    FuncionarioController funcionarioController = new FuncionarioController();
//                    funcionarioController.alterarFuncionario(
//                        Integer.parseInt(codUserJTextField.getText()),
//                        usernameJTextField.getText(),
//                        new String(passwordField.getPassword())
//                    );
//					//@formatter:on
//                    JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao alterar: " + ex.getMessage());
//                }
//            }
//        });
//
//        excluirBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//					//@formatter:off
//                    FuncionarioController funcionarioController = new FuncionarioController();
//                    int idFuncionario = Integer
//                            .parseInt(JOptionPane.showInputDialog("Informe o código do funcionário a ser excluído:"));
//                    funcionarioController.excluirFuncionario(idFuncionario);
//					//@formatter:on
//                    JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
//                    limparCampos();
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
//                }
//            }
//        });
//
//        limparBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                limparCampos();
//            }
//        });
//    }
//
//    private void limparCampos() {
//        codUserJTextField.setText("");
//        usernameJTextField.setText("");
//        passwordField.setText("");
//    }
//}