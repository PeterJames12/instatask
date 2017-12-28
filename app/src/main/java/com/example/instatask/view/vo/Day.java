package com.example.instatask.view.vo;

import com.example.instatask.model.dto.Schedule;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Igor Hnes on 12/26/17.
 */
@Getter
@Setter
public class Day {
    private String date;
    private List<Schedule> schedules;
}
