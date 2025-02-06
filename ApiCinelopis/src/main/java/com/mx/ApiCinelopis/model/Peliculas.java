package com.mx.ApiCinelopis.model;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PELICULAS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Peliculas implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@Column(name="ID_PELI", columnDefinition = "NUMBER", nullable=false)
	private Integer idPeli;
	@Column(name="NOMBRE", columnDefinition = "VARCHAR2(100)", nullable=false)
	private String nombre ;
	@Column(name="TIPO", columnDefinition = "VARCHAR2(100)", nullable=false)
	private String tipo ;
	@Column(name="PRECIO", columnDefinition = "NUMBER", nullable=false)
	private Long precio ;
	@Column(name="FECHA_LANZ", columnDefinition = "DATE", nullable=false)
	private Date fechaLanz ;

}
