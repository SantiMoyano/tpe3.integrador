package ps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ps.model.Carrera;
import ps.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

	@Query("SELECT e FROM Estudiante e ORDER BY e.nombre ASC")
    List<Estudiante> findAllOrderedByName();
	
	Estudiante findByNumeroLibreta(int numeroLibreta);

	List<Estudiante> findByGenero(String genero);

	List<Estudiante> findByCiudad(String ciudad);
}
