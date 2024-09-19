package com.ahmete._01_hibernateSatis.entity;

import com.ahmete._01_hibernateSatis.enums.ECinsiyet;
import com.ahmete._01_hibernateSatis.enums.EYetki;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tblmusteri")
public class Musteri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ad", length = 30,nullable = false,updatable = false)
	private String ad;
	
	@Enumerated(EnumType.STRING)
	private ECinsiyet cinsiyet;
	
	@Enumerated(EnumType.ORDINAL)
	private EYetki yetki;
	
	@Embedded
	private BaseEntity baseEntity;
	
	@ElementCollection
	List<String> hobiler;
	
	public List<String> getHobiler() {
		return hobiler;
	}
	
	public void setHobiler(List<String> hobiler) {
		this.hobiler = hobiler;
	}
	
	public BaseEntity getBaseEntity() {
		return baseEntity;
	}
	
	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
	
	public ECinsiyet getCinsiyet() {
		return cinsiyet;
	}
	
	public EYetki getYetki() {
		return yetki;
	}
	
	
	
	public void setYetki(EYetki yetki) {
		this.yetki = yetki;
	}
	
	public void setCinsiyet(ECinsiyet cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	
	public Musteri() {
	}
	
	public Musteri(String ad) {
		this.ad = ad;
	}
	
	public Musteri(Long id, String ad) {
		this.id = id;
		this.ad = ad;
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	@Override
	public String toString() {
		return "Musteri{" + "id=" + getId() + ", ad='" + getAd() + '\'' + '}';
	}
	
}