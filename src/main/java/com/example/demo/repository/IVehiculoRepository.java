package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	public Vehiculo buscarPorPlaca(String placa);
	public List<Vehiculo> buscarTodos();
}
