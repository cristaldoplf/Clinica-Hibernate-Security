package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.entidades.Dentist;
import clinica.consultorio.service.IDentistService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class DentistServiceTest {

    private DentistDTO dentist;


    @BeforeEach
    public void prepararTest() {
        dentist = new DentistDTO();
        dentist.setName("Leonel");
        dentist.setLicenseNumber(100);
        dentist.setLastName("Fernandez");
        dentist = dentistService.create(dentist);
    }

    @Autowired
    DentistService dentistService;

    @Test
    public void createDentist() {
        DentistDTO dentistCreated = new DentistDTO();
        {
            dentistCreated.setName("Test");
            dentistCreated.setLicenseNumber(100);
            dentistCreated.setLastName("Fernandez");
        }
        assertNotNull(dentistService.create(dentistCreated));

//        try {
//            dentistService.findById(1);
//        } catch (MappingException e){
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    public void findDentistById() {
        assertNotNull(dentistService.findById(dentist.getId()));
    }

    @Test
    public void searchDentistById() {
        assertNotNull(dentistService.searchById(dentist.getId()));
    }

    @Test
    public void deleteDentistById() {
        System.out.println(dentist.getId());
        System.out.println("------------");
        dentistService.deleteById(dentist.getId());
        assertNull(dentistService.searchById(dentist.getId()));
    }

    @Test
    public void updateDentist() {
        dentist.setName("Cambio de Nombre Test");
        DentistDTO updateDentist = dentistService.update(dentist);
        assertEquals("Cambio de Nombre Test", updateDentist.getName());
        assertEquals("Cambio de Nombre Test", dentistService.findById(updateDentist.getId()).getName());
    }

    @Test
    public void findAllDentist() {
        Set<DentistDTO> dentist_list = dentistService.findAll();
        assertTrue(dentist_list.size() > 0);
//        dentistService.create(dentist);
//        dentistService.create(dentist);
//        dentistService.create(dentist);
//        for (DentistDTO dent:dentist_list) {
//            System.out.println(dent.getName()+" "+dent.getLastName()+" "+dent.getId()+" "+dent.getLicenseNumber());
//        }
//        assertTrue(dentist_list.contains(dentist));
//        try {
//            assertTrue(dentist_list.contains(dentistToSearchAtList));
//        }catch (MappingException e){
//            System.out.println(e.getCause().getMessage());
//        }


    }

    @Test
    public void getOdontologoByName() {
        DentistDTO newDentist = dentistService.getOdontologoByName("Leonel");
        assertNotNull(newDentist);
        assertEquals("Leonel", newDentist.getName());
    }

    @Test
    public void isValid() {
        assertTrue(dentistService.isValid(dentist.getId()));
        assertFalse(dentistService.isValid(-10));
        assertFalse(dentistService.isValid(999999999));
    }

}