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
public class Salle {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private int capacity;

    @ManyToMany
    @JoinTable(
            name = "salle_equipment",
            joinColumns = @JoinColumn(name = "salle_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    List<FixedEquipment> equipments;

    public List<FixedEquipment> getEquipments() {
        return equipments;
    }

}
