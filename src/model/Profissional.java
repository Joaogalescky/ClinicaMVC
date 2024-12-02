package model;

import java.sql.Date;
import java.sql.Time;

import dao.ExceptionDAO;
import dao.ProfissionalDAO;

public class Profissional extends Usuario {
	private int idProfissional;
	private int idPessoa;
	private String especialidade;
	private String crm_estado;
	private String crm_numero;
	private Time horarioAtend;
	private String username;
	private String password;

	public Profissional() {
		super(); // Chama o construtor da classe Usuario
	}

	public static Profissional criarParaCadastro(int idPessoa, String especialidade, String crm_estado,
			String crm_numero, Time horarioAtend, String username, String password) {
		Profissional profissional = new Profissional();
		profissional.idPessoa = idPessoa;
		profissional.especialidade = especialidade;
		profissional.crm_estado = crm_estado;
		profissional.crm_numero = crm_numero;
		profissional.horarioAtend = horarioAtend;
		profissional.username = username;
		profissional.password = password;
		return profissional;
	}

	public static Profissional criarParaAlteracao(int idProfissional, String nome, Date dataNascimento,
			String cpf, String rg, String telefone, String email, String endereco, String especialidade, String crm_estado,
			String crm_numero, Time horarioAtend, String username, String password) {
		Profissional profissional = new Profissional();
		profissional.idProfissional = idProfissional;
		profissional.especialidade = especialidade;
		profissional.crm_estado = crm_estado;
		profissional.crm_numero = crm_numero;
		profissional.horarioAtend = horarioAtend;
		profissional.username = username;
		profissional.password = password;
		return profissional;
	}

	public Profissional(String especialidade, String crm_estado, String crm_numero, Time horarioAtend, String username,
			String password) {
		this.especialidade = especialidade;
		this.crm_estado = crm_estado;
		this.crm_numero = crm_numero;
		this.horarioAtend = horarioAtend;
		this.username = username;
		this.password = password;
	}

	public Profissional(String nome, java.sql.Date dataNascimento, String cpf, String rg, String telefone, String email,
			String endereco, String especialidade, String crm_estado, String crm_numero, Time horarioAtend,
			String username, String password) {
		super(nome, dataNascimento, cpf, rg, telefone, email, endereco); // Chama o construtor da classe Usuario
		this.especialidade = especialidade;
		this.crm_estado = crm_estado;
		this.crm_numero = crm_numero;
		this.horarioAtend = horarioAtend;
		this.username = username;
		this.password = password;
	}

	public int getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm_estado() {
		return crm_estado;
	}

	public void setCrm_estado(String crm_estado) {
		this.crm_estado = crm_estado;
	}

	public String getCrm_numero() {
		return crm_numero;
	}

	public void setCrm_numero(String crm_numero) {
		this.crm_numero = crm_numero;
	}

	public Time getHorarioAtend() {
		return horarioAtend;
	}

	public void setHorarioAtend(Time horarioAtend) {
		this.horarioAtend = horarioAtend;
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

	public void cadastrarProfissional(Profissional profissional) throws ExceptionDAO {
		new ProfissionalDAO().cadastrarProfissional(profissional);
	}

	public void alterarProfissional(Profissional profissional) throws ExceptionDAO {
		new ProfissionalDAO().alterarProfissional(profissional);
	}

	public void excluirProfissional(int idPessoa) throws ExceptionDAO {
		new ProfissionalDAO().excluirProfissional(idPessoa);
	}
}
