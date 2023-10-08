package ps.dto;

public class EstudianteDTO {
	private Long id;
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private String ciudad;
	private int numeroLibreta;
	public EstudianteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstudianteDTO(Long id, int dni, String nombre, String apellido, int edad, String genero, String ciudad,
			int numeroLibreta) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.numeroLibreta = numeroLibreta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getNumeroLibreta() {
		return numeroLibreta;
	}
	public void setNumeroLibreta(int numeroLibreta) {
		this.numeroLibreta = numeroLibreta;
	}

}
