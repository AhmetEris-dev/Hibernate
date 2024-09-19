package com.ahmete._03_HibernateOgrenci.repository;

import com.ahmete._03_HibernateOgrenci.entity.Ogrenci;
import com.ahmete._03_HibernateOgrenci.view.VwOgrenci;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class OgrenciRepository {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public OgrenciRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("pu_hibernate");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void save(Ogrenci ogrenci) {
		entityManager.getTransaction().begin();
		entityManager.persist(ogrenci);
		entityManager.getTransaction().commit();
	}
	
	// SELECT * FROM tblogrenci
	public List<Ogrenci> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class); // Sorgudan geri dönecek tip
		// belirtilen kısım.
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class); // Sorgudaki fromdan sonraki kısma denk gelir.
		criteriaQuery.select(root); // select * işlemine karşılık gelir.
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	// SELECT * FROM tblogrenci WHERE tckimlikno=tcno
	public Optional<Ogrenci> findByTcKimlikNo(String tcno) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class);
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("tckimlik"), tcno));
		
		try {
			return Optional.of(entityManager.createQuery(criteriaQuery).getSingleResult());
		}
		catch (Exception e) {
			//System.out.println(tcno+" nolu tc aranırken hata meydana geldi...."+e.getMessage());
			return Optional.empty();
		}
	}
	
	// SELECT tckimlik FROM tblogrenci
	public List<String> findAllTcKimlikNo() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class); // Geri dönülecek tip.
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		criteriaQuery.select(root.get("tckimlik"));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	// SELECT * FROM tblogrenci WHERE id=?
	public Optional<Ogrenci> findById(Long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class);
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
		
		try {
			return Optional.of(entityManager.createQuery(criteriaQuery).getSingleResult());
		}
		catch (Exception e) {
			return Optional.empty();
		}
	}
	
	// SELECT * FROM tblogrenci WHERE ad="" AND soyad=""
	public List<Ogrenci> findByAdAndSoyad(String ad, String soyad) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class);
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		//Harun:
//		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("ad"),ad),criteriaBuilder.equal(root.get
//		("soyad"),soyad));
		criteriaQuery.select(root)
		             .where(criteriaBuilder.and(criteriaBuilder.equal(root.get("ad"), ad),
		                                        criteriaBuilder.equal(root.get("soyad"), soyad)));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	// SELECT ad,tckimlik FROM tblogrenci
	public List<Object[]> findAllAdAndTckimlik(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		Path<String> ad = root.get("ad");
		Path<String> tckimlik = root.get("tckimlik");
		
		//criteriaQuery.multiselect(ad,tckimlik);
		
		criteriaQuery.select(criteriaBuilder.array(ad,tckimlik));
		
		return entityManager.createQuery(criteriaQuery).getResultList(); // eğer map dönmek isterseniz
		// Map<String,String>  k: tckimlik v:ad gelebilir. burada geri dönen listi map'e çevirmek yeterli olur.
	}
	
	public List<VwOgrenci> findAllAdAndTckimlikView(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VwOgrenci> criteriaQuery = criteriaBuilder.createQuery(VwOgrenci.class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		Path<String> ad = root.get("ad");
		Path<String> tckimlik = root.get("tckimlik");
		
		criteriaQuery.multiselect(ad,tckimlik);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	//	6. Her bir ad kaç defa geçiyor onu yazdıran metodu yazın. Arda 5, Emre 3, Salih 1, Emine Karabolat:
	// SELECT ad,COUNT(ad) FROM tblogrenci GROUP BY(ad)
	public List<Object[]> countOgrenciByAd(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);

//		criteriaQuery.groupBy(root.get("ad"));
//		criteriaQuery.multiselect(root.get("ad"),criteriaBuilder.count(root.get("ad")));
		
		criteriaQuery.multiselect(root.get("ad"),criteriaBuilder.count(root.get("ad"))).groupBy(root.get("ad"));;
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	//			7. Ogrencileri yas'a göre sıralı şekilde getirin. ASC Harun
	// SELECT * FROM tblogrenci ORDER BY yas
	public List<Ogrenci> orderByYas(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		criteriaQuery.select(root)
		             .orderBy(criteriaBuilder.asc(root.get("yas")));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	//			8. 18-22 yas arasında kaç öğrenci var? Bunu bulan criteria yazılacak. Mehmet Can Karahan:
	// SELECT COUNT(*) FROM tblogrenci WHERE yas BETWEEN 18 AND 22
	public Long countOgrenci(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		criteriaQuery.select(criteriaBuilder.count(root))
		             .where(criteriaBuilder.between(root.get("yas"),18,22));
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
	
	//			9. Adı A ile başlayan öğrencileri listeleyin. Alex:
	// SELECT * FROM tblogrenci WHERE ad LIKE 'A%'
	public List<Ogrenci> adStartsA(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		criteriaQuery.select(root)
		             .where(criteriaBuilder.like(criteriaBuilder.lower(root.get("ad")),"a%")); // ilike yerine bu şekilde
		// arama yapılabilir.
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	
	//			10. Adı E ile başlayan ve yasi 20'den küçük olan öğrencileri listeleyin. Emirhan:
//			Küçüktür: lessThan : lt,
//	        Küçük eşittir: lte,
//			Büyüktür: Greater Than: gt,
//			Büyük eşittir Greater Than Equal: gte
	// SELECT * FROM tblogrenci WHERE ad LIKE 'E%' AND yas<20
	public List<Ogrenci> adStartsEAndLT20(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ogrenci> criteriaQuery = criteriaBuilder.createQuery(Ogrenci.class); // geri dönüş tipi
		Root<Ogrenci> root = criteriaQuery.from(Ogrenci.class);
		
		criteriaQuery.select(root);
		
		criteriaQuery.where(criteriaBuilder.and(
				criteriaBuilder.like(root.get("ad"),"E%"),
				criteriaBuilder.lessThan(root.get("yas"),20)
		));
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	// NATIVE QUERY
	// Soru: Adı e ile biten ogrencileri listele
	// SELECT * FROM tblogrenci WHERE ad LIKE '%e'
	public List<Ogrenci> adEndsWithE(){
		return entityManager.createNativeQuery("SELECT * FROM tblogrenci WHERE ad LIKE '%e'", Ogrenci.class)
		                    .getResultList();
	}
	
	//NAMED QUERY
	public List<Ogrenci> findAllNamedQuery(){
		return entityManager.createNamedQuery("Ogrenci.findAll",Ogrenci.class).getResultList();
	}
}