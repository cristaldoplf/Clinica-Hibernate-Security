package clinica.consultorio.service;

import clinica.consultorio.dto.DentistDTO;


public interface IDentistService extends ICRUDService<DentistDTO>{

    DentistDTO getOdontologoByName(String name);
    DentistDTO searchById(Integer id);
    boolean isValid(Integer id);
}
