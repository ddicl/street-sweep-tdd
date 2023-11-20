package dao;

import java.util.Optional;

public interface Dao<T> {

    Optional<T> getById(long id);

}
