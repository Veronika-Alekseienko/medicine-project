package com.example.medicine.controller.restapi.input;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RequestMedicineRecordDto {
    private String name;
    private String manufarturer;
    private LocalDate dateOfManufacture;
    private LocalDate expiryDate;
    private boolean verified;
    private LocalDate dateOfEntryToDatabase;
}
