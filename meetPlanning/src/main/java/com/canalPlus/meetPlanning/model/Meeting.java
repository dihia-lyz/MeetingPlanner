package com.canalPlus.meetPlanning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Meeting {
    @Id
    private Long id;

    @Column
    private LocalDate meetingDate;

    @Column
    private int startHour;

    @Column
    private int endHour ;

    @Column
    private int collaboratorsNumber;

    @ManyToOne
    @JoinColumn(name = "meeting_type_id")
    private MeetingType meetingType;

}
