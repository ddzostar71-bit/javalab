package by.bsuir.travel.dao;

import java.util.List;

/**
 * Абстрактный класс DAO с общими методами для работы с базой данных
 * @param <T> тип сущности
 */
public abstract class AbstractDAO<T> {

    /**
     * Получает все записи из БД
     * @return список всех записей
     */
    public abstract List<T> findAll();

    /**
     * Находит сущность по ID
     * @param id идентификатор сущности
     * @return найденная сущность или null
     */
    public abstract T findEntityById(Integer id);

    /**
     * Удаляет запись по ID
     * @param id идентификатор записи для удаления
     * @return true если удаление успешно, false иначе
     */
    public abstract boolean delete(Integer id);

    /**
     * Удаляет сущность
     * @param entity сущность для удаления
     * @return true если удаление успешно, false иначе
     */
    public abstract boolean delete(T entity);

    /**
     * Создает новую запись в БД
     * @param entity сущность для создания
     * @return true если создание успешно, false иначе
     */
    public abstract boolean create(T entity);

    /**
     * Обновляет существующую запись
     * @param entity сущность для обновления
     * @return обновленная сущность
     */
    public abstract T update(T entity);
}
