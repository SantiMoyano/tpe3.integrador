package ps.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ps.dto.CarreraConInscripcionesDTO;
import ps.model.Carrera;
import ps.model.Carrera_Estudiante;
import ps.repository.CarreraRepository;
import ps.repository.Carrera_EstudianteRepository;

@Service
public class CarrerasMasInscriptasService {
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private Carrera_EstudianteRepository matriculaRepository;

	// Obtiene las carreras con mas inscriptos
	public List<CarreraConInscripcionesDTO> obtenerCarreras() {
		List<Carrera> carreras = carreraRepository.findAll();
  	    List<CarreraConInscripcionesDTO> carrerasConEstudiantes = new ArrayList<>();
  	    
  	    for (Carrera carrera : carreras) {
  	    	// Busca las inscripciones a esa carrera
  	        List<Carrera_Estudiante> inscripciones = matriculaRepository.findByCarrera(carrera);
 
  	        CarreraConInscripcionesDTO carreraDTO = new CarreraConInscripcionesDTO();
  	        carreraDTO.setNombre(carrera.getNombre());
  	        carreraDTO.setCantidadInscritos(inscripciones.size());
  	        
  	        carrerasConEstudiantes.add(carreraDTO);
  	    }
  	    
  	    // Ordena la lista de carreras por la cantidad de inscritos
  	    carrerasConEstudiantes.sort((c1, c2) -> Integer.compare(c2.getCantidadInscritos(), c1.getCantidadInscritos()));
  	    
  	    return carrerasConEstudiantes;
	}
}
