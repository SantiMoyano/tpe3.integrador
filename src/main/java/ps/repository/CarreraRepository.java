package ps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ps.model.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>{
		
		
}
