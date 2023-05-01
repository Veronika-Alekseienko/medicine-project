package com.example.medicine.service.mapper;

import com.example.medicine.dependencies.medicineDb.output.MedicineRecord;
import com.example.medicine.service.output.Medicine;

public class MedicineRecordToMedicine {
    public static Medicine from (MedicineRecord medicineRecord) {
        return Medicine.builder()
                .name(medicineRecord.getName())
                .manufacturer(medicineRecord.getManufacturer())
                .dateOfManufacture(medicineRecord.getDateOfManufacture())
                .expiryDate(medicineRecord.getExpiryDate())
                .build();
    }
}
