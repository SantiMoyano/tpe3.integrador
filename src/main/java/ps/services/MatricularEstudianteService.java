package ps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ps.dto.MatricularEstudianteDTO;
import ps.model.Carrera;
import ps.model.Carrera_Estudiante;
import ps.model.Estudiante;
import ps.repository.CarreraRepository;
import ps.repository.Carrera_EstudianteRepository;
import ps.repository.EstudianteRepository;

@Service
public class MatricularEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private Carrera_EstudianteRepository matriculaRepository;

    public void crearMatricula(MatricularEstudianteDTO request) {
        // Obtiene las instancias de Estudiante y Carrera a partir de los IDs
        Estudiante estudiante = estudianteRepository.findById(request.getEstudianteId())
        		.orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + request.getEstudianteId()));

        Carrera carrera = carreraRepository.findById(request.getCarreraId())
        		.orElseThrow(() -> new RuntimeException("Carrera no encontrada con ID: " + request.getCarreraId()));
        
        if (estudiante != null && carrera != null) {
        	// Crea la matrícula con las instancias de Estudiante y Carrera
            Carrera_Estudiante matricula = new Carrera_Estudiante(estudiante, carrera, request.getIngreso(), request.getEgreso());
            
            // Guarda la matrícula en la base de datos
            matriculaRepository.save(matricula);
        }
    }
}

