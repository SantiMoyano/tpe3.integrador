package ps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ps.model.Carrera;
import ps.model.Carrera_Estudiante;

@Repository
public interface Carrera_EstudianteRepository extends JpaRepository<Carrera_Estudiante, Long>{

	List<Carrera_Estudiante> findByCarrera(Carrera carrera);

}