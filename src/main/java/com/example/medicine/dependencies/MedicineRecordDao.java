package com.example.medicine.dependencies;

import com.example.medicine.dependencies.medicineDb.output.MedicineRecord;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRecordDao extends CrudRepository<MedicineRecord, Integer> {

}
