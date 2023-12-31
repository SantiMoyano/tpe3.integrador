package ps.dto;

public class EstudiantesPorCarreraYCiudadDTO {

	private String nombreEstudiante;
	private String apellidoEstudiante;
	private String nombreCarrera;
	private String ciudad;
	
	public EstudiantesPorCarreraYCiudadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstudiantesPorCarreraYCiudadDTO(String nombreEstudiante, String apellidoEstudiante, String nombreCarrera, String ciudad) {
		super();
		this.nombreEstudiante = nombreEstudiante;
		this.apellidoEstudiante = apellidoEstudiante;
		this.nombreCarrera = nombreCarrera;
		this.ciudad = ciudad;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
