package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.VehiculoTO;

public interface IVehiculoService {
	public VehiculoTO buscarPorPlaca(String placa);
	public List<VehiculoTO> buscarTodos();
}
