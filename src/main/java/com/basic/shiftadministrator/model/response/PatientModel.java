package com.basic.shiftadministrator.model.response;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
@AllArgsConstructor
@Data
public class PatientModel {
    private Long idPatient;
    private String dni;
    private String name;
    private String lastName;
    private OffsetDateTime birthDate;
    private String phoneNumber;
}
