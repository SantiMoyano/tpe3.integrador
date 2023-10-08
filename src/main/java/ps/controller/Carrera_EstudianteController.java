package ps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ps.model.Carrera_Estudiante;
import ps.repository.Carrera_EstudianteRepository;
import ps.services.MatricularEstudianteService;
import ps.dto.MatricularEstudianteDTO;

@RestController
@RequestMapping("/matricular")
public class Carrera_EstudianteController {
	
	@Autowired
    private Carrera_EstudianteRepository repository;
	
    @Autowired
    private MatricularEstudianteService matricularEstudianteService;

    // Obtener todas las matriculaciones
 	@GetMapping
 	public List<MatricularEstudianteDTO> obtenerTodasLasMatriculas() {
 	   List<Carrera_Estudiante> matriculas = repository.findAll();
 	   List<MatricularEstudianteDTO> matriculasDTO = new ArrayList<>();
 	   
 	   for (Carrera_Estudiante matricula : matriculas) {
 		  MatricularEstudianteDTO dto = new MatricularEstudianteDTO();
 	        dto.setId(matricula.getId());
 	        dto.setCarreraId(matricula.getCarrera().getId());
 	        dto.setEstudianteId(matricula.getEstudiante().getId());
 	        dto.setIngreso(matricula.getIngreso());
 	        dto.setEgreso(matricula.getEgreso());
 	        matriculasDTO.add(dto);
 	    }
 
 	    return matriculasDTO;
 	}
 	
 	// Crear una nueva carrera
  	@PostMapping
  	public ResponseEntity<String> crearMatricula(@RequestBody MatricularEstudianteDTO request) {
  		try {
  			matricularEstudianteService.crearMatricula(request);
  	        return ResponseEntity.ok("Matrícula creada correctamente.");
  	    } catch (Exception e) {
  	        return ResponseEntity.badRequest().body("Error al crear la matrícula: " + e.getMessage());
  	    }
    }
  	
  	
}
