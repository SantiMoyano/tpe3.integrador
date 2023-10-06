package ps.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 	public List<Estudiante> obtenerTodasLasCarreras() {
 		return repository.findAll();
 	}
 	
 	// Crear una nueva carrera
  	@PostMapping
  	public Estudiante crearCarrera(@RequestBody Estudiante estudiante) {
  		return repository.save(estudiante);
  	}
  	
  	// Obtiene carrera segun ID
	@GetMapping("/{id}")
	Optional<Estudiante> one(@PathVariable Long id) {
	    return repository.findById(id);
	}

 	// Actualiza un jugador existente por ID
 	@PutMapping("/{id}")
 	public Estudiante actualizarCarrera(@PathVariable Long id, @RequestBody Estudiante carreraActualizada) {
 		carreraActualizada.setId(id);
 		return repository.save(carreraActualizada);
 	}

 	// Eliminar un jugador por ID
 	@DeleteMapping("/{id}")
 	public void eliminarJugador(@PathVariable Long id) {
 		repository.deleteById(id);
 	}
}
