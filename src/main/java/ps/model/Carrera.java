package ps.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Carrera {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
//	@OneToMany(mappedBy = "carrera", fetch = FetchType.EAGER)
//	private List<Carrera_Estudiante> estudiantes;
	
	public Carrera() {
		super();
	}

	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
		//this.estudiantes = new ArrayList<>();
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public List<Carrera_Estudiante> getEstudiantes() {
//		return new ArrayList<>(this.estudiantes);
//	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + "]" ;
	}
	
	
}