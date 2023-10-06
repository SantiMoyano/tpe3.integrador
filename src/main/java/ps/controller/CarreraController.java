package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ps.model.*;
import ps.repository.*;
import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraController {
	
    @Autowired
    private CarreraRepository carreraRepository;
    
    // Obtener todas las carreras
 	@GetMapping
 	public String obtenerTodasLasCarreras() {
 		return "arbol";
 	}

// 	// Crear un nuevo jugador
// 	@PostMapping
// 	public Jugador crearJugador(@RequestBody Jugador jugador) {
// 		return jugadorRepository.save(jugador);
// 	}
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
