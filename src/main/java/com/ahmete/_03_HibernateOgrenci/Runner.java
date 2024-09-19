package com.ahmete._03_HibernateOgrenci;

import com.ahmete._03_HibernateOgrenci.entity.Adres;
import com.ahmete._03_HibernateOgrenci.entity.Ogrenci;
import com.ahmete._03_HibernateOgrenci.enums.ECinsiyet;
import com.ahmete._03_HibernateOgrenci.repository.OgrenciRepository;

import java.time.LocalDate;
import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
		OgrenciRepository ogrenciRepository = new OgrenciRepository();
//		Ogrenci o1 = new Ogrenci("11122233344", "Arda", "Güler", ECinsiyet.ERKEK, LocalDate.of(2000, 10, 10), 28);
//		Ogrenci o2 = new Ogrenci("11122233355", "Emre", "Mor", ECinsiyet.ERKEK, LocalDate.of(2000, 10, 10), 25);

//		ogrenciRepository.save(o2);

//		new OgrenciRepository().findAll().forEach(System.out::println);


//		 Optional kullanmadan aranan tc eğer tabloda varsa herhangi bir sıkıntı çıkmadan ogrenci bilgilerini yazdırdı.
//		System.out.println(ogrenciRepository.findByTcKimlikNo("11122233344"));
		
		// Optional kullanmadan aranan tc eğer tabloda yoksa jakarta.persistence.NoResultException: No result found
		// for query [<criteria>] hatasını fırlatır ve uygulama çalışmayı durdurur.
		// System.out.println(ogrenciRepository.findByTcKimlikNo("11122236666"));

//		 Optional kullanarak aranan tc varsa;
//		ogrenciRepository.findByTcKimlikNo("11122233344").ifPresentOrElse(System.out::println,()->System.out.println(
//				"Aranan tc bulunamadı..."));
//		 Optional kullanarak aranan tc yoksa;
//		ogrenciRepository.findByTcKimlikNo("11122236666").ifPresentOrElse(System.out::println,()->System.out.println(
//				"Aranan tc bulunamadı..."));
		
		//ogrenciRepository.findAllTcKimlikNo().forEach(System.out::println);

//		ogrenciRepository.findById(2L).ifPresent(System.out::println);
//		ogrenciRepository.findByAdAndSoyad("Arda","Güler").forEach(System.out::println);
//		ogrenciRepository.findByAdAndSoyad("Arda","Mor").forEach(System.out::println);

//		ogrenciRepository.findAllAdAndTckimlik().forEach(obj->{
//			System.out.println(Arrays.toString(obj));
//		});

//		ogrenciRepository.findAllAdAndTckimlik().forEach(objarray->{
//			System.out.println("Ad: "+objarray[0] + ", Tckimlik: "+objarray[1]);
//		});

//		ogrenciRepository.findAllAdAndTckimlikView().forEach(o->System.out.println(o));

//		ogrenciRepository.findAllAdAndTckimlikView().forEach(o->System.out.println("Ad: "+o.getAd()+" Tc: "+o
//		.getTcKimlik()));

//		6. Her bir ad kaç defa geçiyor onu yazdıran metodu yazın. Arda 5, Emre 3, Salih 1
//		ogrenciRepository.countOgrenciByAd().forEach(o->System.out.println(o[0]+" "+o[1]));
//		7. Ogrencileri yas'a göre sıralı şekilde getirin. ASC
//		ogrenciRepository.orderByYas().forEach(System.out::println);
//		8. 18-22 yas arasında kaç öğrenci var? Bunu bulan criteria yazılacak.
//		System.out.println(ogrenciRepository.countOgrenci());
//		9. Adı A ile başlayan öğrencileri listeleyin.
//		ogrenciRepository.adStartsA().forEach(System.out::println);
//		10. Adı E ile başlayan ve yasi 20'den küçük olan öğrencileri listeleyin.
//		ogrenciRepository.adStartsEAndLT20().forEach(System.out::println);


//		ogrenciRepository.adEndsWithE().forEach(System.out::println);

//		ogrenciRepository.findAllNamedQuery().forEach(System.out::println);

//		System.out.println("Uygulama çalışmaya devam ediyor...");
		
		//lombok builder ile yeni nesne yaratma
		Adres adres1 = Adres.builder().il("İstanbul").ilce("Sariyer").postakodu("34525").build();
		
//		findbyFieldNameAndValue("il","İstanbul");
//		findByFilledFields(adres1);
//
		System.out.println(adres1);
		
	}
}