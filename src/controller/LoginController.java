package controller;

import java.sql.SQLException;

import dao.ExceptionDAO;
import dao.FuncionarioDAO;
import dao.ProfissionalDAO;

public class LoginController {
	private ProfissionalDAO profissionalDAO;
	private FuncionarioDAO funcionarioDAO;

	public LoginController() {
		this.profissionalDAO = new ProfissionalDAO();
		this.funcionarioDAO = new FuncionarioDAO();
	}

	public boolean autenticar(String username, String password) throws SQLException {
		try {
			if (profissionalDAO.autenticarProfissional(username, password)) {
				return true;
			}
			if (funcionarioDAO.autenticarFuncionario(username, password)) {
				return true;
			}
			return false;
		} catch (ExceptionDAO e) {
			System.out.println("Erro ao autenticar usuário: " + e.getMessage());
			return false;
		}
	}
}