import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CsvUtilTest {

    private static final String delimiter = ",";

    @Test
    void convertCsvLineToObject_returns_object() {
        ScheduleItem scheduleItem = new ScheduleItem();
        scheduleItem.setId("1");
        scheduleItem.setStreetName("Test Street Name");
        scheduleItem.setDist("5");
        scheduleItem.setDistName("Test Dist Name");

        String line = "1,Test Street Name,5,Test Dist Name";

        assertEquals(scheduleItem, CsvUtil.convertCsvLineToObject(line, delimiter, Constant.scheduleItemHeaderRow));

    }

    @Test
    void readFileToLineArr_returns_string_array() {
        String[] lines = new String[] {
                "1,Test Street Name,5,Test Dist Name",
                "2,Test Street Name 2,10,Test Dist Name 2"
        };

        String fileName = "test_data.csv";
        String[] fileLines = CsvUtil.readFileToLineArr(fileName, true);

        assertEquals(lines[0], fileLines[0]);
        assertEquals(lines[1], fileLines[1]);

    }

    @Test
    void storeCsvObjectsInList_returns_list() {
        ScheduleItem scheduleItem = new ScheduleItem();
        scheduleItem.setId("1");
        scheduleItem.setStreetName("Test Street Name");
        scheduleItem.setDist("5");
        scheduleItem.setDistName("Test Dist Name");

        ScheduleItem scheduleItem2 = new ScheduleItem();
        scheduleItem2.setId("2");
        scheduleItem2.setStreetName("Test Street Name 2");
        scheduleItem2.setDist("10");
        scheduleItem2.setDistName("Test Dist Name 2");

        List<ScheduleItem> scheduleItemList = new ArrayList<>();
        scheduleItemList.add(scheduleItem);
        scheduleItemList.add(scheduleItem2);

        String[] lines = new String[] {
                "1,Test Street Name,5,Test Dist Name",
                "2,Test Street Name 2,10,Test Dist Name 2"
        };

        List<ScheduleItem> scheduleItemListFromMethod = CsvUtil.storeCsvObjectsInList(lines, delimiter, Constant.scheduleItemHeaderRow);

        assertTrue(scheduleItemList.contains(scheduleItemListFromMethod.get(0)));
        assertTrue(scheduleItemList.contains(scheduleItemListFromMethod.get(1)));
    }

}
