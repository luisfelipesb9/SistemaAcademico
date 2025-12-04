package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.util.List;
import java.util.Random;
import java.sql.*;

public class AlunoDao implements Dao<Aluno> {
    private Connection conexao;
    private static final Random random = new Random();

    public AlunoDao() throws SQLException {
        conexao = DB.getInstancia().getConnection();
    }

    /**
     * Gera um número de matrícula único no formato 1000XXXXX (1000 + 5 dígitos
     * aleatórios)
     */
    private int gerarMatricula() throws SQLException {
        int matricula;
        int tentativas = 0;
        do {
            // Gera número de 10000000 a 10099999 (formato 1000XXXXX)
            matricula = 100000000 + random.nextInt(100000);
            tentativas++;
            if (tentativas > 100) {
                throw new SQLException("Não foi possível gerar uma matrícula única após 100 tentativas");
            }
        } while (matriculaExiste(matricula));
        return matricula;
    }

    private boolean matriculaExiste(int matricula) throws SQLException {
        String query = "SELECT COUNT(*) FROM alunos WHERE id = ?";
        PreparedStatement st = conexao.prepareStatement(query);
        st.setInt(1, matricula);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        return false;
    }

    @Override
    public int save(Aluno entidade) throws DAOException {
        int linhasGravadas = 0;
        try {
            // Gera matrícula no formato 1000XXXXX
            int matricula = gerarMatricula();
            entidade.setId(matricula);

            String iQuery = "INSERT INTO alunos (id, cpf, nome, ano_nascimento, id_curso) VALUES (?,?,?,?,?)";
            PreparedStatement st = conexao.prepareStatement(iQuery);
            st.setInt(1, matricula);
            st.setString(2, entidade.getCpf());
            st.setString(3, entidade.getNome());
            st.setInt(4, entidade.getAnoNascimento());
            st.setInt(5, entidade.getIdCurso());

            linhasGravadas = st.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062 || ex.getMessage().contains("Duplicate entry")) {
                throw new DAOException("Erro: Já existe um aluno com este CPF.");
            }
            throw new DAOException("Erro ao salvar Aluno: " + ex.getMessage());
        }
        return linhasGravadas;
    }

    @Override
    public int update(Aluno entidade) throws DAOException {
        int linhasAfetadas = 0;
        try {
            String uQuery = "UPDATE alunos SET nome = ?, ano_nascimento = ?, id_curso = ?, cpf = ? WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(uQuery);
            st.setString(1, entidade.getNome());
            st.setInt(2, entidade.getAnoNascimento());
            st.setInt(3, entidade.getIdCurso());
            st.setString(4, entidade.getCpf());
            st.setInt(5, entidade.getId());

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
            String dQuery = "DELETE FROM alunos WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(dQuery);
            st.setInt(1, entidade.getId());
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
                alunos.add(new Aluno(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getInt("ano_nascimento"), rs.getInt("id_curso")));
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
            String sQuery = "SELECT * FROM alunos WHERE id = ?";
            PreparedStatement st = conexao.prepareStatement(sQuery);
            st.setInt(1, entidade.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                aluno = new Aluno(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"),
                        rs.getInt("ano_nascimento"), rs.getInt("id_curso"));
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
