import model.CsvItem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CsvUtil<T extends CsvItem> {

    public T convertCsvLineToObject(String line, String delimiter, HashMap<Integer, String> headerMap, Class<T> clazz) {
        String[] splitLine = line.split(delimiter);
        T csvItem = null;
        try {
            csvItem = clazz.getDeclaredConstructor().newInstance();
            for (int i = 0; i < splitLine.length; i++) {
                Method method;
                method = csvItem.getClass().getMethod(headerMap.get(i), String.class);
                method.invoke(csvItem, splitLine[i]);
            }
        } catch (NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException
                 | InstantiationException
                 | NullPointerException e) {
            System.out.println("Error in convertCsvLineToObject: " + e.getMessage());
        }
        return csvItem;
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

    public List<T> storeCsvObjectsInList(String[] lines, String delimiter, HashMap<Integer, String> headerMap, Class<T> clazz) {
        List<T> csvItemList = new ArrayList<>();
        for(int i = 0; i < lines.length; i++) {
            T csvItem = convertCsvLineToObject(lines[0], delimiter, headerMap, clazz);
            csvItemList.add(csvItem);
        }
        return csvItemList;
    }

    public static void outputTableToConsole(String headerRow, List<String> rows) {
        System.out.println(headerRow);
        rows.forEach(System.out::println);
    }

    public List<String> convertCsvObjectListToString(List<T> scheduleItemList) {
        List<String> stringList = new ArrayList<>();
        scheduleItemList.forEach(scheduleItem -> stringList.add(scheduleItem.formatForOutput()));
        return stringList;
    }

}
