package clinica.consultorio.service.impl;

import clinica.consultorio.dto.AdressDTO;
import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.entidades.Adress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class PatientServiceTest {

    private PatientDTO patient;
    private Adress adress;
    private PatientDTO patientToTest;

    @Autowired
    PatientService patientService;

    @BeforeEach
    public void prepareTest() {
        patient = new PatientDTO();
        patient.setLastname("Pablo");
        patient.setName("Cristaldo");
        patient.setEmail("test@test.com");
        patient.setDni(11111111);
        patient.setAdmissionDate(LocalDate.of(2005, 8, 25));

        adress = new Adress();
        adress.setStreet("9 de julio");
        adress.setProvince("Buenos Aires");
        adress.setTown("San Cristobal");
        adress.setAdressNumber("1500 3A");

        patient.setAdress(adress);

        patientToTest = patientService.create(patient);
    }

    @Test
    public void createPatient() {
        PatientDTO patientTest = new PatientDTO();
        patientTest.setLastname("TestCreate");
        patientTest.setName("TestCreate");
        patientTest.setEmail("TestCreate");
        patientTest.setDni(11111111);
        patientTest.setAdmissionDate(LocalDate.of(2005, 8, 25));

        Adress adressTest = new Adress();
        adressTest.setStreet("TestCreate");
        adressTest.setProvince("TestCreate");
        adressTest.setTown("TestCreate");
        adressTest.setAdressNumber("TestCreate");

        PatientDTO patientToCheck = patientService.create(patientTest);
        assertNotNull(patientToCheck);
    }

    @Test
    public void findById() {
        assertNotNull(patientService.findById(patientToTest.getId()));
    }

    @Test
    public void deleteById() {
        patientService.deleteById(patientToTest.getId());
        assertThrows(NoSuchElementException.class, () -> {
            patientService.findById(patientToTest.getId());
        });
    }

    @Test
    public void update() {
        patientToTest.setEmail("email cambio test");
        patientService.update(patientToTest);
        assertEquals("email cambio test", patientService.findById(patientToTest.getId()).getEmail());
    }

}

