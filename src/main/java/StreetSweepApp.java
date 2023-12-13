import config.BasicDataSourceImpl;
import dao.Dao;
import dao.ScheduleItemDao;
import model.CsvItem;
import model.ScheduleItem;
import service.ScheduleItemService;
import util.Constant;
import util.CsvUtil;
import util.UtilException;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetSweepApp {

    private static final String fileUrl = "https://data.boston.gov/dataset/00c015a1-2b62-4072-a71e-79b292ce9670/resource/9fdbdcad-67c8-4b23-b6ec-861e77d56227/download/tmpx9lbex7l.csv";
    private static final String fileName = "street_sweeping_data.csv";
    private static final CsvItem csvItem = new ScheduleItem();
    private static final CsvUtil<CsvItem> csvUtil = new CsvUtil<>(ScheduleItem.class);
    private static final boolean headerRowPresent = true;

    public static void main(String[] args) {
        System.out.println("Street Sweep Application");
        List<CsvItem> csvItemList;
        try {
            downloadFile(fileUrl, fileName);
            csvItemList = convertFileToObjectList(fileName, headerRowPresent, csvItem);
            Connection conn = BasicDataSourceImpl.getDataSource().getConnection();
            Dao<ScheduleItem> dao = new ScheduleItemDao(conn);
            ScheduleItemService scheduleItemService = new ScheduleItemService(dao);
            List<ScheduleItem> scheduleItemList = downcastScheduleItemList(csvItemList);
            saveAllScheduleItems(scheduleItemList, scheduleItemService);
        } catch (SQLException e) {
            throw new RuntimeException("Error in saveAllScheduleItems: " + e.getMessage());
        } catch (UtilException e) {
            throw new RuntimeException(e.getMessage());
        }
//        convertToStringAndOutput(csvItemList, csvItem);
    }

    private static void downloadFile(String urlName, String fileName) throws UtilException {
        URL url = fetchUrl(urlName);
        if(url != null) {
            util.FileUtil.downloadFile(url, fileName);
        } else {
            throw new RuntimeException("Invalid URL");
        }
    }

    private static URL fetchUrl(String url) {
        URL dataUrl = null;
        try {
            dataUrl = new URL(url);
        } catch(MalformedURLException e) {
            throw new RuntimeException("Error in StreetSweepApp fetchUrl method: " + e.getMessage());
        }
        return dataUrl;
    }

    private static List<CsvItem> convertFileToObjectList(String fileName, boolean headerRowPresent, CsvItem csvItem) throws UtilException {
        String[] fileLines = CsvUtil.readFileToLineArr(fileName, headerRowPresent);
        return csvUtil.storeCsvObjectsInList(fileLines, Constant.DELIMITER, csvItem.getMethodHashMap());
    }

    private static void convertToStringAndOutput(List<CsvItem> csvItemList, CsvItem csvItem) {
        List<String> csvItemString = csvUtil.convertCsvObjectListToString(csvItemList);
        CsvUtil.outputTableToConsole(csvItem.getHeaderRow(), csvItemString);
    }

    private static List<ScheduleItem> downcastScheduleItemList(List<CsvItem> csvItemList) {
        List<ScheduleItem> scheduleItemList = new ArrayList<>();
        for(CsvItem csvItem : csvItemList) {
            ScheduleItem scheduleItem = (ScheduleItem) csvItem;
            scheduleItemList.add(scheduleItem);
        }
        return scheduleItemList;
    }

    private static List<ScheduleItem> saveAllScheduleItems(List<ScheduleItem> scheduleItemList, ScheduleItemService scheduleItemService) throws SQLException {
        return scheduleItemService.saveAll(scheduleItemList);
    }

}
