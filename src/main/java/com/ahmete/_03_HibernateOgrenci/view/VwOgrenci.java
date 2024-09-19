package com.ahmete._03_HibernateOgrenci.view;

public class VwOgrenci {
	String tcKimlik;
	String ad;
	
	public VwOgrenci( String ad,String tcKimlik) {
		this.tcKimlik = tcKimlik;
		this.ad = ad;
	}
	
	public String getTcKimlik() {
		return tcKimlik;
	}
	
	public String getAd() {
		return ad;
	}
	
	@Override
	public String toString() {
		return "tcKimlik='" + getTcKimlik() + '\'' + ", ad='" + getAd() + '\'' ;
	}
}