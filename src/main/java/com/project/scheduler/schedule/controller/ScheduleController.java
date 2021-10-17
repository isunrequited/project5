package com.project.scheduler.schedule.controller;

import com.project.scheduler.schedule.domain.FullCalendar;
import com.project.scheduler.schedule.domain.Schedule;
import com.project.scheduler.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/schedule")
@Log4j2
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/add")
    public String add() {

        return "/add";
    }

    @GetMapping("/scd-add")
    public String scdAdd(Schedule schedule, String type, String date) {

        log.info(schedule);
        log.info(date);
        //scheduleService.insertSchedule(type, schedule);

        return "/add";
    }

    @GetMapping("/calendar")
    public String calendar() {
        return "/calendar";
    }

    @GetMapping("/get-schedule")
    @ResponseBody
    public ResponseEntity<List<Schedule>> data() {
        log.info("호출됨");
        List<Schedule> schedules = scheduleService.getMonthScheduleList(10);
        log.info(schedules);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<List<Schedule>> test() {
        log.info("호출됨");
        List<Schedule> schedules = scheduleService.getMonthScheduleList(10);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
}
