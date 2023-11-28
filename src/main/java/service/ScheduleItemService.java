package service;

import dao.Dao;
import model.ScheduleItem;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ScheduleItemService {

    private final Dao<ScheduleItem> scheduleItemDao;

    public ScheduleItemService(Dao<ScheduleItem> scheduleItemDao) {
        this.scheduleItemDao = scheduleItemDao;
    }

    public Optional<ScheduleItem> getById(long id) {
        return scheduleItemDao.getById(id);
    }

    public List<ScheduleItem> saveAll(List<ScheduleItem> scheduleItemList) throws SQLException {
        return scheduleItemDao.saveAll(scheduleItemList);
    }

}
