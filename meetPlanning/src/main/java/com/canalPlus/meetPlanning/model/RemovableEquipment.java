package com.canalPlus.meetPlanning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RemovableEquipment {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private int equipmentNumber;
    @Column
    private int reservedNumber;
}
