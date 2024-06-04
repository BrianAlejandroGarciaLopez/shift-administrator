package com.basic.shiftadministrator.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShiftControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldGetAllShifts() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("/shift-administrator/shifts",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldGetAShift() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("/shift-administrator/shift/1",String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.idShift");
        assertThat(id).isNotNull();
    }
}
