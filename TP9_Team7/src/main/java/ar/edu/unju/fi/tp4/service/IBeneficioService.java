package ar.edu.unju.fi.tp4.service;

import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.tp4.model.Beneficio;

	public interface IBeneficioService {

		public Optional<Beneficio> getBeneficioPorId(Long id);
		public List<Beneficio> obtenerBeneficiosEncontrados();
		public void agregarBeneficioEncontrado(Beneficio beneficio);
		public void quitarBeneficioLista(Long id);
		public void guardarBeneficio(Beneficio beneficio);
		public List<Beneficio> getBeneficios();
		public Beneficio getBeneficio();
		
	}
	

