package com.canalPlus.meetPlanning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MeetingType {
    @Id
    private Long id;
    @Column
    private String name;

    @Column
    private int minCollaboratorsNumber;

    @OneToMany(mappedBy = "meetingType")
    List<Meeting> meetings;

    @ManyToMany
    @JoinTable(
            name = "meeting_type_equipment",
            joinColumns = @JoinColumn(name = "meeting_type_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    List<FixedEquipment> equipments;
}
