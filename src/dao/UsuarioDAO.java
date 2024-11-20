package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {

	public void cadastrarUsuario(Usuario usuario) throws ExceptionDAO {
		String sql = "INSERT INTO Pessoa (nome, dataNascimento, cpf, rg, telefone, email, endereco) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = new ConexaoBD().getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setDate(2, usuario.getDataNascimento());
			stmt.setString(3, usuario.getCpf());
			stmt.setString(4, usuario.getRg());
			stmt.setString(5, usuario.getTelefone());
			stmt.setString(6, usuario.getEmail());
			stmt.setString(7, usuario.getEndereco());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar usuario: " + e);
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

	public Usuario consultarUsuario(int codUser) throws ExceptionDAO {
		String sql = "SELECT * FROM Pessoa WHERE idPessoa = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, codUser);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setRg(rs.getString("rg"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEmail(rs.getString("email"));
				usuario.setEndereco(rs.getString("endereco"));
				return usuario;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar usuario: " + e);
		}
		return null;
	}

	public void alterarUsuario(Usuario usuario) throws ExceptionDAO {
		String sql = "UPDATE Pessoa SET nome = ?, dataNascimento = ?, cpf = ?, rg = ?, telefone = ?, email = ?, endereco = ? WHERE idPessoa = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setDate(2, usuario.getDataNascimento());
			stmt.setString(3, usuario.getCpf());
			stmt.setString(4, usuario.getRg());
			stmt.setString(5, usuario.getTelefone());
			stmt.setString(6, usuario.getEmail());
			stmt.setString(7, usuario.getEndereco());
			stmt.setInt(8, usuario.getCodUser());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar usuario: " + e);
		}
	}

	public void excluirUsuario(int codUser) throws ExceptionDAO {
		String sql = "DELETE FROM Pessoa WHERE idPessoa = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, codUser);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir usuario: " + e);
		}
	}

	public boolean autenticarUsuario(String username, String password) throws ExceptionDAO, SQLException {
		Connection connection = null;
		PreparedStatement pStatement = null; // SQL Injection
		ResultSet rs = null;

		try {
			connection = new ConexaoBD().getConnection();
			String sql = "SELECT * FROM Usuario WHERE BINARY username = ? AND BINARY password = ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
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