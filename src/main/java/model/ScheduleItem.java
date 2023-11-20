package model;

import java.util.HashMap;
import java.util.Objects;

public class ScheduleItem implements CsvItem {

    private String id;
    private String streetName;
    private String dist;
    private String distName;

    private static final HashMap<Integer, String> methodHeaderRow;
    private static final String headerRow;

    static {
        methodHeaderRow = new HashMap<>();
        methodHeaderRow.put(0, "setId");
        methodHeaderRow.put(1, "setStreetName");
        methodHeaderRow.put(2, "setDist");
        methodHeaderRow.put(3, "setDistName");

        headerRow = "Id | Street Name | Dist | Dist Name";

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
    public HashMap<Integer, String> getMethodHashMap() {
        return methodHeaderRow;
    }

    @Override
    public String getHeaderRow() {
        return headerRow;
    }

    @Override
    public Class<ScheduleItem> getClazz() {
        return ScheduleItem.class;
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
        return "model.ScheduleItem{" +
                "id='" + id + '\'' +
                ", streetName='" + streetName + '\'' +
                ", dist='" + dist + '\'' +
                ", distName='" + distName + '\'' +
                '}';
    }

    @Override
    public String formatForOutput() {
        return this.getId() + " | " +
                this.getStreetName() + " | " +
                this.getDist() + " | " +
                this.getDistName();
    }

}
