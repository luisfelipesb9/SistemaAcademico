package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDao implements Dao<Curso> {
    private Connection conexao;

    public CursoDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    @Override
    public int save(Curso entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO cursos (nome, creditos) VALUES (?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getCreditos());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar Curso: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Curso entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE cursos SET nome = ?, creditos = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getCreditos());
            st.setInt(3, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar Curso: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public int delete(Curso entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String dQuery = "DELETE FROM cursos WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao deletar Curso: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public List<Curso> findAll() throws DAOException {
        List<Curso> cursos = new ArrayList<>();
        try {
            String sQuery = "SELECT * FROM cursos";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cursos.add(new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("creditos")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar todos os cursos: " + ex.getMessage());
        }
        return cursos;
    }

    @Override
    public Curso findOne(Curso entidade) throws DAOException {
        Curso curso = null;
        try {
            String sQuery = "SELECT * FROM cursos WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                curso = new Curso(rs.getInt("id"), rs.getString("nome"), rs.getInt("creditos"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar curso: " + ex.getMessage());
        }
        return curso;
    }

    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM cursos";
        PreparedStatement st = conexao.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
