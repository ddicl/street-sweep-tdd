import java.util.HashMap;
import java.util.Objects;

public class ScheduleItem extends CsvItem {

    private String id;
    private String streetName;
    private String dist;
    private String distName;

    public static final HashMap<Integer, String> scheduleItemHeaderRow;

    static {
        scheduleItemHeaderRow = new HashMap<>();
        scheduleItemHeaderRow.put(0, "setId");
        scheduleItemHeaderRow.put(1, "setStreetName");
        scheduleItemHeaderRow.put(2, "setDist");
        scheduleItemHeaderRow.put(3, "setDistName");
    }

    public ScheduleItem() {}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDistName() {
        return this.distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleItem that = (ScheduleItem) o;
        return Objects.equals(id, that.id) && Objects.equals(streetName, that.streetName) && Objects.equals(dist, that.dist) && Objects.equals(distName, that.distName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetName, dist, distName);
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id='" + id + '\'' +
                ", streetName='" + streetName + '\'' +
                ", dist='" + dist + '\'' +
                ", distName='" + distName + '\'' +
                '}';
    }

}
