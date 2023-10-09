package ps.dto;

import java.util.HashMap;
import java.util.Map;

public class ReporteCarreraDTO {

    private String nombreCarrera;
    private Map<Integer, Integer> inscritosPorAnio;
    private Map<Integer, Integer> egresadosPorAnio;

    // Constructores, getters y setters

    public ReporteCarreraDTO() {
        inscritosPorAnio = new HashMap<>();
        egresadosPorAnio = new HashMap<>();
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Map<Integer, Integer> getInscritosPorAnio() {
        return inscritosPorAnio;
    }

    public void setInscritosPorAnio(Map<Integer, Integer> inscritosPorAnio) {
        this.inscritosPorAnio = inscritosPorAnio;
    }

    public Map<Integer, Integer> getEgresadosPorAnio() {
        return egresadosPorAnio;
    }

    public void setEgresadosPorAnio(Map<Integer, Integer> egresadosPorAnio) {
        this.egresadosPorAnio = egresadosPorAnio;
    }
}
