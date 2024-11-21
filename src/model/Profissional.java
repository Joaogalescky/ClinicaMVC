package model;

import java.sql.Time;
import dao.ExceptionDAO;
import dao.ProfissionalDAO;

public class Profissional {
	private int codUser;
	private String especialidade;
	private Time horarioAtend;
	private String username;
	private String password;
	
	public Profissional() {
	}
	
	public Profissional(int codUser, String especialidade, Time horarioAtend, String username, String password) {
		this.codUser = codUser;
		this.especialidade = especialidade;
		this.horarioAtend = horarioAtend;
		this.username = username;
		this.password = password;
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

	public void excluirProfissioanl(int codUser) throws ExceptionDAO {
		new ProfissionalDAO().excluirProfissional(codUser);
	}
}
