package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Matricula;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDao implements Dao<Matricula> {
    private Connection conexao;

    public MatriculaDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    @Override
    public int save(Matricula entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO matriculas (id_aluno, id_curso) VALUES (?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, entidade.getIdAluno());
            st.setInt(2, entidade.getIdCurso());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar Matricula: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Matricula entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE matriculas SET id_curso = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setInt(1, entidade.getIdCurso());
            st.setInt(2, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar Matricula: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public int delete(Matricula entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String dQuery = "DELETE FROM matriculas WHERE id_aluno = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getIdAluno());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao deletar Matricula: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public List<Matricula> findAll() throws DAOException {
        List<Matricula> matriculas = new ArrayList<>();
        try {
            String sQuery = "SELECT * FROM matriculas";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                matriculas.add(new Matricula(rs.getInt("id"), rs.getInt("id_aluno"), rs.getInt("id_curso")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar todas as matriculas: " + ex.getMessage());
        }
        return matriculas;
    }

    @Override
    public Matricula findOne(Matricula entidade) throws DAOException {
        Matricula matricula = null;
        try {
            String sQuery = "SELECT * FROM matriculas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                matricula = new Matricula(rs.getInt("id"), rs.getInt("id_aluno"), rs.getInt("id_curso"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar matricula: " + ex.getMessage());
        }
        return matricula;
    }

    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM matriculas";
        PreparedStatement st = conexao.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
