package service;

import dao.Dao;
import dao.MockScheduleItemDao;
import model.ScheduleItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleItemServiceTest {

    private static ScheduleItemService scheduleItemService;
    private static ScheduleItem scheduleItem;

    @BeforeAll
    public static void init() {
        Dao<ScheduleItem> scheduleItemDao = new MockScheduleItemDao(null);
        scheduleItemService = new ScheduleItemService(scheduleItemDao);
        scheduleItem = new ScheduleItem();
        scheduleItem.setId("1");
        scheduleItem.setStreetName("Test Street Name");
        scheduleItem.setDist("Test Dist");
        scheduleItem.setDistName("Test Dist Name");
    }

    @Test
    void getById_returns_ScheduleItem() {
        Optional<ScheduleItem> scheduleItemOptional = Optional.empty();
        try {
            scheduleItemOptional = scheduleItemService.getById(1);
        } catch (SQLException e) {
            fail(e);
        }

        assertTrue(scheduleItemOptional.isPresent());
        assertEquals(scheduleItem, scheduleItemOptional.get());
    }

    @Test
    void getById_returns_empty_optional_when_not_exist() {
        Optional<ScheduleItem> scheduleItemOptional = Optional.empty();
        try {
            scheduleItemOptional = scheduleItemService.getById(2);
        } catch (SQLException e) {
            fail(e);
        }

        assertTrue(scheduleItemOptional.isEmpty());
    }

}
