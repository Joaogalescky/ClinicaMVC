package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	public void cadastrarUsuario(
	//@formatter:off
			String nome, 
			java.sql.Date dataNascimento, 
			String cpf, 
			String rg, 
			String telefone,
			String email, 
			String endereco
	//@formatter:on
	) throws Exception {
		if (
		//@formatter:off
				nome != null && nome.length() > 0 && 
				dataNascimento != null &&
				cpf != null && cpf.length() > 0  && cpf.length() <= 11 && 
				rg != null && rg.length() > 0 && rg.length() <= 10 && 
				telefone != null && telefone.length() > 0 && telefone.length() <= 12 && 
				email != null && email.length() > 0 && 
				endereco != null && endereco.length() > 0
		//@formatter:on
		) {
			Usuario usuario = new Usuario(nome, dataNascimento, cpf, rg, telefone, email, endereco);
			usuario.cadastrarUsuario(usuario);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public Usuario consultarUsuario(int codUser) throws Exception {
		if (codUser > 0) {
			Usuario usuario = new UsuarioDAO().consultarUsuario(codUser);
			return usuario;
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public void alterarUsuario(
	//@formatter:off
			int codUser, 
			String nome, 
			java.sql.Date dataNascimento, 
			String cpf, 
			String rg, 
			String telefone,
			String email, 
			String endereco
	//@formatter:on
	) throws Exception {
		if (
		//@formatter:off
				nome != null && nome.length() > 0 && 
				dataNascimento != null &&
				cpf != null && cpf.length() > 0  && cpf.length() <= 11 && 
				rg != null && rg.length() > 0 && rg.length() <= 10 && 
				telefone != null && telefone.length() > 0 && telefone.length() <= 12 && 
				email != null && email.length() > 0 && 
				endereco != null && endereco.length() > 0	
		//@formatter:on
		) {
			Usuario usuario = new Usuario();
			usuario.setCodUser(codUser);
	        usuario.setDataNascimento(dataNascimento);
	        usuario.setCpf(cpf);
	        usuario.setRg(rg);
	        usuario.setTelefone(telefone);
	        usuario.setEmail(email);
	        usuario.setEndereco(endereco);
			usuario.alterarUsuario(usuario);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public void excluirUsuario(int codUser) throws Exception {
		if (codUser > 0) {
			Usuario usuario = new Usuario();
			usuario.excluirUsuario(codUser);
		} else {
			throw new Exception("ID do usuario é inválido!");
		}
	}
}