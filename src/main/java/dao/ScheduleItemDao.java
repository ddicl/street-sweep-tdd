package dao;

import config.BasicDataSourceImpl;
import model.ScheduleItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ScheduleItemDao implements Dao<ScheduleItem> {

    private final Connection conn;
    private static final String SELECT_BY_ID = "SELECT * FROM schedule_item WHERE id = ?";

    public ScheduleItemDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Optional<ScheduleItem> getById(long id) {
        Optional<ScheduleItem> scheduleItemOptional = Optional.empty();
        try(PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.first()) {
                ScheduleItem scheduleItem = new ScheduleItem();
                scheduleItem.setId(rs.getString(1));
                scheduleItem.setStreetName(rs.getString(2));
                scheduleItem.setDist(rs.getString(3));
                scheduleItem.setDistName(rs.getString(4));
                scheduleItemOptional = Optional.of(scheduleItem);
            }
        } catch (SQLException e) {
            System.out.println("Error in getById method: " + e.getMessage());
        }

        return scheduleItemOptional;
    }

}
