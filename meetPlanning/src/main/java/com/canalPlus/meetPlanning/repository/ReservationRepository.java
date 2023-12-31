package com.canalPlus.meetPlanning.repository;

import com.canalPlus.meetPlanning.model.Reservation;
import com.canalPlus.meetPlanning.model.Salle;
import org.apache.el.parser.BooleanNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("""
            SELECT
                CASE
                    WHEN EXISTS (
                        SELECT r.salle.id
                        FROM Reservation r
                        JOIN Meeting m
                        on m.id = r.meeting.id
                        WHERE r.salle.id = :salle_id
                        AND m.meetingDate =  CAST(:date AS date)
                        And m.startHour <= :startHour
                        AND :startHour < (m.endHour + :interval)
                    ) THEN 1
                    ELSE 0
                end
            """)
    int isAlreadyReserved(
            @Param("salle_id") Long salle_id,
            @Param("date") String date,
            @Param("startHour") int startHour,
            @Param("interval") int interval);
}
