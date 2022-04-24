package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.entidades.Dentist;
import clinica.consultorio.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    DentistService dentistService;

    @Test
    public void createDentist() {
        DentistDTO dentist = new DentistDTO();
        {dentist.setName("Leonel");
            dentist.setLicenseNumber(100);
            dentist.setLastName("Fernandez");}
        assertNotNull(dentistService.create(dentist));

//        try {
//            dentistService.findById(1);
//        } catch (MappingException e){
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    public void findDentistById(){
        DentistDTO dentist = new DentistDTO();
        {dentist.setName("Leonel");
        dentist.setLicenseNumber(100);
        dentist.setLastName("Fernandez");}
        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(dentistService.findById(newDentist.getId()));
    }

    @Test
    public void searchDentistById(){
        DentistDTO dentist = new DentistDTO();
        {
            dentist.setName("Leonel");
            dentist.setLicenseNumber(100);
            dentist.setLastName("Fernandez");
        }
        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(dentistService.searchById(newDentist.getId()));
    }

    @Test
    public void deleteDentistById(){
        DentistDTO dentist = new DentistDTO();
        {
            dentist.setName("Leonel");
            dentist.setLicenseNumber(100);
            dentist.setLastName("Fernandez");
        }
        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(newDentist);
        dentistService.deleteById(newDentist.getId());
        assertNull(dentistService.searchById(newDentist.getId()));
    }

    @Test
    public void updateDentist(){
        DentistDTO dentist = new DentistDTO();
        {
            dentist.setName("Leonel");
            dentist.setLicenseNumber(100);
            dentist.setLastName("Fernandez");
        }
        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(newDentist);

        newDentist.setName("Cambio de Nombre Test");
        DentistDTO updateDentist = dentistService.update(newDentist);
        assertEquals("Cambio de Nombre Test",updateDentist.getName());

        assertEquals("Cambio de Nombre Test",dentistService.findById(updateDentist.getId()).getName());
    }

    @Test
    public void findAllDentist(){
        DentistDTO dentist = new DentistDTO();
        {
            dentist.setName("Leonel");
            dentist.setLicenseNumber(100);
            dentist.setLastName("Fernandez");
        }
        dentistService.create(dentist);
        dentistService.create(dentist);
        dentistService.create(dentist);
        Set<DentistDTO> dentist_list = dentistService.findAll();
        System.out.println(dentist_list.size());
        assertTrue(dentist_list.size() > 0);
    }

    @Test
    public void getOdontologoByName(){
        DentistDTO dentist = new DentistDTO();
        {
            dentist.setName("TestNombreBuscar");
            dentist.setLicenseNumber(100);
            dentist.setLastName("TestApellidoBuscar");
        }
        dentistService.create(dentist);
        DentistDTO newDentist = dentistService.getOdontologoByName("TestNombreBuscar");
        assertNotNull(newDentist);
    }

    @Test
    public void isValid(){
        DentistDTO dentist = new DentistDTO();
        {
            dentist.setName("Test isValid");
            dentist.setLicenseNumber(100);
            dentist.setLastName("Test isValid");
        }
        DentistDTO newDentist = dentistService.create(dentist);
        assertTrue(dentistService.isValid(newDentist.getId()));
        assertFalse(dentistService.isValid(-10));
        assertFalse(dentistService.isValid(999999999));
    }

}