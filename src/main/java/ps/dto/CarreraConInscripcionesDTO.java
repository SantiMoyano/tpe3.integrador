package ps.dto;

public class CarreraConInscripcionesDTO {
	
	private String nombre;
    private int cantidadInscritos;
    
	public CarreraConInscripcionesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarreraConInscripcionesDTO(String nombre, int cantidadInscritos) {
		super();
		this.nombre = nombre;
		this.cantidadInscritos = cantidadInscritos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidadInscritos() {
		return cantidadInscritos;
	}
	
	public void setCantidadInscritos(int cantidadInscritos) {
		this.cantidadInscritos = cantidadInscritos;
	}
    
}
