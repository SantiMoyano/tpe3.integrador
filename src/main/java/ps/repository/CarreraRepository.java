package ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer>{
		
		
}
