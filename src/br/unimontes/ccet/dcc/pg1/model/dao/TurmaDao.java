package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Turma;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDao implements Dao<Turma> {
    private Connection conexao;

    public TurmaDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    @Override
    public int save(Turma entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO turmas (id_disciplina, id_professor, ano, semestre) VALUES (?,?,?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery, Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, entidade.getIdDisciplina());
            st.setInt(2, entidade.getIdProfessor());
            st.setInt(3, entidade.getAno());
            st.setInt(4, entidade.getSemestre());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar Turma: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Turma entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE turmas SET id_disciplina = ?, id_professor = ?, ano = ?, semestre = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setInt(1, entidade.getIdDisciplina());
            st.setInt(2, entidade.getIdProfessor());
            st.setInt(3, entidade.getAno());
            st.setInt(4, entidade.getSemestre());
            st.setInt(5, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar Turma: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public int delete(Turma entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String dQuery = "DELETE FROM turmas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao deletar Turma: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public List<Turma> findAll() throws DAOException {
        List<Turma> turmas = new ArrayList<>();
        try {
            String sQuery = "SELECT * FROM turmas";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                turmas.add(new Turma(rs.getInt("id"), rs.getInt("id_disciplina"), rs.getInt("id_professor"),
                        rs.getInt("ano"), rs.getInt("semestre")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar todas as turmas: " + ex.getMessage());
        }
        return turmas;
    }

    @Override
    public Turma findOne(Turma entidade) throws DAOException {
        Turma turma = null;
        try {
            String sQuery = "SELECT * FROM turmas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                turma = new Turma(rs.getInt("id"), rs.getInt("id_disciplina"), rs.getInt("id_professor"),
                        rs.getInt("ano"), rs.getInt("semestre"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar turma: " + ex.getMessage());
        }
        return turma;
    }
}
