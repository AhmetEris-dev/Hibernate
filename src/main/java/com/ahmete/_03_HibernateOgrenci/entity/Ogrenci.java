package com.ahmete._03_HibernateOgrenci.entity;

import com.ahmete._03_HibernateOgrenci.enums.ECinsiyet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NamedQuery(name = "Ogrenci.findAll", query = "SELECT o FROM Ogrenci o WHERE o.yas>20")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblogrenci")
public class Ogrenci {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(length = 11, unique = true)
	String tckimlik;
	
	@Column(length = 30)
	String ad;
	
	@Column(length = 30)
	String soyad;
	
	@Enumerated
	ECinsiyet cinsiyet;
	
	LocalDate dogumtarihi;
	
	Integer yas;
	

}