package com.canalPlus.meetPlanning.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomOutDto {
    private String roomName;
    private int startHour;
    private int endHour;
    private LocalDate meetingDate;
    private int collaboratorsNumber;
    private int capacity;

}
