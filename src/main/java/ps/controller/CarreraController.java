package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ps.model.*;
import ps.repository.*;
import java.util.List;

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
 	
 	
// 	// Obtener un jugador por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Carrera> obtenerCarreraPorId(@PathVariable Long id) {
//        java.util.Optional<Carrera> carrera1 = carreraRepository.findById(id);
//        if (carrera1.isPresent()) {
//            return ResponseEntity.ok(carrera1.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
// 	// Actualizar un jugador existente por ID
// 	@PutMapping("/{id}")
// 	public Jugador actualizarJugador(@PathVariable Long id, @RequestBody Jugador jugadorActualizado) {
// 		jugadorActualizado.setId(id);
// 		return jugadorRepository.save(jugadorActualizado);
// 	}
//
// 	// Eliminar un jugador por ID
// 	@DeleteMapping("/{id}")
// 	public void eliminarJugador(@PathVariable Long id) {
// 		jugadorRepository.deleteById(id);
// 	}
//
// 	// Obtener jugadores con valor mayor a 1,000,000
// 	@GetMapping("/valor-mayor")
// 	public List<Jugador> obtenerJugadoresConValorMayor() {
// 		// return jugadorRepository.findByValorGreaterThan(1000000);
// 		// return jugadorRepository.findJugadoresPorPosicion("Delantero");
// 		return jugadorRepository.findJugadoresConValorMayorQue(1000000);
// 	}
}
