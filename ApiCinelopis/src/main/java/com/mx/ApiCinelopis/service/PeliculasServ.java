package com.mx.ApiCinelopis.service;

import java.util.List;

import com.mx.ApiCinelopis.model.Peliculas;


public interface PeliculasServ {
	
     public List<Peliculas> listar();
	
	public String guardar(Peliculas peliculas);
	
	public Peliculas buscarXId(int idPeli);
	
	public boolean editar(Peliculas peliculas);
	
	public boolean eliminar(int idPeli);

}
