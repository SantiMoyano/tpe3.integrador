package ps.dto;

import java.time.LocalDate;

public class MatricularEstudianteDTO {
	 private Long id;
	 private Long estudianteId;
	 private Long carreraId;
	 private LocalDate ingreso;
	 private LocalDate egreso;
	 
	public MatricularEstudianteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatricularEstudianteDTO(Long estudianteId, Long carreraId, LocalDate ingreso, LocalDate egreso) {
		super();
		this.estudianteId = estudianteId;
		this.carreraId = carreraId;
		this.ingreso = ingreso;
		this.egreso = egreso;
	}

	public Long getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(Long estudianteId) {
		this.estudianteId = estudianteId;
	}

	public Long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}

	public LocalDate getIngreso() {
		return ingreso;
	}

	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}

	public LocalDate getEgreso() {
		return egreso;
	}

	public void setEgreso(LocalDate egreso) {
		this.egreso = egreso;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
