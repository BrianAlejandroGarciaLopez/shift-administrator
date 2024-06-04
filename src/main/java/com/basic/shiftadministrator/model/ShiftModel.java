package com.basic.shiftadministrator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@Entity
@RequiredArgsConstructor
public class ShiftModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShift;
    private OffsetDateTime shiftDate;
    private String patientFullName;
    private String treatment;
}
