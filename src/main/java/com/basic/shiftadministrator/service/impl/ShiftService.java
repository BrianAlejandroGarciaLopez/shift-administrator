package com.basic.shiftadministrator.service.impl;

import com.basic.shiftadministrator.messaging.feign.PatientFeignClient;
import com.basic.shiftadministrator.model.ShiftModel;
import com.basic.shiftadministrator.model.response.PatientModel;
import com.basic.shiftadministrator.repository.IShiftRepository;
import com.basic.shiftadministrator.service.IShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ShiftService implements IShiftService {
    private final IShiftRepository repository;
    private final PatientFeignClient patientFeignClient;
    @Override
    public ShiftModel addShift(OffsetDateTime date, String treatment, String dniPatient) {
        PatientModel patient = patientFeignClient.getPatientByDni(dniPatient);
        ShiftModel shift = new ShiftModel();
        shift.setPatientFullName(patient.getName()+ " " + patient.getLastName());
        shift.setTreatment(treatment);
        shift.setShiftDate(date);
        return repository.save(shift);
    }

    @Override
    public String deleteShift(Long id) {
        repository.deleteById(id);
        return "Shift deleted from db.";
    }

    @Override
    public ShiftModel findShiftById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ShiftModel> findAllShift(Pageable pageable) {
        Page<ShiftModel> page =  repository.findAll(PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize()
        ));
        return page.getContent();
    }

    @Override
    public void updateShift(ShiftModel shift) {
        repository.save(shift);
    }
}
