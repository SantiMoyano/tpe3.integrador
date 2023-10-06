package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ps.model.*;
import ps.repository.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
	
    @Autowired
    private CarreraRepository carreraRepository;
    
    // Obtener todas las carreras
 	@GetMapping
 	public List<Carrera> obtenerTodasLasCarreras() {
 		return carreraRepository.findAll();
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
//
// 	// Obtener jugadores con valor mayor a 1,000,000
// 	@GetMapping("/valor-mayor")
// 	public List<Jugador> obtenerJugadoresConValorMayor() {
// 		// return jugadorRepository.findByValorGreaterThan(1000000);
// 		// return jugadorRepository.findJugadoresPorPosicion("Delantero");
// 		return jugadorRepository.findJugadoresConValorMayorQue(1000000);
// 	}
}
