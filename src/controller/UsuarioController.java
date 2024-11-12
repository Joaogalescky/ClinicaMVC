package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	public void cadastrarUsuario(
			String nome, 
			String dataNascimento, 
			String cpf, 
			String rg, 
			String telefone,
			String email, 
			String endereco
			) throws Exception {
		if (
				nome != null && nome.length() > 0 && 
				dataNascimento != null && dataNascimento.length() > 0 && dataNascimento.length() <= 10 &&
				cpf != null && cpf.length() > 0  && cpf.length() <= 11 && 
				rg != null && rg.length() > 0 && rg.length() <= 10 && 
				telefone != null && telefone.length() > 0 && telefone.length() <= 12 && 
				email != null && email.length() > 0 && 
				endereco != null && endereco.length() > 0
			) {
			Usuario usuario = new Usuario();
			usuario.cadastrarUsuario(usuario);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public Usuario consultarUsuario(String nome) throws Exception {
		if (nome != null && nome.length() > 0) {
			Usuario usuario = new UsuarioDAO().consultarUsuario(nome);
			return usuario;
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}

	public void alterarUsuario(
			int codUser, 
			String nome, 
			String dataNascimento, 
			String cpf, 
			String rg, 
			String telefone,
			String email, 
			String endereco
			) throws Exception {
		if (
				nome != null && nome.length() > 0 && 
				dataNascimento != null && dataNascimento.length() > 0 && dataNascimento.length() <= 10 &&
				cpf != null && cpf.length() > 0  && cpf.length() <= 11 && 
				rg != null && rg.length() > 0 && rg.length() <= 10 && 
				telefone != null && telefone.length() > 0 && telefone.length() <= 12 && 
				email != null && email.length() > 0 && 
				endereco != null && endereco.length() > 0	
			) {
			Usuario usuario = new Usuario();
			usuario.setCodUser(codUser);
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
