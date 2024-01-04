package com.canalPlus.meetPlanning.repository;

import com.canalPlus.meetPlanning.model.FixedEquipment;
import com.canalPlus.meetPlanning.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
