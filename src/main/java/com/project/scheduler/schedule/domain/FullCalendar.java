package com.project.scheduler.schedule.domain;

import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FullCalendar {

    private String title;
    private String start;
    private String end;
    private boolean allDay;
}
