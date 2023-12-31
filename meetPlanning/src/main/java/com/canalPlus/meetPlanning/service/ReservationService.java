package com.canalPlus.meetPlanning.service;

import com.canalPlus.meetPlanning.dto.meeting.MeetingInDto;
import com.canalPlus.meetPlanning.model.Salle;
import com.canalPlus.meetPlanning.repository.ReservationRepository;
import com.canalPlus.meetPlanning.repository.SalleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.canalPlus.meetPlanning.utils.Constants.CAPACITY_PERCENT;
import static com.canalPlus.meetPlanning.utils.Constants.INTERVAL_HOURS_NUMBER;

@Slf4j
@Service
public class ReservationService {

    private final SalleRepository salleRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(SalleRepository salleRepository, ReservationRepository reservationRepository) {
        this.salleRepository = salleRepository;
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Salle reserve(MeetingInDto meetingInDto) throws Exception {

        List<Salle> salles = salleRepository.findAll();
        List sortedSallesByPlacesNumber= new ArrayList();
        List<Salle> notReservedSalles = new ArrayList<>();

        sortedSallesByPlacesNumber = salles.stream().filter(s -> meetingInDto.getCollaboratorsNumber() <= s.getCapacity() * CAPACITY_PERCENT)
                .sorted((a, b) -> (int) ((a.getCapacity() * CAPACITY_PERCENT - meetingInDto.getCollaboratorsNumber()) - (b.getCapacity() * CAPACITY_PERCENT - meetingInDto.getCollaboratorsNumber())))
                .collect(Collectors.toList());

        log.info(sortedSallesByPlacesNumber.toString());

        if (sortedSallesByPlacesNumber.size() == 0) {
            throw new Exception("Aucune salle peut supporter le nombre des participans a votre reunion! Veuillez chosir un autre jour");
        }


        sortedSallesByPlacesNumber.forEach(s -> {
                Salle salle = (Salle) s;
                if(reservationRepository.isAlreadyReserved(salle.getId(),meetingInDto.getMeetingDate(), Integer.parseInt(meetingInDto.getStartHour()),  INTERVAL_HOURS_NUMBER )==0){
                    notReservedSalles.add((Salle) s);
                }
        });

        if(notReservedSalles.size()==0){
            throw new Exception("Toutes les salles sont reservees");
        }


        notReservedSalles.forEach(s-> log.info("xxxx "+s.getEquipments()));

        log.info("final list is"+ notReservedSalles.toString());
        return notReservedSalles.get(1);
    }
}
