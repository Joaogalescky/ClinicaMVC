package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Profissional;

public class ProfissionalDAO {

	public void cadastrarProfissional(Profissional profissional) throws ExceptionDAO {
		String sql = "INSERT INTO Profissional (idPessoa, especialidade, crm_estado, crm_numero, horarioAtend, username, password) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = new ConexaoBD().getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, profissional.getCodUser());
			stmt.setString(2, profissional.getEspecialidade());
			stmt.setString(3, profissional.getCrm_estado());
			stmt.setString(4, profissional.getCrm_numero());
			stmt.setTime(5, profissional.getHorarioAtend());
			stmt.setString(6, profissional.getUsername());
			stmt.setString(7, profissional.getPassword());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar profissional: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Profissional consultarProfissional(int idProfissional) throws ExceptionDAO {
		String sql = "SELECT * FROM Profissional WHERE idProfissional = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, idProfissional);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Profissional profissional = new Profissional();
				profissional.setIdProfissional(rs.getInt("idProfissional"));
				profissional.setEspecialidade(rs.getString("especialidade"));
				profissional.setCrm_estado(rs.getString("crm_estado"));
				profissional.setCrm_numero(rs.getString("crm_numero"));
				profissional.setHorarioAtend(rs.getTime("horarioAtend"));
				profissional.setUsername(rs.getString("username"));
				profissional.setPassword(rs.getString("password"));
				return profissional;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar profissional: " + e);
		}
		return null;
	}

	public void alterarProfissional(Profissional profissional) throws ExceptionDAO {
		String sql = "UPDATE Profissional SET especialidade = ?, crm_estado = ?, crm_numero = ?, horarioAtend = ?, username = ?, password = ? WHERE idProfissional = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, profissional.getEspecialidade());
			stmt.setString(2, profissional.getCrm_estado());
			stmt.setString(3, profissional.getCrm_numero());
			stmt.setTime(4, profissional.getHorarioAtend());
			stmt.setString(5, profissional.getUsername());
			stmt.setString(6, profissional.getPassword());
			stmt.setInt(7, profissional.getIdProfissional());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar profissional: " + e);
		}
	}

	public void excluirProfissional(int idProfissional) throws ExceptionDAO {
		String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, idProfissional);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir profissional: " + e);
		}
	}

	public boolean autenticarProfissional(String username, String password) throws ExceptionDAO, SQLException {
		Connection connection = null;
		PreparedStatement pStatement = null; // SQL Injection
		ResultSet rs = null;

		try {
			connection = new ConexaoBD().getConnection();
			String sql = "SELECT * FROM Profissional WHERE BINARY username = ? AND BINARY password = ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, password); // Fazer o hash da senha
			rs = pStatement.executeQuery();

			return rs.next(); // Retorna true se encontrar o usuário
		} catch (SQLException e) {
			throw new ExceptionDAO("Erro ao autenticar usuário: " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pStatement != null)
				pStatement.close();
			if (connection != null)
				connection.close();
		}
	}
}