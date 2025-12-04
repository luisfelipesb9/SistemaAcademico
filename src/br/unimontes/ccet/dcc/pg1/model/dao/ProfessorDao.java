package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.*;

/**
 * DAO para operações com a tabela de Professores.
 * Inclui métodos para gerenciar coordenadores de cursos.
 */
public class ProfessorDao {
    private Connection conexao;

    public ProfessorDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    /**
     * Busca o primeiro professor (coordenador) de um curso específico.
     * Retorna null se não houver professor vinculado ao curso.
     */
    public Professor buscarCoordenadorPorCurso(int idCurso) throws DAOException {
        Professor professor = null;
        try {
            String query = "SELECT * FROM professores WHERE id_curso = ? LIMIT 1";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setInt(1, idCurso);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                professor = new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("titulacao"),
                        rs.getInt("id_curso"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar coordenador do curso: " + ex.getMessage());
        }
        return professor;
    }

    /**
     * Salva um novo professor/coordenador.
     */
    public int save(Professor professor) throws DAOException {
        int linhasGravadas = 0;
        try {
            String query = "INSERT INTO professores (nome, titulacao, id_curso) VALUES (?, ?, ?)";
            PreparedStatement st = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, professor.getNome());
            st.setString(2, professor.getTitulacao());
            st.setInt(3, professor.getIdCurso());
            linhasGravadas = st.executeUpdate();

            if (linhasGravadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    professor.setId(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar professor: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    /**
     * Atualiza um professor existente.
     */
    public int update(Professor professor) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String query = "UPDATE professores SET nome = ?, titulacao = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setString(1, professor.getNome());
            st.setString(2, professor.getTitulacao());
            st.setInt(3, professor.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar professor: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    /**
     * Remove o professor/coordenador de um curso específico.
     */
    public int deleteByIdCurso(int idCurso) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String query = "DELETE FROM professores WHERE id_curso = ?";
            PreparedStatement st = conexao.prepareStatement(query);
            st.setInt(1, idCurso);
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao remover coordenador: " + ex.getMessage());
        }
        return linhasAfetadas;
    }
}
