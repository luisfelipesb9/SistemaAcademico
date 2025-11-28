package br.unimontes.ccet.dcc.pg1.controller;

import br.unimontes.ccet.dcc.pg1.model.dao.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoletimController {

    public List<Object[]> buscarBoletim(int idAluno) throws SQLException {
        List<Object[]> dados = new ArrayList<>();
        Connection con = DB.getInstancia().getConnection();

        // Join entre Matricula, Turma e Disciplina para pegar os nomes
        String sql = "SELECT d.nome, m.nota, m.frequencia " +
                "FROM matriculas_disciplinas m " +
                "JOIN turmas t ON m.id_turma = t.id " +
                "JOIN disciplinas d ON t.id_disciplina = d.id " +
                "WHERE m.id_aluno = ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, idAluno);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            String disciplina = rs.getString("nome");
            double nota = rs.getDouble("nota");
            int frequencia = rs.getInt("frequencia");

            String situacao;
            if (nota >= 60 && frequencia >= 75) {
                situacao = "Aprovado";
            } else if (frequencia < 75) {
                situacao = "Reprovado por Faltas";
            } else {
                situacao = "Reprovado por Nota";
            }

            dados.add(new Object[] { disciplina, nota, frequencia, situacao });
        }

        return dados;
    }
}
