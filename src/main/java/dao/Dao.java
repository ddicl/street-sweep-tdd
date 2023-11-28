package dao;

import model.CsvItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> getById(long id);

    Optional<T> save(T model) throws SQLException;

    List<T> saveAll(List<T> modelList) throws SQLException;

}
