package com.example.medicine;

import com.example.medicine.controller.restapi.MedicineRecordController;
import com.example.medicine.controller.restapi.mapper.MedicineRecordDtoMapper;
import com.example.medicine.controller.restapi.output.ResponseMedicineRecordDto;
import com.example.medicine.service.MedicineManagerService;
import com.example.medicine.service.output.Medicine;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MedicineRecordControllerTest {
    @Mock
    public MedicineManagerService medicineManagerService;

    @Mock
    public MedicineRecordDtoMapper mapper;

    public MockMvc mvc;

    @InjectMocks
    private MedicineRecordController medicineRecordController;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(medicineRecordController).build();
    }

    public String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void createMedicine() throws Exception {
        String uri = "/records";
        Medicine medicine = Medicine.builder()
                .name("Paracetamol")
                .manufacturer("Netherlands")
                .dateOfManufacture(LocalDate.of(2023, 3, 15))
                .expiryDate(LocalDate.of(2024, 12, 12))
                .build();
        Mockito.when(mapper.mapToResponse(Mockito.any(Medicine.class))).thenReturn(new ResponseMedicineRecordDto());
        Mockito.when(medicineManagerService.save(Mockito.any(Medicine.class))).thenReturn(medicine);
        mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(medicine)))
                .andExpect(status().isOk());
    }
}
