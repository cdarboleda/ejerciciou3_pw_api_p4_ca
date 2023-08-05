package com.example.demo.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public VehiculoTO buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return convertirATO(this.vehiculoRepository.buscarPorPlaca(placa));
	}

	@Override
	public List<VehiculoTO> buscarTodos() {
		List<Vehiculo> lista = this.vehiculoRepository.buscarTodos();
		List<VehiculoTO> listaTO = lista.stream().map(v-> convertirATO(v)).collect(Collectors.toList());
		return listaTO;
	}
	

	private VehiculoTO convertirATO(Vehiculo v){
		VehiculoTO vt = new VehiculoTO();
		
		vt.setColor(v.getColor());
		vt.setId(v.getId());
		vt.setModelo(v.getModelo());
		vt.setModo(v.getModo());
		vt.setPlaca(v.getPlaca());
		
		return vt;
	}

}
