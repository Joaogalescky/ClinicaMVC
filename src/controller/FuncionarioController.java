package controller;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioController {

	public void cadastrarFuncionario(
	//@formatter:off
			int codUser,
			String username, 
			String password
	//@formatter:on
	) throws Exception {
		if (
		//@formatter:off
				codUser != 0 &&
				username != null && username.length() > 0 && username.length() <= 25 &&
				password != null && password.length() > 0 && password.length() <= 20

		//@formatter:on
		) {
			Funcionario funcionario = new Funcionario(codUser, username, password);
			new FuncionarioDAO().cadastrarFuncionario(funcionario);
		} else {
			throw new Exception("Erro ao cadastrar funcionario: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public Funcionario consultarFuncionario(int idFuncionario) throws Exception {
		if (idFuncionario > 0) {
			Funcionario funcionario = new FuncionarioDAO().consultarFuncionario(idFuncionario);
			return funcionario;
		} else {
			throw new Exception("Erro ao consultar funcionario: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public void alterarFuncionario(
	//@formatter:off
			int idFuncionario,
			String username, 
			String password
	//@formatter:on
	) throws Exception {
		if (idFuncionario <= 0) {
			throw new Exception("ID do funcionario é inválido!");
		}
		if (
		//@formatter:off
				username != null && username.length() > 0 && username.length() <= 25 &&
				password != null && password.length() > 0 && password.length() <= 20
		//@formatter:on
		) {
			Funcionario funcionario = new Funcionario(idFuncionario, username, password);
			new FuncionarioDAO().alterarFuncionario(funcionario);
		} else {
			throw new Exception("Erro ao atualizar funcionario: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public void excluirFuncionario(int idFuncionario) throws Exception {
		if (idFuncionario > 0) {
			new FuncionarioDAO().excluirFuncionario(idFuncionario);
		} else {
			throw new Exception("ID do funcionario é inválido!");
		}
	}
}