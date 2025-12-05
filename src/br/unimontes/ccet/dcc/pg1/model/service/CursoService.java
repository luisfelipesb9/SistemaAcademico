package br.unimontes.ccet.dcc.pg1.model.service;

import br.unimontes.ccet.dcc.pg1.model.dao.AlunoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.CursoDao;
import br.unimontes.ccet.dcc.pg1.model.dao.ProfessorDao;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Aluno;
import br.unimontes.ccet.dcc.pg1.model.dao.entity.Curso;
import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.sql.SQLException;
import java.util.List;

public class CursoService {

    private CursoDao cursoDao;
    private AlunoDao alunoDao;
    private ProfessorDao professorDao;

    public CursoService() throws SQLException {
        this.cursoDao = new CursoDao();
        this.alunoDao = new AlunoDao();
        this.professorDao = new ProfessorDao();
    }

    public boolean salvarCurso(Curso curso) throws DAOException {
        if (curso.getId() > 0) {
            return cursoDao.update(curso) > 0;
        } else {
            return cursoDao.save(curso) > 0;
        }
    }

    public List<Curso> listarTodos() throws DAOException {
        return cursoDao.findAll();
    }

    public Curso buscarPorId(int id) throws DAOException {
        Curso c = new Curso(id, "Dummy", 0);
        return cursoDao.findOne(c);
    }

    /**
     * Exclui um curso se não houver alunos vinculados.
     * Remove também o coordenador associado.
     * 
     * @throws DAOException se houver alunos no curso
     */
    public boolean excluir(int id) throws DAOException {
        List<Aluno> alunos = alunoDao.findAll();
        long alunosNoCurso = alunos.stream()
                .filter(a -> a.getIdCurso() == id)
                .count();

        if (alunosNoCurso > 0) {
            throw new DAOException("Não é possível excluir o curso pois existem "
                    + alunosNoCurso + " aluno(s) matriculado(s). "
                    + "Remova os alunos primeiro.");
        }

        professorDao.deleteByIdCurso(id);

        Curso c = new Curso(id, "Dummy", 0);
        return cursoDao.delete(c) > 0;
    }

    public int count() throws SQLException {
        return cursoDao.count();
    }
}
