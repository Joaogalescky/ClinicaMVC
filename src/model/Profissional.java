package model;

import java.sql.Time;

import dao.ExceptionDAO;
import dao.ProfissionalDAO;

public class Profissional {
	private int idProfissional;
	private int codUser;
	private String especialidade;
	private String crm_estado;
	private String crm_numero;
	private Time horarioAtend;
	private String username;
	private String password;

	public Profissional() {
	}

	// Cadastro
	public Profissional(int codUser, String especialidade, String crm_estado, String crm_numero, Time horarioAtend, String username, String password) {
		this.codUser = codUser;
		this.especialidade = especialidade;
		this.crm_estado = crm_estado;
		this.crm_numero = crm_numero;
		this.horarioAtend = horarioAtend;
		this.username = username;
		this.password = password;
	}

	// Consulta e Alterar
	public Profissional(String especialidade, String crm_estado, String crm_numero, Time horarioAtend, String username, String password) {
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

	public int getCodUser() {
		return codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
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

	public void excluirProfissional(int codUser) throws ExceptionDAO {
		new ProfissionalDAO().excluirProfissional(codUser);
	}
}
