package com.example.medicine.service.mapper;

import application.dependencies.medicineDb.output.MedicineRecord;

public class MedicineRecordToMedicine {
    public static application.service.output.Medicine from (MedicineRecord medicineRecord) {
        return application.service.output.Medicine.builder()
                .name(medicineRecord.getName())
                .manufacturer(medicineRecord.getManufacturer())
                .dateOfManufacture(medicineRecord.getDateOfManufacture())
                .expiryDate(medicineRecord.getExpiryDate())
                .build();
    }
}
