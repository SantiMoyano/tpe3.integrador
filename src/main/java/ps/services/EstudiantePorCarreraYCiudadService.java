package ps.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ps.dto.EstudiantesPorCarreraYCiudadDTO;
import ps.model.Carrera;
import ps.model.Carrera_Estudiante;
import ps.model.Estudiante;
import ps.repository.CarreraRepository;
import ps.repository.Carrera_EstudianteRepository;
import ps.repository.EstudianteRepository;

@Service
public class EstudiantePorCarreraYCiudadService {
    
    @Autowired
    private CarreraRepository carreraRepository;
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Autowired
    private Carrera_EstudianteRepository carrera_estudianteRepository;
    
    public List<EstudiantesPorCarreraYCiudadDTO> obtenerEstudiantesPorCarreraYCiudad(
            String nombreCarrera, String ciudadResidencia) {
        
    	// Busca carrera con el nombre ingresado
        Carrera carrera = carreraRepository.findByNombre(nombreCarrera);
        
        // Busca estudiantes de ciudad ingresada
        List<Estudiante> estudiantes = estudianteRepository.findByCiudad(ciudadResidencia);
        List<EstudiantesPorCarreraYCiudadDTO> estudiantesDTO = new ArrayList<>();
        
        // Itera sobre los estudiantes para convertirlos en dto
        for (Estudiante estudiante : estudiantes) {
        	// Busca si existe un estudiante de la ciudad ingresada inscripto en la carrera ingresada
            Carrera_Estudiante matricula = carrera_estudianteRepository.findByCarreraAndEstudiante(carrera, estudiante);
            
            if (matricula != null) {
                EstudiantesPorCarreraYCiudadDTO es_dto = new EstudiantesPorCarreraYCiudadDTO();
                es_dto.setNombreEstudiante(estudiante.getNombre());
                es_dto.setApellidoEstudiante(estudiante.getApellido());
                es_dto.setNombreCarrera(carrera.getNombre());
                es_dto.setCiudad(estudiante.getCiudad());
                estudiantesDTO.add(es_dto);
            }
        }
        
        return estudiantesDTO;
    }
}
