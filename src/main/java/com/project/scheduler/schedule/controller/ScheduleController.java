package com.project.scheduler.schedule.controller;

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

    // 추가 페이지 이동
    @GetMapping("/add/{empNo}")
    public String add(@PathVariable int empNo, Model model) {
        model.addAttribute("empNo", empNo);
        return "/add";
    }

    // 추가 기능
    @PostMapping("/scd-add/{empNo}")
    public String scdAdd(Schedule schedule, String type, @PathVariable int empNo) {

        // 클라이언트로부터 데이터를 받아 서비스메서드로 보냄
        log.info(schedule);
        log.info("==========================================");

        scheduleService.insertSchedule(type, schedule, empNo);
        return "redirect:/schedule/calendar/" + empNo;
    }

    // 일정표 페이지 이동
    @GetMapping("/calendar/{empNo}")
    public String calendar(@PathVariable int empNo, Model model) {
        model.addAttribute("empNo", empNo);
        return "/calendar";
    }

    // 일정 가져오는 기능
    @GetMapping("/get-schedule/{empNo}")
    @ResponseBody
    public ResponseEntity<List<Schedule>> data (String type, @PathVariable int empNo) {
        log.info(type);
        log.info("/schedule/get-schedule - GET 호출");
        List<Schedule> schedules = scheduleService.getScheduleList(type, empNo);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    // 수정 페이지 이동
    @GetMapping("/modify/{empNo}")
    public String modify(@PathVariable int empNo, int scdNo, Model model) {
        model.addAttribute("empNo", empNo);
        model.addAttribute("schedule", scheduleService.getSchedule(scdNo));
        log.info(scheduleService.getSchedule(scdNo));
        return "/modify";
    }

    // 수정 기능
    @PostMapping("/mod-schedule/{empNo}")
    public String modify(@PathVariable int empNo, Schedule schedule) {
        //scheduleService.deleteSchedule(scdNo);
        log.info(schedule);
        return "redirect:/schedule/calendar/" + empNo;
    }

    // 삭제 기능
    @PostMapping("/del-schedule/{empNo}")
    public String delete(@PathVariable int empNo, int scdNo) {
        scheduleService.deleteSchedule(scdNo);
        return "redirect:/schedule/calendar/" + empNo;
    }

}