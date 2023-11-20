package model;

import java.util.HashMap;

public interface CsvItem {

    String formatForOutput();

    HashMap<Integer, String> getMethodHashMap();

    String getHeaderRow();

    Class<? extends CsvItem> getClazz();

}
