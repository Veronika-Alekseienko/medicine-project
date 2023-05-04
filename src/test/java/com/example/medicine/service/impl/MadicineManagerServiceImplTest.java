package com.example.medicine.service.impl;

import com.example.medicine.dependencies.MedicineRecordDao;
import com.example.medicine.dependencies.medicineDb.output.MedicineRecord;
import com.example.medicine.service.MedicineManagerService;
import com.example.medicine.service.mapper.MedicineRecordToMedicine;
import com.example.medicine.service.mapper.MedicineToMedicineRecord;
import com.example.medicine.service.output.Medicine;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MadicineManagerServiceImplTest {

    @Mock
    public MedicineRecordDao medicineRecordDao;

    public MedicineManagerService medicineManagerService;

    MedicineRecord mockedMedicineRecord = MedicineRecord.builder()
            .name("Analgin")
            .manufacturer("Ukraine")
            .build();
    Medicine mockedMedicine = Medicine.builder()
            .name("Analgin")
            .manufacturer("Ukraine")
            .build();

    @Before
    public void setUp() {
        medicineManagerService = new MadicineManagerServiceImpl(medicineRecordDao);
    }

    @Test
    public void testParseMedicineToMedicineRecords(){
        MedicineRecord resultMedicineRecord = MedicineToMedicineRecord.from(mockedMedicine);
        MedicineRecord expectedMedicineRecord = mockedMedicineRecord;
        Assertions.assertEquals(expectedMedicineRecord, resultMedicineRecord);
    }

    @Test
    public void testParseMedicineRecordToMedicine(){
        Medicine resultMedicine = MedicineRecordToMedicine.from(mockedMedicineRecord);
        Medicine expectedMedicine = mockedMedicine;
        Assertions.assertEquals(expectedMedicine, resultMedicine);
    }

    @Test
    public void createMedicineInServiceHappyCase() {
        //given
        Mockito.when(medicineRecordDao.save(mockedMedicineRecord)).thenReturn(mockedMedicineRecord);

        // when
        Medicine resultMedicine = medicineManagerService.save(mockedMedicine);
        // then
        Assertions.assertEquals(mockedMedicine, resultMedicine);
        MedicineRecord expectedMedicineRecord = mockedMedicineRecord;
        Mockito.verify(medicineRecordDao).save(expectedMedicineRecord);

    }
}
