package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.util.List;
import java.sql.*;

public class AlunoDao implements Dao<Aluno> {
    private Connection conexao;

    public AlunoDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    @Override
    public int save(Aluno entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            String cpf = entidade.getCpf() != null ? entidade.getCpf().trim() : "";

            Aluno searchObj = new Aluno(cpf, "", 0);

            if (findOne(searchObj) != null) {
                return update(entidade);
            }

            String iQuery = "INSERT INTO alunos (cpf, nome, ano_nascimento) VALUES (?,?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery);
            st.setString(1, cpf);
            st.setString(2, entidade.getNome());
            st.setInt(3, entidade.getAnoNascimento());
            linhasGravadas = st.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062 || ex.getMessage().contains("Duplicate entry")) {
                return update(entidade);
            }
            throw new DAOException("Erro ao salvar Aluno: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Aluno entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE alunos SET nome = ?, ano_nascimento = ? WHERE cpf = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getAnoNascimento());

            String cpf = entidade.getCpf() != null ? entidade.getCpf().trim() : "";
            st.setString(3, cpf);

            linhasAfetadas = st.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("Erro ao tentar atualizar entidade Aluno. SQLSTATE: " + ex.getSQLState());
        }
        return linhasAfetadas;
    }

    @Override
    public int delete(Aluno entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String dQuery = "DELETE FROM alunos WHERE cpf = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setString(1, entidade.getCpf());
            linhasAfetadas = st.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao deletar Aluno: " + ex.getMessage());
        }
        return linhasAfetadas;
    }

    @Override
    public List<Aluno> findAll() throws DAOException {
        List<Aluno> alunos = new java.util.ArrayList<>();
        try {
            String sQuery = "SELECT * FROM alunos";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                alunos.add(new Aluno(rs.getString("cpf"), rs.getString("nome"), rs.getInt("ano_nascimento")));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar todos os alunos: " + ex.getMessage());
        }
        return alunos;
    }

    @Override
    public Aluno findOne(Aluno entidade) throws DAOException {
        Aluno aluno = null;
        try {
            String sQuery = "SELECT * FROM alunos WHERE cpf = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            String cpf = entidade.getCpf() != null ? entidade.getCpf().trim() : "";
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                aluno = new Aluno(rs.getString("cpf"), rs.getString("nome"), rs.getInt("ano_nascimento"));
            }
        } catch (SQLException ex) {
            throw new DAOException("Erro ao buscar aluno: " + ex.getMessage());
        }
        return aluno;
    }

    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM alunos";
        PreparedStatement st = conexao.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
