package com.example.medicine.controller.restapi.output;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseMedicineRecordDto {
    private Long id;
    private String name;
    private String manufarturer;
    private LocalDate dateOfManufacture;
    private LocalDate expiryDate;
    private boolean verificationStatus;
    private LocalDate dateOfEntryToDatabase;
}
