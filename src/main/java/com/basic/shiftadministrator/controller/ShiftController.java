package com.basic.shiftadministrator.controller;

import com.basic.shiftadministrator.dto.ShiftRequestDTO;
import com.basic.shiftadministrator.model.ShiftModel;
import com.basic.shiftadministrator.service.impl.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/shift-administrator")
public class ShiftController {
    private final ShiftService shiftService;
    @PostMapping("/add-shift")
    private void addShift(@RequestBody ShiftRequestDTO request){
        ZoneOffset zoneOffset = ZoneId.of("UTC-6").getRules().getOffset(Instant.now());
        shiftService.addShift(OffsetDateTime.of(request.getDate().atTime(0,0),zoneOffset), request.getTreatment(), request.getDni());
    }
    @DeleteMapping("/delete/{id}")
    private String deleteShift(@PathVariable Long id){
        return shiftService.deleteShift(id);
    }
    @GetMapping("/shift/{id}")
    private ShiftModel findShiftById(@PathVariable Long id){
        return shiftService.findShiftById(id);
    }
    @GetMapping("/shifts")
    private List<ShiftModel> findAllShift(){
        return shiftService.findAllShift();
    }
    @PutMapping("/update-shift")
    private void updateShift(@RequestBody ShiftModel shift){
        shiftService.updateShift(shift);
    }
}

