package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Disciplina;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao implements Dao<Disciplina> {
    private Connection conexao;

    public DisciplinaDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    @Override
    public int save(Disciplina entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            String iQuery = "INSERT INTO disciplinas (nome, carga_horaria, id_curso) VALUES (?,?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getCargaHoraria());
            st.setInt(3, entidade.getIdCurso());
            linhasGravadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao salvar Disciplina: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Disciplina entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE disciplinas SET nome = ?, carga_horaria = ?, id_curso = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getCargaHoraria());
            st.setInt(3, entidade.getIdCurso());
            st.setInt(4, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar Disciplina: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public int delete(Disciplina entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String dQuery = "DELETE FROM disciplinas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getId());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao deletar Disciplina: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public List<Disciplina> findAll() throws DAOException {
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            String sQuery = "SELECT * FROM disciplinas";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                disciplinas.add(new Disciplina(rs.getInt("id"), rs.getString("nome"), rs.getInt("carga_horaria"),
                        rs.getInt("id_curso")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar todas as disciplinas: " + ex.getMessage());
        }
        return disciplinas;
    }

    @Override
    public Disciplina findOne(Disciplina entidade) throws DAOException {
        Disciplina disciplina = null;
        try {
            String sQuery = "SELECT * FROM disciplinas WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                disciplina = new Disciplina(rs.getInt("id"), rs.getString("nome"), rs.getInt("carga_horaria"),
                        rs.getInt("id_curso"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar disciplina: " + ex.getMessage());
        }
        return disciplina;
    }
}
