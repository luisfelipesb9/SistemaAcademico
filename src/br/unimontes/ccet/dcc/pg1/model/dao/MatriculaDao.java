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
            // Tabela renomeada para matriculas_disciplinas
            String iQuery = "INSERT INTO matriculas_disciplinas (id_aluno, id_turma, nota, frequencia) VALUES (?,?,?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, entidade.getIdAluno());
            st.setInt(2, entidade.getIdTurma());
            st.setDouble(3, entidade.getNota());
            st.setInt(4, entidade.getFrequencia());
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
            String uQuery = "UPDATE matriculas_disciplinas SET nota = ?, frequencia = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setDouble(1, entidade.getNota());
            st.setInt(2, entidade.getFrequencia());
            st.setInt(3, entidade.getId());
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
            String dQuery = "DELETE FROM matriculas_disciplinas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getId());
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
            String sQuery = "SELECT * FROM matriculas_disciplinas";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                matriculas.add(new Matricula(rs.getInt("id"), rs.getInt("id_aluno"), rs.getInt("id_turma"),
                        rs.getDouble("nota"), rs.getInt("frequencia")));
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
            String sQuery = "SELECT * FROM matriculas_disciplinas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                matricula = new Matricula(rs.getInt("id"), rs.getInt("id_aluno"), rs.getInt("id_turma"),
                        rs.getDouble("nota"), rs.getInt("frequencia"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar matricula: " + ex.getMessage());
        }
        return matricula;
    }

    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM matriculas_disciplinas";
        PreparedStatement st = conexao.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
