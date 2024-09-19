package com.ahmete._04_HibernatePC.entity;

import com.ahmete._04_HibernatePC.enums.EComponentType;
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
@Table(name = "tblcomponents")
public class Component {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long pcid;
	private String marka;
	@Enumerated(EnumType.STRING)
	private EComponentType componentType;
	
}