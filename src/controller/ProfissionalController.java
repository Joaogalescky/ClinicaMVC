package controller;

import java.sql.Time;

import dao.ProfissionalDAO;
import model.Profissional;

public class ProfissionalController {

	public void cadastrarProfissional(
	//@formatter:off
			int idPessoa,
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
				idPessoa != 0 &&
				especialidade != null && especialidade.length() > 0 &&
				crm_estado != null && crm_estado.length() == 2 &&
				crm_numero != null &&  crm_numero.length() == 6 &&
				horarioAtend != null &&
				username != null && username.length() > 0 && username.length() <= 25 &&
				password != null && password.length() > 0 && password.length() <= 20
			//@formatter:on
		) {
			Profissional profissional = Profissional.criarParaCadastro(idPessoa, especialidade, crm_estado, crm_numero, horarioAtend, username, password);
			new ProfissionalDAO().cadastrarProfissional(profissional);
		} else {
			throw new Exception("Erro ao cadastrar profissional: todos os campos devem ser preenchidos corretamente!");
		}
	}
	
    public void cadastrarProfissionalComUsuario(
    //@formatter:off
            String nome,
            java.sql.Date dataNascimento,
            String cpf,
            String rg,
            String telefone,
            String email,
            String endereco,
            String especialidade,
            String crm_estado,
            String crm_numero,
            Time horarioAtend,
            String username,
            String password
        //@formatter:on
        ) throws Exception {
			//@formatter:off
            UsuarioController usuarioController = new UsuarioController();
            int idPessoa = usuarioController.cadastrarUsuario(
                nome,
                dataNascimento,
                cpf,
                rg,
                telefone,
                email,
                endereco
            );
            this.cadastrarProfissional(
                idPessoa,
                especialidade,
                crm_estado,
                crm_numero,
                horarioAtend,
                username,
                password
            );
			//@formatter:on
        }

	public Profissional consultarProfissionalComUsuario(int idProfissional) throws Exception {
		if (idProfissional > 0) {
			Profissional profissional = new ProfissionalDAO().consultarProfissionalComUsuario(idProfissional);
	        if (profissional == null) {
	            throw new Exception("Profissional não encontrado!");
	        }
			return profissional;
		} else {
			throw new Exception("Erro ao consultar profissional: todos os campos devem ser preenchidos corretamente!");
		}
	}

	public void alterarProfissionalComUsuario(
	//@formatter:off
			int idProfissional,
			String nome,
		    java.sql.Date dataNascimento,
		    String cpf,
		    String rg,
		    String telefone,
		    String email,
		    String endereco,
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
		    nome != null && nome.length() > 0 &&
		    dataNascimento != null &&
		    cpf != null && cpf.length() > 0 &&
		    rg != null && rg.length() > 0 &&
		    telefone != null && telefone.length() > 0 &&
		    email != null && email.length() > 0 &&
		    endereco != null && endereco.length() > 0 &&
			especialidade != null && especialidade.length() > 0 &&
			crm_estado != null && crm_estado.length() == 2 &&
			crm_numero != null &&  crm_numero.length() == 6 &&
			horarioAtend != null &&
			username != null && username.length() > 0 && username.length() <= 25 &&
			password != null && password.length() > 0 && password.length() <= 20
		//@formatter:on
		) {
			//@formatter:off
			Profissional profissional = Profissional.criarParaAlteracao(
					idProfissional, 
					nome, 
					dataNascimento, 
					cpf, 
					rg, 
					telefone, 
					email, 
					endereco, 
					especialidade, 
					crm_estado, 
					crm_numero, 
					horarioAtend,
					username, 
					password
			);
			//@formatter:on
			new ProfissionalDAO().alterarProfissionalComUsuario(profissional);
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