package com.example.medicine.service.impl;

import application.dependencies.MedicineRecordDao;
import application.dependencies.medicineDb.output.MedicineRecord;
import application.service.MedicineManagerService;
import application.service.mapper.MedicineRecordToMedicine;
import application.service.mapper.MedicineToMedicineRecord;
import application.service.output.Medicine;
import org.springframework.stereotype.Service;

@Service
public class MadicineManagerServiceImpl implements MedicineManagerService {
    private final MedicineRecordDao medicineRecordDao;

    public MadicineManagerServiceImpl(MedicineRecordDao medicineRecordDao) {
        this.medicineRecordDao = medicineRecordDao;
    }

    @Override
    public Medicine save(Medicine medicineRecord) {
         return MedicineRecordToMedicine.from(medicineRecordDao.save(MedicineToMedicineRecord.from(medicineRecord)));
    }
}
