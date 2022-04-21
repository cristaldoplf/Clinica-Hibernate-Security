package clinica.consultorio.repositorio;

import clinica.consultorio.entidades.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Integer> {

//    @Query("FROM Dentist o WHERE o.name = :name")
//    Dentist getDentistByName(@Param("name") String name);

    @Query("FROM Dentist o WHERE o.id = :id")
    Dentist searchById(@Param("id") Integer id);

    public Dentist findDentistByName(String nombre);
//    public void deleteByName(String nombre);
    //find+NombreClase+By+NombreAtributo
}
