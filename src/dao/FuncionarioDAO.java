package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;

public class FuncionarioDAO {

	public void cadastrarFuncionario(Funcionario funcionario) throws ExceptionDAO {
		String sql = "INSERT INTO Funcionario (idPessoa, username, password) VALUES (?,?,?)";
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = new ConexaoBD().getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, funcionario.getCodUser());
			stmt.setString(4, funcionario.getUsername());
			stmt.setString(5, funcionario.getPassword());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar funcionario: " + e);
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

	public Funcionario consultarFuncionario(int idFuncionario) throws ExceptionDAO {
		String sql = "SELECT * FROM Funcionario WHERE idFuncionario = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, idFuncionario);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setCodUser(rs.getInt("codUser"));
				funcionario.setUsername(rs.getString("username"));
				funcionario.setPassword(rs.getString("password"));
				return funcionario;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar funcionario: " + e);
		}
		return null;
	}

	public void alterarFuncionario(Funcionario funcionario) throws ExceptionDAO {
		String sql = "UPDATE Funcionario SET username = ?, password = ? WHERE idFuncionario = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(3, funcionario.getUsername());
			stmt.setString(4, funcionario.getPassword());
			stmt.setInt(5, funcionario.getIdFuncionario());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar funcionario: " + e);
		}
	}

	public void excluirFuncionario(int codUser) throws ExceptionDAO {
		String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, codUser);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir funcionario: " + e);
		}
	}

	public boolean autenticarFuncionario(String username, String password) throws ExceptionDAO, SQLException {
		Connection connection = null;
		PreparedStatement pStatement = null; // SQL Injection
		ResultSet rs = null;

		try {
			connection = new ConexaoBD().getConnection();
			String sql = "SELECT * FROM Funcionario WHERE BINARY username = ? AND BINARY password = ?";
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
