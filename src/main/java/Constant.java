import java.util.HashMap;

public final class Constant {

    private Constant() {

    }

    public static final HashMap<Integer, String> scheduleItemHeaderRow;

    static {
        scheduleItemHeaderRow = new HashMap<>();
        scheduleItemHeaderRow.put(0, "setId");
        scheduleItemHeaderRow.put(1, "setStreetName");
        scheduleItemHeaderRow.put(2, "setDist");
        scheduleItemHeaderRow.put(3, "setDistName");
    }

}
