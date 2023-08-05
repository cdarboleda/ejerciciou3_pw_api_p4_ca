package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTO;

@RestController
@RequestMapping(path="/vehiculos")
@CrossOrigin
public class VehiculoControllerRestFul {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping(path="/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> buscarVehiculo(@PathVariable String placa) {
		//HttpHeaders cabecera = new HttpHeaders(null);
		VehiculoTO v = this.vehiculoService.buscarPorPlaca(placa);		
		return new ResponseEntity<>(v, null, 200);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> buscarTodos() {
		 List<VehiculoTO> listaTO =  this.vehiculoService.buscarTodos(); 
		 
			for(VehiculoTO vt : listaTO) {
				Link myLink = linkTo(methodOn(VehiculoControllerRestFul.class)
						.buscarVehiculo(vt.getPlaca()))
						.withSelfRel();
				
				vt.add(myLink);
			}
		
		return new ResponseEntity<>(listaTO, null ,200);
	}


}
