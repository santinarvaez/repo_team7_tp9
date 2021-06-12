package ar.edu.unju.fi.tp4.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.tp4.model.Beneficio;

public interface IBeneficioRepository extends CrudRepository <Beneficio, Long>{
	public Beneficio findByDescripcion(String descripcion);
	public List<Beneficio> findAll();
	public Optional<Beneficio> findById(Long id);
}
