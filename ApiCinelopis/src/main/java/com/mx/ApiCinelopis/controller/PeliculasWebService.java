package com.mx.ApiCinelopis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiCinelopis.model.Peliculas;
import com.mx.ApiCinelopis.service.PeliculasServImp;

@RestController
@RequestMapping(path="PeliculasWebService")
@CrossOrigin
public class PeliculasWebService {
     @Autowired
     PeliculasServImp  peliculasServImp;

   //http://localhost:9000/PeliculasWebService/listar
 	@GetMapping(path="listar")
 	public List<Peliculas> listar() {
 		return peliculasServImp.listar();
 	}
    
 	// http://localhost:9000/PeliculasWebService/guardar
 	@PostMapping(path="guardar")
 	public ResponseEntity<?> guardar(@RequestBody Peliculas peliculas){
 		String response = peliculasServImp.guardar(peliculas);
 		if(response.equals("idExiste")) {
 			return new  ResponseEntity<>("No se puede guardar, id ya existe", HttpStatus.OK);
 		}else if (response.equals("nombreExiste")) {
 			return new  ResponseEntity<>("No se puede guardar, nombre ya existe", HttpStatus.OK);
		}else {
			return new  ResponseEntity<>(peliculas, HttpStatus.CREATED);
		}
 	}
 	
    // http://localhost:9000/PeliculasWebService/buscarXid
 	@PostMapping(path="buscarXid")
 	public Peliculas buscarXid(@RequestBody Peliculas peliculas) {
 		return peliculasServImp.buscarXId(peliculas.getIdPeli());
 	}
 	
 	// http://localhost:9000/PeliculasWebService/editar
 	@PostMapping(path="editar")
    public ResponseEntity<?> editar(@RequestBody Peliculas peliculas){
 		boolean response = peliculasServImp.editar(peliculas);
 		if(response==false) {
 			return new ResponseEntity<>("No se puede editar no existe el id ", HttpStatus.OK);
 		}else {
 			return new ResponseEntity<>(peliculas,HttpStatus.CREATED);
 		}
 	 }
 	
    // http://localhost:9000/PeliculasWebService/eliminar
 	@PostMapping(path="eliminar")
    public ResponseEntity<?> eliminar(@RequestBody Peliculas peliculas){
 		boolean response = peliculasServImp.eliminar(peliculas.getIdPeli());
 		if(response == false) {
 		   return new ResponseEntity<>("No se puede eliminar no existe el id ", HttpStatus.OK);
 		}else {
 		   return new ResponseEntity<>(peliculas, HttpStatus.CREATED);
 		}
 	}
 	
}
