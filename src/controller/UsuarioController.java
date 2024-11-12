package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {

	public void cadastrarUsuario(String nome, String telefone) throws Exception {
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) {
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

	public void alterarUsuario(int codUser, String nome, String telefone) throws Exception {
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) {
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
