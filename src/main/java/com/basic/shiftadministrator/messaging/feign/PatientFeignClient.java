package com.basic.shiftadministrator.messaging.feign;

import com.basic.shiftadministrator.model.response.PatientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "patients", url = "http://localhost:9001")
public interface PatientFeignClient {

    @GetMapping("/patient-manager/patient/dni/{dni}")
    PatientModel getPatientByDni(@PathVariable String dni);
}
