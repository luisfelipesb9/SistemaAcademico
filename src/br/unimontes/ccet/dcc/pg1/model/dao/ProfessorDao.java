package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Professor;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements Dao<Professor> {
    private Connection conexao;

    public ProfessorDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    @Override
    public int save(Professor entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO professores (nome, titulacao) VALUES (?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, entidade.getNome());
            st.setString(2, entidade.getTitulacao());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar Professor: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Professor entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE professores SET nome = ?, titulacao = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setString(1, entidade.getNome());
            st.setString(2, entidade.getTitulacao());
            st.setInt(3, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar Professor: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public int delete(Professor entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String dQuery = "DELETE FROM professores WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao deletar Professor: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public List<Professor> findAll() throws DAOException {
        List<Professor> professores = new ArrayList<>();
        try {
            String sQuery = "SELECT * FROM professores";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                professores.add(new Professor(rs.getInt("id"), rs.getString("nome"), rs.getString("titulacao")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar todos os professores: " + ex.getMessage());
        }
        return professores;
    }

    @Override
    public Professor findOne(Professor entidade) throws DAOException {
        Professor professor = null;
        try {
            String sQuery = "SELECT * FROM professores WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                professor = new Professor(rs.getInt("id"), rs.getString("nome"), rs.getString("titulacao"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar professor: " + ex.getMessage());
        }
        return professor;
    }
}
