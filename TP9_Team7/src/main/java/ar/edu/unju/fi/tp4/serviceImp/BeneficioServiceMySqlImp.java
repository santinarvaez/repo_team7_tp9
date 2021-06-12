package ar.edu.unju.fi.tp4.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tp4.model.Beneficio;
import ar.edu.unju.fi.tp4.repository.IBeneficioRepository;
import ar.edu.unju.fi.tp4.service.IBeneficioService;

@Service("beneficioMysql")
public class BeneficioServiceMySqlImp implements IBeneficioService {
	
	List <Beneficio> beneficiosEncontrados = new ArrayList <Beneficio>();
	
	@Autowired
	private Beneficio beneficio;
	@Autowired
	private IBeneficioRepository beneficioRepository;
	
	@Override
	public void guardarBeneficio(Beneficio beneficio) {
		beneficioRepository.save(beneficio);
		
	}
	
	@Override
	public void quitarBeneficioLista(Long id) {
		for(int i=0; i<beneficiosEncontrados.size();i++) {
			if(beneficiosEncontrados.get(i).getId() == id) {
				beneficiosEncontrados.remove(i);
			}
		}
		
	}

	@Override
	public List<Beneficio> getBeneficios() {
		List<Beneficio> beneficios = (List<Beneficio>) beneficioRepository.findAll();
		return beneficios;
	}

	@Override
	public Beneficio getBeneficio() {
		return beneficio;
	}

	@Override
	public Optional<Beneficio> getBeneficioPorId(Long id) {
		Optional<Beneficio> beneficio = beneficioRepository.findById(id);
		return beneficio;
	}

	@Override
	public List<Beneficio> obtenerBeneficiosEncontrados() {
		
		return beneficiosEncontrados;
	}

	@Override
	public void agregarBeneficioEncontrado(Beneficio beneficio) {
		beneficiosEncontrados.add(beneficio);
		
	}


	
}