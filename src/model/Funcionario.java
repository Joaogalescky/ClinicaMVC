package model;

import dao.ExceptionDAO;
import dao.FuncionarioDAO;

public class Funcionario {
	private int idFuncionario;
	private int codUser;
	private String username;
	private String password;

	public Funcionario() {
	}

	public Funcionario(int codUser, String username, String password) {
		this.codUser = codUser;
		this.username = username;
		this.password = password;
	}

	public Funcionario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getCodUser() {
		return codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void cadastrarFuncionario(Funcionario funcionario) throws ExceptionDAO {
		new FuncionarioDAO().cadastrarFuncionario(funcionario);
	}

	public void alterarFuncionario(Funcionario funcionario) throws ExceptionDAO {
		new FuncionarioDAO().alterarFuncionario(funcionario);
	}

	public void excluirFuncionario(int codUser) throws ExceptionDAO {
		new FuncionarioDAO().excluirFuncionario(codUser);
	}
}
