package com.canalPlus.meetPlanning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reservation {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    @OneToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
}
