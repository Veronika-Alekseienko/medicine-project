package com.example.medicine.controller.restapi.mapper;

import com.example.medicine.controller.restapi.input.RequestMedicineRecordDto;
import com.example.medicine.controller.restapi.output.ResponseMedicineRecordDto;
import com.example.medicine.service.output.Medicine;
import org.springframework.stereotype.Component;

@Component
public class MedicineRecordDtoMapper {
    public ResponseMedicineRecordDto mapToResponse(Medicine medicine) {
        ResponseMedicineRecordDto responseDto = new ResponseMedicineRecordDto();
        responseDto.setId(medicine.getId());
        responseDto.setName(medicine.getName());
        responseDto.setManufacturer(medicine.getManufacturer());
        responseDto.setDateOfManufacture(medicine.getDateOfManufacture());
        responseDto.setExpiryDate(medicine.getExpiryDate());
        return responseDto;
    }

    public Medicine mapToMedicine(RequestMedicineRecordDto requestDto) {
        Medicine medicine = new Medicine();
        medicine.setName(requestDto.getName());
        medicine.setManufacturer(requestDto.getManufarturer());
        medicine.setDateOfManufacture(requestDto.getDateOfManufacture());
        medicine.setExpiryDate(requestDto.getExpiryDate());
        return medicine;
    }
}
