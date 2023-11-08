import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StreetSweepApp {

    private static final String fileName = "street_sweeping_data.csv";
    private static URL dataUrl;
    private static final CsvUtil<ScheduleItem> csvUtil = new CsvUtil<>();
    private static final boolean headerRowPresent = true;

    public static void main(String[] args) {
        System.out.println("Street Sweep Application");
        dataUrl = fetchUrl("https://data.boston.gov/dataset/00c015a1-2b62-4072-a71e-79b292ce9670/resource/9fdbdcad-67c8-4b23-b6ec-861e77d56227/download/tmpx9lbex7l.csv");

        if(dataUrl != null) {
            FileUtil.downloadFile(dataUrl, fileName);
        } else {
            throw new RuntimeException("Invalid URL");
        }

        String[] fileLines = CsvUtil.readFileToLineArr(fileName, headerRowPresent);
        List<ScheduleItem> scheduleItemList = new ArrayList<>();

        for (String fileLine : fileLines) {
            ScheduleItem scheduleItem = csvUtil.convertCsvLineToObject(fileLine, Constant.delimiter, ScheduleItem.scheduleItemHeaderRow, ScheduleItem.class);
            scheduleItemList.add(scheduleItem);
        }

        List<String> stringList = csvUtil.convertCsvObjectListToString(scheduleItemList);
        CsvUtil.outputTableToConsole(ScheduleItem.headerRow, stringList);
    }

    private static URL fetchUrl(String url) {
        URL dataUrl = null;
        try {
            dataUrl = new URL(url);
        } catch(MalformedURLException e) {
            System.out.println("Error in StreetSweepApp main method: " + e.getMessage());
        }
        return dataUrl;
    }

}
