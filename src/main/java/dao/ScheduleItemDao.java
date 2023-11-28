package dao;

import model.CsvItem;
import model.ScheduleItem;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScheduleItemDao implements Dao<ScheduleItem> {

    private final Connection conn;
    private static final String SELECT_BY_ID = "SELECT * FROM schedule_item WHERE id = ?";
  private static final String INSERT =
      "INSERT INTO schedule_item (main_id, st_name, dist, dist_name, start_time, end_time, side, from_st, to_st, miles,\n" +
              "                           section, one_way, week_1, week_2, week_3, week_4, week_5, sunday, monday, tuesday, wednesday,\n" +
              "                           thursday, friday, saturday, every_day, year_round, north_end_pilot, timestamp, parent, losta,\n" +
              "                           hista) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

    @Override
    public Optional<ScheduleItem> save(ScheduleItem scheduleItem) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<ScheduleItem> saveAll(List<ScheduleItem> scheduleItemList) throws SQLException {
        conn.setAutoCommit(false);

        PreparedStatement preparedStatement = conn.prepareStatement(INSERT);
        for(ScheduleItem scheduleItem : scheduleItemList) {
            preparedStatement.setInt(1, Integer.parseInt(scheduleItem.getId()));
            preparedStatement.setString(2, scheduleItem.getStreetName());
            preparedStatement.setString(3, scheduleItem.getDist());
            preparedStatement.setString(4, scheduleItem.getDistName());
            preparedStatement.setTime(5, Time.valueOf(LocalTime.parse(scheduleItem.getStartTime())));
            preparedStatement.setTime(6, Time.valueOf(LocalTime.parse(scheduleItem.getEndTime())));
            preparedStatement.setString(7, scheduleItem.getSide());
            preparedStatement.setString(8, scheduleItem.getFromStreet());
            preparedStatement.setString(9,  scheduleItem.getToStreet());
            preparedStatement.setFloat(10, Float.parseFloat(scheduleItem.getMiles()));
            preparedStatement.setString(11, scheduleItem.getSection());
            preparedStatement.setString(12, scheduleItem.getOneWay());
            preparedStatement.setString(13, scheduleItem.getWeek1());
            preparedStatement.setString(14, scheduleItem.getWeek2());
            preparedStatement.setString(15, scheduleItem.getWeek3());
            preparedStatement.setString(16, scheduleItem.getWeek4());
            preparedStatement.setString(17, scheduleItem.getWeek5());
            preparedStatement.setString(18, scheduleItem.getSunday());
            preparedStatement.setString(19, scheduleItem.getMonday());
            preparedStatement.setString(20, scheduleItem.getTuesday());
            preparedStatement.setString(21, scheduleItem.getWednesday());
            preparedStatement.setString(22, scheduleItem.getThursday());
            preparedStatement.setString(23, scheduleItem.getFriday());
            preparedStatement.setString(24, scheduleItem.getSaturday());
            preparedStatement.setString(25, scheduleItem.getEveryDay());
            preparedStatement.setString(26, scheduleItem.getYearRound());
            preparedStatement.setString(27, scheduleItem.getNorthEndPilot());
            preparedStatement.setTimestamp(28, Timestamp.valueOf(scheduleItem.getTimestamp().split("\\+")[0]));
            preparedStatement.setString(29, scheduleItem.getParent());
            preparedStatement.setString(30, scheduleItem.getLosta());
            preparedStatement.setString(31, scheduleItem.getHista());

            preparedStatement.addBatch();
        }

        int[] count = preparedStatement.executeBatch();

        if(count.length == scheduleItemList.size()) {
            conn.commit();
            return scheduleItemList;
        } else {
            conn.rollback();
            return new ArrayList<>();
        }
    }

}
