package com.example.medicine.service.mapper;

import com.example.medicine.dependencies.medicineDb.output.MedicineRecord;
import com.example.medicine.service.output.Medicine;

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
