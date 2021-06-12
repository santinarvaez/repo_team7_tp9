package ar.edu.unju.fi.tp4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


@Entity
@Table(name="BENEFICIOS")
@Component
public class Beneficio {
	//¨*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ben_id")
	private Long id;
	
	@NotEmpty(message = "Por valor ingrese una descripcion")
	@Column(name="ben_descripcion")
	private String descripcion;
	
	@ManyToMany(mappedBy = "beneficios")
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public Beneficio(Long id, @NotEmpty(message = "Por valor ingrese una descripcion") String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Beneficio() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String g() {
		return "";
	}

}
