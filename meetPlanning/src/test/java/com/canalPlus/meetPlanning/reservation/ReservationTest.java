package com.canalPlus.meetPlanning.reservation;

import com.canalPlus.meetPlanning.dto.meeting.MeetingInDto;
import com.canalPlus.meetPlanning.model.Salle;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Slf4j
public class ReservationTest {

    @LocalServerPort
    private int PORT;

    private final TestRestTemplate restTemplate;

    @Autowired
    private final Flyway flyway;

    @Autowired
    public ReservationTest(TestRestTemplate restTemplate, Flyway flyway) {
        this.restTemplate = restTemplate;
        this.flyway= flyway;
    }

    @BeforeAll
    public void clearDatabase() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void itShouldCreateReservationWithRoom1() {
        log.info("test 1");

        //GIVEN
        MeetingInDto meetingInDto = MeetingInDto.builder()
                .meetingTypeId(1L)
                .meetingDate("2024/1/8")
                .collaboratorsNumber(8)
                .startHour("9")
                .endHour("10")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MeetingInDto> requestEntity = new HttpEntity<>(meetingInDto, headers);

//        Reservation reservation =

        //WHEN

        ResponseEntity<Salle> response = restTemplate.postForEntity("http://localhost:" + PORT + "/api/v1/reservation", requestEntity, Salle.class);
        //THEN
        assertEquals(response.getBody().getName(), "E3001");


    }

}
