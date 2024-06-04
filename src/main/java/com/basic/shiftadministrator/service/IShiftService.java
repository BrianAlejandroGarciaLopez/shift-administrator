package com.basic.shiftadministrator.service;

import com.basic.shiftadministrator.model.ShiftModel;

import java.time.OffsetDateTime;
import java.util.List;

public interface IShiftService {
    void addShift(OffsetDateTime date, String treatment, String dniPatient);
    String deleteShift(Long id);
    ShiftModel findShiftById(Long id);
    List<ShiftModel> findAllShift();
    void updateShift(ShiftModel shift);
}
