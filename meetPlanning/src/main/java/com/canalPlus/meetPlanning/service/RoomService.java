package com.canalPlus.meetPlanning.service;

import com.canalPlus.meetPlanning.dto.room.RoomOutDto;
import com.canalPlus.meetPlanning.model.Room;
import com.canalPlus.meetPlanning.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomOutDto> getAll(){
        return roomRepository.findAllRooms();
    }
}
