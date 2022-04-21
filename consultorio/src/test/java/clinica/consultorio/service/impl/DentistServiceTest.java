package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.modelmapper.MappingException;
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
        dentist.setName("Salo");
        dentist.setLicenseNumber(100);
        dentist.setLastName("Morales");

        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(newDentist);



//        try {
//            dentistService.findById(1);
//        } catch (MappingException e){
//            System.out.println(e.getMessage());
//        }

        DentistDTO saloDentist = dentistService.getOdontologoByName("Salo");

        assertNotNull(saloDentist);

        assertNotNull(dentistService.searchById(1));
    }

//    @Test
//    public void update(){
//        DentistDTO dentistDTO = dentistService.findById(1);
//        dentistDTO.setName("nombreCambiado");
//        assertEquals(true, dentistService.update(dentistDTO));
//    }


}