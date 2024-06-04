package com.basic.shiftadministrator.service;

import com.basic.shiftadministrator.model.ShiftModel;
import org.springframework.data.domain.Pageable;

import java.time.OffsetDateTime;
import java.util.List;

public interface IShiftService {
    ShiftModel addShift(OffsetDateTime date, String treatment, String dniPatient);
    String deleteShift(Long id);
    ShiftModel findShiftById(Long id);
    List<ShiftModel> findAllShift(Pageable pageable);
    void updateShift(ShiftModel shift);
}
