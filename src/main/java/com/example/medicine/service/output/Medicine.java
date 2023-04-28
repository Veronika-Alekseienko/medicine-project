package com.example.medicine.service.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private Long id;
    private String name;
    private String manufacturer;
    private LocalDate dateOfManufacture;
    private LocalDate expiryDate;
}
