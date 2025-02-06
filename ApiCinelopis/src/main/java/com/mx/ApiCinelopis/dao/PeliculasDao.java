package com.mx.ApiCinelopis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ApiCinelopis.model.Peliculas;

public interface PeliculasDao extends JpaRepository<Peliculas, Integer> {

}
