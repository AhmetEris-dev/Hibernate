package com.ahmete._02_hibernateNative.entity;

import jakarta.persistence.*;


@Entity
@Table(name="tblmusteri")
public class Musteri {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String ad;
	String soyad;
	String adres;
	
	public Musteri() {
	}
	
	public Musteri(String ad, String soyad, String adres) {
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
	}
	
	public Musteri(Long id, String ad, String soyad, String adres) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
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
	
	public String getSoyad() {
		return soyad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	@Override
	public String toString() {
		return "Musteri{" + "id=" + getId() + ", ad='" + getAd() + '\'' + ", soyad='" + getSoyad() + '\'' + ", adres='" + getAdres() + '\'' + '}';
	}
}