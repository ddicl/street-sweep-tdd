package util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.CsvItem;

public class CsvUtil<T extends CsvItem> {

    private final Class<? extends T> clazz;

    public CsvUtil(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    public T convertCsvLineToObject(String line, String delimiter, HashMap<Integer, String> headerMap) throws UtilException {
        String[] splitLine = line.split(delimiter);
        T csvItem = null;
        try {
            csvItem = clazz.getDeclaredConstructor().newInstance();
            for (int i = 0; i < splitLine.length; i++) {
                Method method;
                try {
                    method = csvItem.getClass().getMethod(headerMap.get(i), String.class);
                    method.invoke(csvItem, splitLine[i]);
                } catch (NoSuchMethodException e) {
                    throw new UtilException("Error in convertCsvLineToObject: " + e.getMessage());
                }
            }
        } catch (NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException
                 | InstantiationException
                 | NullPointerException e) {
            throw new UtilException("Error in convertCsvLineToObject: " + e.getMessage());
        }
        return csvItem;
    }

    public static String[] readFileToLineArr(String fileName, boolean headerRowPresent) throws UtilException {
        Path file = Path.of(System.getProperty("user.dir") + "/" + fileName);
        List<String> fileToLines;
        String[] filesToLinesArr;
        try {
            fileToLines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new UtilException("Error in readFileToLineArr: " + e.getMessage());
        }
        if(headerRowPresent) {
            fileToLines.remove(0);
        }
        filesToLinesArr = fileToLines.toArray(new String[0]);
        return filesToLinesArr;
    }

    public List<T> storeCsvObjectsInList(String[] lines, String delimiter, HashMap<Integer, String> headerMap) throws UtilException {
        List<T> csvItemList = new ArrayList<>();
        for (String line : lines) {
            T csvItem = convertCsvLineToObject(line, delimiter, headerMap);
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
        scheduleItemList.forEach(scheduleItem -> stringList.add(scheduleItem.toString()));
        return stringList;
    }

}
