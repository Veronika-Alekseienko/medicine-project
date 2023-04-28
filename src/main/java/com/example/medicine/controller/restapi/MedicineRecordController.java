package com.example.medicine.controller.restapi;

import application.controller.restapi.input.RequestMedicineRecordDto;
import application.controller.restapi.mapper.MedicineRecordDtoMapper;
import application.controller.restapi.output.ResponseMedicineRecordDto;
import application.service.MedicineManagerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/records")
public class MedicineRecordController {
    private final MedicineManagerService medicineManagerService;
    private final MedicineRecordDtoMapper mapper;

    public MedicineRecordController(MedicineManagerService medicineManagerService, MedicineRecordDtoMapper mapper) {
        this.medicineManagerService = medicineManagerService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseMedicineRecordDto create (@RequestBody RequestMedicineRecordDto requestMedicineRecordDto) {
        return mapper.mapToResponse(medicineManagerService.save(mapper.mapToMedicine(requestMedicineRecordDto)));
    }

}
