package ps.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ps.dto.ReporteCarreraDTO;
import ps.model.Carrera;
import ps.model.Carrera_Estudiante;
import ps.repository.CarreraRepository;
import ps.repository.Carrera_EstudianteRepository;

@Service
public class ReporteService {
	
	@Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private Carrera_EstudianteRepository carreraEstudianteRepository;

    public List<ReporteCarreraDTO> generarReporteCarreras() {
        List<ReporteCarreraDTO> reporteCarreras = new ArrayList<>();

        // Obtiene la lista de carreras ordenada alfabéticamente
        List<Carrera> carreras = carreraRepository.findAllByOrderByNombreAsc();

        // Itera por cada carrera y obtiene la información de inscritos y egresados por año
        for (Carrera carrera : carreras) {
            ReporteCarreraDTO reporteCarrera = new ReporteCarreraDTO();
            reporteCarrera.setNombreCarrera(carrera.getNombre());

            // Busca las inscripciones de la carrera
            List<Carrera_Estudiante> matriculas = carreraEstudianteRepository.findByCarrera(carrera);

            Map<Integer, Integer> inscritosPorAnio = new HashMap<>();
            Map<Integer, Integer> egresadosPorAnio = new HashMap<>();

            // Por cada inscripcion le suma uno a inscriptos o egresados por anio
            for (Carrera_Estudiante matricula : matriculas) {
                int anioIngreso = matricula.getIngreso().getYear();
                inscritosPorAnio.put(anioIngreso, inscritosPorAnio.getOrDefault(anioIngreso, 0) + 1);

                LocalDate egreso = matricula.getEgreso();
                if (egreso != null) {
                    int anioEgreso = egreso.getYear();
                    egresadosPorAnio.put(anioEgreso, egresadosPorAnio.getOrDefault(anioEgreso, 0) + 1);
                }
            }

            reporteCarrera.setInscritosPorAnio(inscritosPorAnio);
            reporteCarrera.setEgresadosPorAnio(egresadosPorAnio);

            // Agrega info de la carrera al reporte
            reporteCarreras.add(reporteCarrera);
        }

        return reporteCarreras;
    }
}
