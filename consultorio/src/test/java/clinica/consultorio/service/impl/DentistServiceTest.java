package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService dentistService;

    @Test
    public void createDentistTest() {
        DentistDTO dentist = new DentistDTO();
        dentist.setName("TestCrearDentista1");
        dentist.setLicenseNumber(100);
        dentist.setLastName("ApellidoDentistTest1");

        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(newDentist);
        System.out.println(newDentist.getId());

//        assertNotNull(dentistService.findById(newDentist.getId()));
    }
}