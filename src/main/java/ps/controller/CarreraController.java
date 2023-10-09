package ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ps.dto.CarreraConInscripcionesDTO;
import ps.dto.CarreraDTO;
import ps.dto.ReporteCarreraDTO;
import ps.model.*;
import ps.repository.*;
import ps.services.CarrerasMasInscriptasService;
import ps.services.ReporteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
	
    @Autowired
    private CarreraRepository carreraRepository;
    
    @Autowired
	private ReporteService reporteService;
    
    @Autowired
	private CarrerasMasInscriptasService carrerasMasInscriptasService;
    
    // Obtiene todas las carreras
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
 	
 	// Obtiene las carreras con mas inscriptos ordenadas de mayor a menor
 	@GetMapping("/carreras-con-estudiantes")
  	public List<CarreraConInscripcionesDTO> obtenerCarrerasConEstudiantes() {
  	    List<CarreraConInscripcionesDTO> carreras = carrerasMasInscriptasService.obtenerCarreras();
  	    return carreras;
  	}
 	
 	// Obtiene reporte de las carreras 
 	@GetMapping("/reporte")
	public List<ReporteCarreraDTO> reporteCarreras() {
		List<ReporteCarreraDTO> reporte = reporteService.generarReporteCarreras();
		return reporte;
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
