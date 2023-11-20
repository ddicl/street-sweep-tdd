package dao;

import model.ScheduleItem;

import java.sql.Connection;
import java.util.Optional;

public class MockScheduleItemDao extends ScheduleItemDao {

    public MockScheduleItemDao(Connection conn) {
        super(conn);
    }

    @Override
    public Optional<ScheduleItem> getById(long id) {
        if(id == 1) {
            ScheduleItem scheduleItem = new ScheduleItem();
            scheduleItem.setId("1");
            scheduleItem.setDist("Test Dist");
            scheduleItem.setDistName("Test Dist Name");
            scheduleItem.setStreetName("Test Street Name");
            return Optional.of(scheduleItem);
        } else {
            return Optional.empty();
        }
    }

}
