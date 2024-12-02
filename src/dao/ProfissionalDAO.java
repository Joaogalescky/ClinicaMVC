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
			stmt.setInt(1, profissional.getIdPessoa());
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

	public Profissional consultarProfissionalComUsuario(int idProfissional) throws ExceptionDAO {
		String sql = "SELECT Profissional.*, Pessoa.* FROM Profissional "
				+ "JOIN Pessoa ON Profissional.idPessoa = Pessoa.idPessoa "
				+ "WHERE Profissional.idProfissional = ?";
		try (Connection connection = new ConexaoBD().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, idProfissional);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Profissional profissional = new Profissional();
				// Profissional
				profissional.setIdProfissional(rs.getInt("idProfissional"));
				profissional.setEspecialidade(rs.getString("especialidade"));
				profissional.setCrm_estado(rs.getString("crm_estado"));
				profissional.setCrm_numero(rs.getString("crm_numero"));
				profissional.setHorarioAtend(rs.getTime("horarioAtend"));
				profissional.setUsername(rs.getString("username"));
				profissional.setPassword(rs.getString("password"));
				// Pessoa
	            profissional.setIdPessoa(rs.getInt("idPessoa"));
	            profissional.setNome(rs.getString("nome"));
	            profissional.setDataNascimento(rs.getDate("dataNascimento"));
	            profissional.setCpf(rs.getString("cpf"));
	            profissional.setRg(rs.getString("rg"));
	            profissional.setTelefone(rs.getString("telefone"));
	            profissional.setEmail(rs.getString("email"));
	            profissional.setEndereco(rs.getString("endereco"));
				return profissional;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar profissional: " + e);
		}
		return null;
	}
	
	public void alterarProfissional(Profissional profissional) throws ExceptionDAO {
		String sqlProfissional = "UPDATE Profissional SET especialidade = ?, crm_estado = ?, crm_numero = ?, horarioAtend = ?, username = ?, password = ? WHERE idProfissional = ?";
	    try (Connection connection = new ConexaoBD().getConnection()) {
	        // Desabilitar auto-commit para realizar as alterações juntas
	        connection.setAutoCommit(false);

	        try (PreparedStatement stmtProf = connection.prepareStatement(sqlProfissional)){
	            stmtProf.setString(1, profissional.getEspecialidade());
	            stmtProf.setString(2, profissional.getCrm_estado());
	            stmtProf.setString(3, profissional.getCrm_numero());
	            stmtProf.setTime(4, profissional.getHorarioAtend());
	            stmtProf.setString(5, profissional.getUsername());
	            stmtProf.setString(6, profissional.getPassword());
	            stmtProf.setInt(7, profissional.getIdProfissional());
	            stmtProf.executeUpdate();
	            connection.commit();
	        } catch (SQLException e) {
	            connection.rollback(); // Reverter alterações em caso de erro
	            throw new ExceptionDAO("Erro ao alterar profissional completo: " + e.getMessage());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new ExceptionDAO("Erro ao alterar profissional completo: " + e.getMessage());
	    }
	}

	public void alterarProfissionalComUsuario(Profissional profissional) throws ExceptionDAO {
		String sqlProfissional = "UPDATE Profissional SET especialidade = ?, crm_estado = ?, crm_numero = ?, horarioAtend = ?, username = ?, password = ? WHERE idProfissional = ?";
		String sqlPessoa = "UPDATE Pessoa SET nome = ?, dataNascimento = ?, cpf = ?, rg = ?, telefone = ?, email = ?, endereco = ? WHERE idPessoa = ?";
	    try (Connection connection = new ConexaoBD().getConnection()) {
	        // Desabilitar auto-commit para realizar as alterações juntas
	        connection.setAutoCommit(false);

	        try (PreparedStatement stmtProf = connection.prepareStatement(sqlProfissional);
	             PreparedStatement stmtPessoa = connection.prepareStatement(sqlPessoa)) {

	            // Profissional
	            stmtProf.setString(1, profissional.getEspecialidade());
	            stmtProf.setString(2, profissional.getCrm_estado());
	            stmtProf.setString(3, profissional.getCrm_numero());
	            stmtProf.setTime(4, profissional.getHorarioAtend());
	            stmtProf.setString(5, profissional.getUsername());
	            stmtProf.setString(6, profissional.getPassword());
	            stmtProf.setInt(7, profissional.getIdProfissional());
	            stmtProf.executeUpdate();

	            // Pessoa
	            stmtPessoa.setString(1, profissional.getNome());
	            stmtPessoa.setDate(2, profissional.getDataNascimento());
	            stmtPessoa.setString(3, profissional.getCpf());
	            stmtPessoa.setString(4, profissional.getRg());
	            stmtPessoa.setString(5, profissional.getTelefone());
	            stmtPessoa.setString(6, profissional.getEmail());
	            stmtPessoa.setString(7, profissional.getEndereco());
	            stmtPessoa.setInt(8, profissional.getIdPessoa());
	            stmtPessoa.executeUpdate();

	            // Confirmar transação
	            connection.commit();
	        } catch (SQLException e) {
	            connection.rollback(); // Reverter alterações em caso de erro
	            throw new ExceptionDAO("Erro ao alterar profissional completo: " + e.getMessage());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new ExceptionDAO("Erro ao alterar profissional completo: " + e.getMessage());
	    }
	}

	public void excluirProfissional(int idProfissional) throws ExceptionDAO {
        String sqlExcluirProfissional = "DELETE FROM Profissional WHERE idProfissional = ?";
        String sqlExcluirPessoa = "DELETE FROM Pessoa WHERE idPessoa = ?";
        
        try (Connection connection = new ConexaoBD().getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement stmtProf = connection.prepareStatement(sqlExcluirProfissional);
                 PreparedStatement stmtPessoa = connection.prepareStatement(sqlExcluirPessoa)) {

                // Exclui da tabela Profissional
                stmtProf.setInt(1, idProfissional);
                stmtProf.executeUpdate();

                // Exclui da tabela Pessoa
                stmtPessoa.setInt(1, idProfissional);  // idPessoa é o mesmo que idProfissional
                stmtPessoa.executeUpdate();

                // Commit das transações
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();  // Reverte as alterações em caso de erro
                throw new ExceptionDAO("Erro ao excluir profissional: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir profissional: " + e.getMessage());
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