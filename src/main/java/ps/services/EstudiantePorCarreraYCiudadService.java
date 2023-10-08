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
        
        Carrera carrera = carreraRepository.findByNombre(nombreCarrera);
        List<Estudiante> estudiantes = estudianteRepository.findByCiudad(ciudadResidencia);
        
        List<EstudiantesPorCarreraYCiudadDTO> estudiantesDTO = new ArrayList<>();
        
        for (Estudiante estudiante : estudiantes) {
            Carrera_Estudiante matricula = carrera_estudianteRepository.findByCarreraAndEstudiante(carrera, estudiante);
            
            if (matricula != null) {
                EstudiantesPorCarreraYCiudadDTO es_dto = new EstudiantesPorCarreraYCiudadDTO();
                es_dto.setNombreEstudiante(estudiante.getNombre());
                es_dto.setApellidoEstudiante(estudiante.getApellido());
                es_dto.setNombreCarrera(carrera.getNombre());
                estudiantesDTO.add(es_dto);
            }
        }
        
        return estudiantesDTO;
    }
}
