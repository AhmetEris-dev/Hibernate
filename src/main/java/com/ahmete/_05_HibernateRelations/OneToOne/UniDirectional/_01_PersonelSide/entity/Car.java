package com.ahmete._05_HibernateRelations.OneToOne.UniDirectional._01_PersonelSide.entity;


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
@Table(name = "tblcar")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String model;
}