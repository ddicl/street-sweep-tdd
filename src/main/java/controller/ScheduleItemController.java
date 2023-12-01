package controller;

import service.ScheduleItemService;

public class ScheduleItemController {

    private final ScheduleItemService scheduleItemService;

    public ScheduleItemController(ScheduleItemService scheduleItemService) {
        this.scheduleItemService = scheduleItemService;
    }

    public void saveAll() {

    }

}
