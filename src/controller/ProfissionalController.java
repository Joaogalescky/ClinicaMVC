package controller;

import java.sql.Time;

import dao.ProfissionalDAO;
import model.Profissional;

public class ProfissionalController {

	public void cadastrarProfissional(
	//@formatter:off
			int codUser,
			String especialidade,
			String crm_estado,
			String crm_numero,
			Time horarioAtend,
			String username, 
			String password
	//@formatter:on
	) throws Exception {
		if (
			//@formatter:off
				codUser != 0 &&
				especialidade != null && especialidade.length() > 0 &&
				crm_estado != null && crm_estado.length() == 2 &&
				crm_numero != null &&  crm_numero.length() == 6 &&
				horarioAtend != null &&
				username != null && username.length() > 0 && username.length() <= 25 &&
				password != null && password.length() > 0 && password.length() <= 20
			//@formatter:on
		) {
			Profissional profissional = new Profissional(codUser, especialidade, crm_estado, crm_numero, horarioAtend, username, password);
			new ProfissionalDAO().cadastrarProfissional(profissional);
		} else {
			throw new Exception("Erro ao cadastrar profissional: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public Profissional consultarProfissional(int idProfissional) throws Exception {
		if (idProfissional > 0) {
			Profissional profissional = new ProfissionalDAO().consultarProfissional(idProfissional);
			return profissional;
		} else {
			throw new Exception("Erro ao consultar profissional: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public void alterarProfissional(
	//@formatter:off
			int idProfissional,
			String especialidade, 
			String crm_estado,
			String crm_numero,
			Time horarioAtend,
			String username, 
			String password
	//@formatter:on
	) throws Exception {
		if (idProfissional <= 0) {
			throw new Exception("ID do profissional é inválido!");
		}
		if (
		//@formatter:off
			especialidade != null && especialidade.length() > 0 &&
			crm_estado != null && crm_estado.length() == 2 &&
			crm_numero != null &&  crm_numero.length() == 6 &&
			horarioAtend != null &&
			username != null && username.length() > 0 && username.length() <= 25 &&
			password != null && password.length() > 0 && password.length() <= 20
		//@formatter:on
		) {
			Profissional profissional = new Profissional(especialidade, crm_estado, crm_numero, horarioAtend, username, password);
			new ProfissionalDAO().alterarProfissional(profissional);
		} else {
			throw new Exception("Erro ao atualizar profissional: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public void excluirProfissional(int idProfissional) throws Exception {
		if (idProfissional > 0) {
			new ProfissionalDAO().excluirProfissional(idProfissional);
		} else {
			throw new Exception("ID do profissional é inválido!");
		}
	}
}