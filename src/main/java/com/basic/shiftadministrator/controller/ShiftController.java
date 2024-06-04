package com.basic.shiftadministrator.controller;

import com.basic.shiftadministrator.dto.ShiftRequestDTO;
import com.basic.shiftadministrator.model.ShiftModel;
import com.basic.shiftadministrator.service.impl.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    private ResponseEntity<Void> addShift(@RequestBody ShiftRequestDTO request, UriComponentsBuilder uriBuilder){
        ZoneOffset zoneOffset = ZoneId.of("UTC-6").getRules().getOffset(Instant.now());
        ShiftModel shift = shiftService .addShift(OffsetDateTime.of(request.getDate().atTime(0,0),zoneOffset), request.getTreatment(), request.getDni());
        URI uriLocation = uriBuilder.path("/shift-administrator/shift")
                .buildAndExpand(shift.getIdShift())
                .toUri();
        return ResponseEntity.created(uriLocation).build();
    }
    @DeleteMapping("/delete/{id}")
    private String deleteShift(@PathVariable Long id){
        return shiftService.deleteShift(id);
    }
    @GetMapping("/shift/{id}")
    private ResponseEntity<ShiftModel> findShiftById(@PathVariable Long id){
        return ResponseEntity.ok(shiftService.findShiftById(id));
    }
    @GetMapping("/shifts")
    private ResponseEntity<List<ShiftModel>> findAllShift(Pageable pageable){
        List<ShiftModel> shiftPage = shiftService.findAllShift(pageable);
        return ResponseEntity.ok(shiftPage);
    }
    @PutMapping("/update-shift")
    private void updateShift(@RequestBody ShiftModel shift){
        shiftService.updateShift(shift);
    }
}

