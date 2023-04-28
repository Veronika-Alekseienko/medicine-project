package com.example.medicine.service.mapper;

import application.dependencies.medicineDb.output.MedicineRecord;
import application.service.output.Medicine;

public class MedicineToMedicineRecord {
    public static MedicineRecord from(Medicine medicine) {
        return MedicineRecord.builder()
                .name(medicine.getName())
                .manufacturer(medicine.getManufacturer())
                .dateOfManufacture(medicine.getDateOfManufacture())
                .expiryDate(medicine.getExpiryDate())
                .build();
    }
}
