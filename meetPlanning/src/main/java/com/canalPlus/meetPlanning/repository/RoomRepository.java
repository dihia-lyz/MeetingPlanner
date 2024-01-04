package com.canalPlus.meetPlanning.repository;

import com.canalPlus.meetPlanning.dto.room.RoomOutDto;
import com.canalPlus.meetPlanning.model.FixedEquipment;
import com.canalPlus.meetPlanning.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("""
            select new com.canalPlus.meetPlanning.dto.room.RoomOutDto( rm.name , m.startHour , m.endHour, m.meetingDate , m.collaboratorsNumber , rm.capacity) 
            from Reservation r
            join Meeting m
            on m.id = r.meeting.id
            join Room rm
            on rm.id = r.room.id
            """)
    List<RoomOutDto> findAllRooms();
}
