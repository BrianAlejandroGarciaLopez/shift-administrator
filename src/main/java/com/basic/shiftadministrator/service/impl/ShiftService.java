package com.basic.shiftadministrator.service.impl;

import com.basic.shiftadministrator.model.ShiftModel;
import com.basic.shiftadministrator.model.response.PatientModel;
import com.basic.shiftadministrator.repository.IShiftRepository;
import com.basic.shiftadministrator.service.IShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ShiftService implements IShiftService {
    private final IShiftRepository repository;
    private final RestTemplate apiConsume;
    @Override
    public void addShift(OffsetDateTime date, String treatment, String dniPatient) {
        PatientModel patient = apiConsume.getForObject("http://localhost:9001/patient-manager/patient/dni/"+dniPatient,PatientModel.class);
        ShiftModel shift = new ShiftModel();
        shift.setPatientFullName(patient.getName()+ " " + patient.getLastName());
        shift.setTreatment(treatment);
        shift.setShiftDate(date);
        repository.save(shift);
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
    public List<ShiftModel> findAllShift() {
        return repository.findAll();
    }

    @Override
    public void updateShift(ShiftModel shift) {
        repository.save(shift);
    }
}
