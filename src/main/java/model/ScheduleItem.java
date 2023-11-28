package model;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Objects;

public class ScheduleItem implements CsvItem {

    private String id;
    private String streetName;
    private String dist;
    private String distName;
    private String startTime;
    private String endTime;
    private String side;
    private String fromStreet;
    private String toStreet;
    private String miles;
    private String section;
    private String oneWay;
    private String week1;
    private String week2;
    private String week3;
    private String week4;
    private String week5;
    private String sunday;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String everyDay;
    private String yearRound;
    private String northEndPilot;
    private String timestamp;
    private String parent;
    private String losta;
    private String hista;

    private static final HashMap<Integer, String> methodHeaderRow;
    private static final String headerRow;

    static {
        methodHeaderRow = new HashMap<>();
        methodHeaderRow.put(0, "setId");
        methodHeaderRow.put(1, "setStreetName");
        methodHeaderRow.put(2, "setDist");
        methodHeaderRow.put(3, "setDistName");
        methodHeaderRow.put(4, "setStartTime");
        methodHeaderRow.put(5, "setEndTime");
        methodHeaderRow.put(6, "setSide");
        methodHeaderRow.put(7, "setFromStreet");
        methodHeaderRow.put(8, "setToStreet");
        methodHeaderRow.put(9, "setMiles");
        methodHeaderRow.put(10, "setSection");
        methodHeaderRow.put(11, "setOneWay");
        methodHeaderRow.put(12, "setWeek1");
        methodHeaderRow.put(13, "setWeek2");
        methodHeaderRow.put(14, "setWeek3");
        methodHeaderRow.put(15, "setWeek4");
        methodHeaderRow.put(16, "setWeek5");
        methodHeaderRow.put(17, "setSunday");
        methodHeaderRow.put(18, "setMonday");
        methodHeaderRow.put(19, "setTuesday");
        methodHeaderRow.put(20, "setWednesday");
        methodHeaderRow.put(21, "setThursday");
        methodHeaderRow.put(22, "setFriday");
        methodHeaderRow.put(23, "setSaturday");
        methodHeaderRow.put(24, "setEveryDay");
        methodHeaderRow.put(25, "setYearRound");
        methodHeaderRow.put(26, "setNorthEndPilot");
        methodHeaderRow.put(27, "setTimestamp");
        methodHeaderRow.put(28, "setParent");
        methodHeaderRow.put(29, "setLosta");
        methodHeaderRow.put(30, "setHista");

        headerRow = "main_id,st_name,dist,dist_name,start_time,end_time,side,from,to,miles,section,one_way,week_1,week_2,week_3,week_4,week_5,sunday,monday,tuesday,wednesday,thursday,friday,saturday,every_day,year_round,north_end_pilot,timestamp,parent,losta,hista";
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getFromStreet() {
        return fromStreet;
    }

    public void setFromStreet(String fromStreet) {
        this.fromStreet = fromStreet;
    }

    public String getToStreet() {
        return toStreet;
    }

    public void setToStreet(String toStreet) {
        this.toStreet = toStreet;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getOneWay() {
        return oneWay;
    }

    public void setOneWay(String oneWay) {
        this.oneWay = oneWay;
    }

    public String getWeek1() {
        return week1;
    }

    public void setWeek1(String week1) {
        this.week1 = week1;
    }

    public String getWeek2() {
        return week2;
    }

    public void setWeek2(String week2) {
        this.week2 = week2;
    }

    public String getWeek3() {
        return week3;
    }

    public void setWeek3(String week3) {
        this.week3 = week3;
    }

    public String getWeek4() {
        return week4;
    }

    public void setWeek4(String week4) {
        this.week4 = week4;
    }

    public String getWeek5() {
        return week5;
    }

    public void setWeek5(String week5) {
        this.week5 = week5;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getEveryDay() {
        return everyDay;
    }

    public void setEveryDay(String everyDay) {
        this.everyDay = everyDay;
    }

    public String getYearRound() {
        return yearRound;
    }

    public void setYearRound(String yearRound) {
        this.yearRound = yearRound;
    }

    public String getNorthEndPilot() {
        return northEndPilot;
    }

    public void setNorthEndPilot(String northEndPilot) {
        this.northEndPilot = northEndPilot;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getLosta() {
        return losta;
    }

    public void setLosta(String losta) {
        this.losta = losta;
    }

    public String getHista() {
        return hista;
    }

    public void setHista(String hista) {
        this.hista = hista;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleItem that = (ScheduleItem) o;
        return Objects.equals(id, that.id) && Objects.equals(streetName, that.streetName) && Objects.equals(dist, that.dist) && Objects.equals(distName, that.distName) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(side, that.side) && Objects.equals(fromStreet, that.fromStreet) && Objects.equals(toStreet, that.toStreet) && Objects.equals(miles, that.miles) && Objects.equals(section, that.section) && Objects.equals(oneWay, that.oneWay) && Objects.equals(week1, that.week1) && Objects.equals(week2, that.week2) && Objects.equals(week3, that.week3) && Objects.equals(week4, that.week4) && Objects.equals(week5, that.week5) && Objects.equals(sunday, that.sunday) && Objects.equals(monday, that.monday) && Objects.equals(tuesday, that.tuesday) && Objects.equals(wednesday, that.wednesday) && Objects.equals(thursday, that.thursday) && Objects.equals(friday, that.friday) && Objects.equals(saturday, that.saturday) && Objects.equals(everyDay, that.everyDay) && Objects.equals(yearRound, that.yearRound) && Objects.equals(northEndPilot, that.northEndPilot) && Objects.equals(timestamp, that.timestamp) && Objects.equals(parent, that.parent) && Objects.equals(losta, that.losta) && Objects.equals(hista, that.hista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetName, dist, distName, startTime, endTime, side, fromStreet, toStreet, miles, section, oneWay, week1, week2, week3, week4, week5, sunday, monday, tuesday, wednesday, thursday, friday, saturday, everyDay, yearRound, northEndPilot, timestamp, parent, losta, hista);
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "id='" + id + '\'' +
                ", streetName='" + streetName + '\'' +
                ", dist='" + dist + '\'' +
                ", distName='" + distName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", side='" + side + '\'' +
                ", fromStreet='" + fromStreet + '\'' +
                ", toStreet='" + toStreet + '\'' +
                ", miles=" + miles +
                ", section='" + section + '\'' +
                ", oneWay='" + oneWay + '\'' +
                ", week1='" + week1 + '\'' +
                ", week2='" + week2 + '\'' +
                ", week3='" + week3 + '\'' +
                ", week4='" + week4 + '\'' +
                ", week5='" + week5 + '\'' +
                ", sunday='" + sunday + '\'' +
                ", monday='" + monday + '\'' +
                ", tuesday='" + tuesday + '\'' +
                ", wednesday='" + wednesday + '\'' +
                ", thursday='" + thursday + '\'' +
                ", friday='" + friday + '\'' +
                ", saturday='" + saturday + '\'' +
                ", everyDay='" + everyDay + '\'' +
                ", yearRound='" + yearRound + '\'' +
                ", northEndPilot='" + northEndPilot + '\'' +
                ", timestamp=" + timestamp +
                ", parent='" + parent + '\'' +
                ", losta='" + losta + '\'' +
                ", hista='" + hista + '\'' +
                '}';
    }

}
