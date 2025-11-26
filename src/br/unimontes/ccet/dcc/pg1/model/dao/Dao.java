package br.unimontes.ccet.dcc.pg1.model.dao;

import br.unimontes.ccet.dcc.pg1.model.dao.exception.DAOException;
import java.util.List;

public interface Dao<T> {
    int save(T entidade) throws DAOException;

    int update(T entidade) throws DAOException;

    int delete(T entidade) throws DAOException;

    List<T> findAll() throws DAOException;

    T findOne(T entidade) throws DAOException;
}
