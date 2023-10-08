package ps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ps.dto.CarreraConInscripcionesDTO;
import ps.dto.EstudianteDTO;
import ps.dto.MatricularEstudianteDTO;
import ps.model.Carrera_Estudiante;
import ps.model.Estudiante;
import ps.repository.CarreraRepository;
import ps.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
    private EstudianteRepository repository;
	
    // Obtener todas las carreras
 	@GetMapping
 	public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
 		List<Estudiante> estudiantes = repository.findAll();
 	    List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
 	    
 	    for (Estudiante estudiante : estudiantes) {
 	        estudiantesDTO.add(mapEstudianteToDTO(estudiante));
 	    }
 	    
 	    return estudiantesDTO;
  	}
 	
 	// Obtiene estudiantes ordenados por nombre
  	@GetMapping("/por-nombre")
     public List<EstudianteDTO> obtenerEstudiantesOrdenadosPorNombre() {
  		List<Estudiante> estudiantes = repository.findAllOrderedByName();
  	    List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
  	    
  	    for (Estudiante estudiante : estudiantes) {
  	        estudiantesDTO.add(mapEstudianteToDTO(estudiante));
  	    }
  	    
  	    return estudiantesDTO;
     }
  	
  	// Obtiene estudiante segun numero libreta
  	@GetMapping("/libreta/{numeroLibreta}")
 	public ResponseEntity<EstudianteDTO> obtenerEstudiantePorLibreta(@PathVariable int numeroLibreta) {
  		Estudiante estudiante = repository.findByNumeroLibreta(numeroLibreta);

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
  	    List<Estudiante> estudiantes = repository.findByGenero(genero);

  	    List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
  	    
  	    for (Estudiante estudiante : estudiantes) {
  	        estudiantesDTO.add(mapEstudianteToDTO(estudiante));
  	    }
  	    
  	    return estudiantesDTO;
  	}
  	
  	// Obtiene estudiante segun ID
 	@GetMapping("/{id}")
 	Optional<Estudiante> one(@PathVariable Long id) {
 	    return repository.findById(id);
 	}
 	
 	// Crea un nuevo estudiante
  	@PostMapping
  	public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
  		return repository.save(estudiante);
  	}

 	// Actualiza un estudiante existente por ID
 	@PutMapping("/{id}")
 	public Estudiante actualizarCarrera(@PathVariable Long id, @RequestBody Estudiante carreraActualizada) {
 		carreraActualizada.setId(id);
 		return repository.save(carreraActualizada);
 	}

 	// Elimina un jugador por ID
 	@DeleteMapping("/{id}")
 	public void eliminarJugador(@PathVariable Long id) {
 		repository.deleteById(id);
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
