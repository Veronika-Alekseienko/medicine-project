package com.example.medicine.service.impl;

import com.example.medicine.dependencies.MedicineRecordDao;
import com.example.medicine.dependencies.medicineDb.output.MedicineRecord;
import com.example.medicine.service.MedicineManagerService;
import com.example.medicine.service.mapper.MedicineRecordToMedicine;
import com.example.medicine.service.mapper.MedicineToMedicineRecord;
import com.example.medicine.service.output.Medicine;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MadicineManagerServiceImpl implements MedicineManagerService {
    private final MedicineRecordDao medicineRecordDao;

    public MadicineManagerServiceImpl(MedicineRecordDao medicineRecordDao) {
        this.medicineRecordDao = medicineRecordDao;
    }

    @Override
    public Medicine save(@NonNull Medicine medicine) {
        MedicineRecord medicineRecord = MedicineToMedicineRecord.from(medicine);
        MedicineRecord savedMedicineRecord = medicineRecordDao.save(medicineRecord);
        Medicine savedMedicine = MedicineRecordToMedicine.from(savedMedicineRecord);
        return savedMedicine;
    }
}
