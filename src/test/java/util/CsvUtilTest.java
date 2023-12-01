package util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import model.ScheduleItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CsvUtilTest {

    private static ScheduleItem scheduleItem;
    private static ScheduleItem scheduleItem2;
    private static List<ScheduleItem> scheduleItemList;
    private static String[] lines;
    private static List<String> linesList;
    private static CsvUtil<ScheduleItem> csvUtil;
    private static final String fileName = "test_data.csv";

    @BeforeAll
    public static void init() {
        scheduleItem = new ScheduleItem();
        scheduleItem.setId("1");
        scheduleItem.setStreetName("Test Street Name");
        scheduleItem.setDist("5");
        scheduleItem.setDistName("Test Dist Name");

        scheduleItem2 = new ScheduleItem();
        scheduleItem2.setId("2");
        scheduleItem2.setStreetName("Test Street Name 2");
        scheduleItem2.setDist("10");
        scheduleItem2.setDistName("Test Dist Name 2");

        scheduleItemList = new ArrayList<>();
        scheduleItemList.add(scheduleItem);
        scheduleItemList.add(scheduleItem2);

        lines = new String[] {
                "1,Test Street Name,5,Test Dist Name",
                "2,Test Street Name 2,10,Test Dist Name 2"
        };

        linesList = new ArrayList<>();
        linesList.add("ScheduleItem{id='1', streetName='Test Street Name', dist='5', distName='Test Dist Name', startTime='null', endTime='null', side='null', fromStreet='null', toStreet='null', miles=null, section='null', oneWay='null', week1='null', week2='null', week3='null', week4='null', week5='null', sunday='null', monday='null', tuesday='null', wednesday='null', thursday='null', friday='null', saturday='null', everyDay='null', yearRound='null', northEndPilot='null', timestamp=null, parent='null', losta='null', hista='null'}");
        linesList.add("ScheduleItem{id='2', streetName='Test Street Name 2', dist='10', distName='Test Dist Name 2', startTime='null', endTime='null', side='null', fromStreet='null', toStreet='null', miles=null, section='null', oneWay='null', week1='null', week2='null', week3='null', week4='null', week5='null', sunday='null', monday='null', tuesday='null', wednesday='null', thursday='null', friday='null', saturday='null', everyDay='null', yearRound='null', northEndPilot='null', timestamp=null, parent='null', losta='null', hista='null'}");
        csvUtil = new CsvUtil<>(ScheduleItem.class);

    }

    @Test
    void convertCsvLineToObject_returns_object() {
        String line = "1,Test Street Name,5,Test Dist Name";

        assertEquals(scheduleItem, csvUtil.convertCsvLineToObject(line, Constant.DELIMITER, scheduleItem.getMethodHashMap()));
    }

    @Test
    void readFileToLineArr_returns_string_array() {
        String[] fileLines = CsvUtil.readFileToLineArr(fileName, true);

        assertEquals(lines[0], fileLines[0]);
        assertEquals(lines[1], fileLines[1]);
    }

    @Test
    void storeCsvObjectsInList_returns_list() {
        List<ScheduleItem> scheduleItemListFromMethod = csvUtil.storeCsvObjectsInList(lines, Constant.DELIMITER, scheduleItem.getMethodHashMap());

        assertTrue(scheduleItemList.contains(scheduleItemListFromMethod.get(0)));
        assertTrue(scheduleItemList.contains(scheduleItemListFromMethod.get(1)));
        assertEquals(scheduleItemList.size(), scheduleItemListFromMethod.size());
    }

    @Test
    void convertCsvObjectListToString_returns_list() {
        List<String> scheduleItemListFromMethod = csvUtil.convertCsvObjectListToString(scheduleItemList);

        assertTrue(linesList.contains(scheduleItemListFromMethod.get(0)));
        assertTrue(linesList.contains(scheduleItemListFromMethod.get(1)));
        assertEquals(linesList.size(), scheduleItemListFromMethod.size());
    }

}
