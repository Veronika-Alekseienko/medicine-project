package com.example.medicine.controller.restapi;

import com.example.medicine.controller.restapi.input.RequestMedicineRecordDto;
import com.example.medicine.controller.restapi.mapper.MedicineRecordDtoMapper;
import com.example.medicine.controller.restapi.output.ResponseMedicineRecordDto;
import com.example.medicine.service.MedicineManagerService;
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
