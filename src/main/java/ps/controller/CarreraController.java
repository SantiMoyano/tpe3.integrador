package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ps.dto.CarreraConInscripcionesDTO;
import ps.dto.CarreraDTO;
import ps.model.*;
import ps.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
	
    @Autowired
    private CarreraRepository carreraRepository;
    
    @Autowired
    private Carrera_EstudianteRepository matriculaRepository;
    
    // Obtener todas las carreras
 	@GetMapping
 	public List<CarreraDTO> obtenerTodasLasCarreras() {
 		List<Carrera> carreras = carreraRepository.findAll();
 		List<CarreraDTO> carrerasDTO = new ArrayList<>();
 		
 		for (Carrera carrera: carreras) {
 			CarreraDTO carreraDTO = new CarreraDTO();
 			carreraDTO.setNombre(carrera.getNombre());
 			carrerasDTO.add(carreraDTO);
 		}
 		
 		return carrerasDTO;
 	}
 	
 	@GetMapping("/carreras-con-estudiantes")
  	public List<CarreraConInscripcionesDTO> obtenerCarrerasConEstudiantes() {
  	    List<Carrera> carreras = carreraRepository.findAll();
  	    List<CarreraConInscripcionesDTO> carrerasConEstudiantes = new ArrayList<>();
  	    
  	    for (Carrera carrera : carreras) {
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
 	
 	// Crear una nueva carrera
  	@PostMapping
  	public Carrera crearCarrera(@RequestBody Carrera carrera) {
  		return carreraRepository.save(carrera);
  	}
  	
  	// Obtiene carrera segun ID
	@GetMapping("/{id}")
	Optional<Carrera> one(@PathVariable Long id) {
	    return carreraRepository.findById(id);
	}

 	// Actualiza un jugador existente por ID
 	@PutMapping("/{id}")
 	public Carrera actualizarCarrera(@PathVariable Long id, @RequestBody Carrera carreraActualizada) {
 		carreraActualizada.setId(id);
 		return carreraRepository.save(carreraActualizada);
 	}

 	// Eliminar un jugador por ID
 	@DeleteMapping("/{id}")
 	public void eliminarJugador(@PathVariable Long id) {
 		carreraRepository.deleteById(id);
 	}

}
