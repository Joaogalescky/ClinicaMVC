package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {
	private Connection connection;

	public ProntuarioDAO(Connection connection) {
		this.connection = connection;
	}

	// Retorna os pacientes atendidos por um profissional
	public List<String[]> getPacientesPorProfissional(String profissional) throws SQLException {
		List<String[]> resultados = new ArrayList<>();
		String sql = """
				SELECT p.nome AS paciente, a.dataHoraAtendimento, pr.especialidade
				FROM Atendimento at
				JOIN Agendamento ag ON at.idAgendamento = ag.idAgendamento
				JOIN Paciente pac ON ag.idPaciente = pac.idPaciente
				JOIN Pessoa p ON pac.idPessoa = p.idPessoa
				JOIN Profissional prof ON ag.idProfissional = prof.idProfissional
				JOIN Pessoa pr ON prof.idPessoa = pr.idPessoa
				WHERE pr.nome = ?
				""";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, profissional);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultados.add(new String[] { rs.getString("paciente"), rs.getString("dataHoraAtendimento"),
						rs.getString("especialidade") });
			}
		}
		return resultados;
	}

	// Retorna os profissionais que atenderam um paciente
	public List<String[]> getProfissionaisPorPaciente(String paciente) throws SQLException {
		List<String[]> resultados = new ArrayList<>();
		String sql = """
				SELECT pr.nome AS profissional, at.dataHoraAtendimento, prf.especialidade
				FROM Atendimento at
				JOIN Agendamento ag ON at.idAgendamento = ag.idAgendamento
				JOIN Profissional prof ON ag.idProfissional = prof.idProfissional
				JOIN Pessoa pr ON prof.idPessoa = pr.idPessoa
				JOIN Paciente pac ON ag.idPaciente = pac.idPaciente
				JOIN Pessoa p ON pac.idPessoa = p.idPessoa
				WHERE p.nome = ?
				""";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, paciente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				resultados.add(new String[] { rs.getString("profissional"), rs.getString("dataHoraAtendimento"),
						rs.getString("especialidade") });
			}
		}
		return resultados;
	}
}
