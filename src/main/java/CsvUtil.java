import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CsvUtil {

    public static ScheduleItem convertCsvLineToObject(String line, String delimiter, HashMap<Integer, String> headerMap) {
        String[] splitLine = line.split(delimiter);
        ScheduleItem scheduleItem = new ScheduleItem();
        for(int i = 0; i < splitLine.length; i++) {
            Method method;
            try {
                method = scheduleItem.getClass().getMethod(headerMap.get(i), String.class);
                method.invoke(scheduleItem, splitLine[i]);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("Error in convertCsvLineToObject: " + e.getMessage());
            }
        }
        return scheduleItem;
    }

    public static String[] readFileToLineArr(String fileName, boolean headerRowPresent) {
        Path file = Path.of(System.getProperty("user.dir") + "/" + fileName);
        List<String> fileToLines = null;
        String[] filesToLinesArr;
        try {
            fileToLines = Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println("Error in readFileToLineArr: " + e.getMessage());
        }
        if(fileToLines != null && headerRowPresent) {
            fileToLines.remove(0);
        }
        if(fileToLines != null) {
            filesToLinesArr = fileToLines.toArray(new String[fileToLines.size()]);
        } else {
            return new String[0];
        }
        return filesToLinesArr;
    }

    public static List<ScheduleItem> storeCsvObjectsInList(String[] lines, String delimiter, HashMap<Integer, String> headerMap) {
        List<ScheduleItem> scheduleItemList = new ArrayList<>();
        for(int i = 0; i < lines.length; i++) {
            ScheduleItem scheduleItem = CsvUtil.convertCsvLineToObject(lines[0], delimiter, headerMap);
            scheduleItemList.add(scheduleItem);
        }
        return scheduleItemList;
    }

}
