package ps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ps.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>{

	Carrera findByNombre(String nombreCarrera);

	List<Carrera> findAllByOrderByNombreAsc();
		
		
}
