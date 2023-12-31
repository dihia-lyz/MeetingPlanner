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
public class FixedEquipment {

    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private int equipmentNumber;
}
