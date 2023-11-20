package service;

import dao.Dao;
import model.ScheduleItem;

import java.util.Optional;

public class ScheduleItemService {

    private final Dao<ScheduleItem> scheduleItemDao;

    public ScheduleItemService(Dao<ScheduleItem> scheduleItemDao) {
        this.scheduleItemDao = scheduleItemDao;
    }

    public Optional<ScheduleItem> getById(long id) {
        return scheduleItemDao.getById(id);
    }

}
