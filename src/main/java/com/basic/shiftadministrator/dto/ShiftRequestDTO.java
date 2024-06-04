package com.basic.shiftadministrator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftRequestDTO {
    private LocalDate date;
    private String treatment;
    private String dni;
}
