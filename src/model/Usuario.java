package model;

import dao.ExceptionDAO;
import dao.UsuarioDAO;

public class Usuario {
	private int codUser;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String telefone;
	private String email;
	private String endereco;

	public Usuario() {
	}

	public Usuario(String nome, String dataNascimento, String cpf, String rg, String telefone, String email,
			String endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public int getCodUser() {
		return codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void cadastrarUsuario(Usuario usuario) throws ExceptionDAO {
		new UsuarioDAO().cadastrarUsuario(usuario);
	}

	public void alterarUsuario(Usuario usuario) throws ExceptionDAO {
		new UsuarioDAO().alterarUsuario(usuario);
	}

	public void excluirUsuario(int codUser) throws ExceptionDAO {
		new UsuarioDAO().excluirUsuario(codUser);
	}
}