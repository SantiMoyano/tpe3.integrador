package ps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ps.dto.EstudianteDTO;
import ps.dto.EstudiantesPorCarreraYCiudadDTO;
import ps.model.Estudiante;
import ps.repository.EstudianteRepository;
import ps.services.EstudiantePorCarreraYCiudadService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
    private EstudianteRepository estudianteRepository;
	
	@Autowired 
	private EstudiantePorCarreraYCiudadService estudianteService;
	
    // Obtener todos los estudiantes como DTO
 	@GetMapping
 	public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
 		List<Estudiante> estudiantes = estudianteRepository.findAll();
 	    List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
 	    
 	    for (Estudiante estudiante : estudiantes) {
 	        estudiantesDTO.add(mapEstudianteToDTO(estudiante));
 	    }
 	    
 	    return estudiantesDTO;
  	}
 	
 	// Obtiene estudiantes ordenados por nombre como DTO
  	@GetMapping("/por-nombre")
     public List<EstudianteDTO> obtenerEstudiantesOrdenadosPorNombre() {
  		List<Estudiante> estudiantes = estudianteRepository.findAllOrderedByName();
  		
  		//Convierte a DTO
  	    List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
  	    
  	    for (Estudiante estudiante : estudiantes) {
  	        estudiantesDTO.add(mapEstudianteToDTO(estudiante));
  	    }
  	    
  	    return estudiantesDTO;
     }
  	
  	// Obtiene estudiante segun numero libreta
  	@GetMapping("/libreta/{numeroLibreta}")
 	public ResponseEntity<EstudianteDTO> obtenerEstudiantePorLibreta(@PathVariable int numeroLibreta) {
  		Estudiante estudiante = estudianteRepository.findByNumeroLibreta(numeroLibreta);

  	    if (estudiante != null) {
  	        EstudianteDTO estudianteDTO = mapEstudianteToDTO(estudiante);
  	        return ResponseEntity.ok(estudianteDTO);
  	    } else {
  	        return ResponseEntity.notFound().build(); // Estudiante no encontrado
  	    }
 	}
  	
  	// Obtiene estudiantes segun genero
  	@GetMapping("/genero/{genero}")
  	public List<EstudianteDTO> obtenerEstudiantesPorGenero(@PathVariable String genero) {
  	    List<Estudiante> estudiantes = estudianteRepository.findByGenero(genero);
  	    List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
  	    
  	    for (Estudiante estudiante : estudiantes) {
  	        estudiantesDTO.add(mapEstudianteToDTO(estudiante));
  	    }
  	    
  	    return estudiantesDTO;
  	}
  	
  	// Obtiene estudiante segun ID
 	@GetMapping("/{id}")
 	Optional<Estudiante> one(@PathVariable Long id) {
 	    return estudianteRepository.findById(id);
 	}
 	
 	// Obtiene estudiantes segun carrera y ciudad
 	@GetMapping("/carrera-ciudad/{carrera}/{ciudad}")
 	public List<EstudiantesPorCarreraYCiudadDTO> obtenerEstudiantesPorCarreraYCiudad(
 			@PathVariable("carrera") String nombreCarrera,
 	        @PathVariable("ciudad") String ciudadResidencia) {
 	    
 	    return estudianteService.obtenerEstudiantesPorCarreraYCiudad(nombreCarrera, ciudadResidencia);
 	}  
 	
 	// Crea un nuevo estudiante
  	@PostMapping
  	public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
  		return estudianteRepository.save(estudiante);
  	}

 	// Actualiza un estudiante existente por ID
 	@PutMapping("/{id}")
 	public Estudiante actualizarCarrera(@PathVariable Long id, @RequestBody Estudiante carreraActualizada) {
 		carreraActualizada.setId(id);
 		return estudianteRepository.save(carreraActualizada);
 	}

 	// Elimina un jugador por ID
 	@DeleteMapping("/{id}")
 	public void eliminarJugador(@PathVariable Long id) {
 		estudianteRepository.deleteById(id);
 	}
 	
 	// Metodo para convertir entidad estudiante a DTO
 	private EstudianteDTO mapEstudianteToDTO(Estudiante estudiante) {
	    EstudianteDTO dto = new EstudianteDTO();
	    dto.setId(estudiante.getId());
	    dto.setDni(estudiante.getDni());
	    dto.setNombre(estudiante.getNombre());
	    dto.setApellido(estudiante.getApellido());
	    dto.setCiudad(estudiante.getCiudad());
	    dto.setEdad(estudiante.getEdad());
	    dto.setGenero(estudiante.getGenero());
	    dto.setNumeroLibreta(estudiante.getNumeroLibreta());
	    return dto;
	}
}
