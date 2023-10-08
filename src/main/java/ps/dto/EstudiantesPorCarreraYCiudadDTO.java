package ps.dto;

public class EstudiantesPorCarreraYCiudadDTO {

	private String nombreEstudiante;
	private String apellidoEstudiante;
	private String nombreCarrera;
	public EstudiantesPorCarreraYCiudadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstudiantesPorCarreraYCiudadDTO(String nombreEstudiante, String apellidoEstudiante, String nombreCarrera) {
		super();
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.nombreCarrera = nombreCarrera;
	}
	
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	
	public String getApellidoEstudiante() {
		return apellidoEstudiante;
	}
	
	public void setApellidoEstudiante(String apellidoEstudiante) {
		this.apellidoEstudiante = apellidoEstudiante;
	}
	
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
}
