package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		String sql = "SELECT v FROM Vehiculo v WHERE v.placa = : placa";
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery(sql, Vehiculo.class);
		myQuery.setParameter("placa", placa);
		
		return myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT v FROM Vehiculo v";
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery(sql, Vehiculo.class);
		
		return myQuery.getResultList();
	}

}
