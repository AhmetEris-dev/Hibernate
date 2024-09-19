package com.ahmete._03_HibernateOgrenci.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="tbladres")
public class Adres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String il;
	String ilce;
	String mahalle;
	String cadde;
	String sokak;
	String binano;
	String kapino;
	String postakodu;
	
	
}