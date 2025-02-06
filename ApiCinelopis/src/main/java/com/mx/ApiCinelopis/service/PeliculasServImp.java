package com.mx.ApiCinelopis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiCinelopis.dao.PeliculasDao;
import com.mx.ApiCinelopis.model.Peliculas;

@Service 
public class PeliculasServImp implements PeliculasServ{
	
    @Autowired
    PeliculasDao peliculasDao;
	@Override
	public List<Peliculas> listar() {
		List<Peliculas> listanew = peliculasDao.findAll(); 
		return listanew;
	}

	@Override
	public String guardar(Peliculas peliculas) {
		boolean bandera = false;
		String respuesta ="guardo";
		for (Peliculas p : peliculasDao.findAll()) {
			if(p.getIdPeli().equals(peliculas.getIdPeli())) {
				bandera=true;
				respuesta="idExiste";
				break;
			}else if (p.getNombre().equals(peliculas.getNombre())) {
				bandera=true;
				respuesta="nombreExiste";
				break;
			}
		}
		if(!bandera) {
			peliculasDao.save(peliculas);
		}
		return respuesta;
	}
    
	@Transactional(readOnly=true)
	@Override
	public Peliculas buscarXId(int idPeli) {
        Peliculas peliculas = peliculasDao.findById(idPeli).orElse(null);		
		return peliculas;
	}

	@Override
	public boolean editar(Peliculas peliculas) {
		boolean bandera = false;
		for (Peliculas p : peliculasDao.findAll()) {
			if(p.getIdPeli().equals(peliculas.getIdPeli())) {
				peliculasDao.save(peliculas);
				bandera=true;
				break;
			}
		}
		return bandera;
	}

	@Override
	public boolean eliminar(int idPeli) {
		boolean bandera = false;
		for (Peliculas p : peliculasDao.findAll()) {
			if (p.getIdPeli().equals(idPeli)){
				peliculasDao.deleteById(idPeli);
				bandera= true;
				break;
			}
		}
		return bandera;
	}

}
