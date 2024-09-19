Database: Java15HibernateOgrenci

Entity-> Ogrenci id (PK) tckimlikno (unique) ad (30) soyad (30) cinsiyet (enum) dtarih (LocalDate)

Repository-> OgrenciRepository save() ->persist() List findAll() -> Criteria API

Ogrenci findByTcKimlikNo(String tcno) -> Criteria API Ogrenci findById(Long id) -> Criteria API List findByAdAndSoyad(String ad,String soyad) -> Criteria API

Runner Repository'den save metodunu çağrı ve kaydet. findAll çağırıp tüm öğrencileri listele.

Yapanlar Alperen Bicav Murat Saçak Hüseyin Tartar

* Ogrenci classına yas field ekleyin.
* Vt'deki tüm ogrencilere yas değeri verin.

* Criteria Örnek Çalışmalar

6.Her bir ad kaç defa geçiyor onu yazdıran metodu yazın. Arda 5, Emre 3, Salih 1
7.Ogrencileri yas'a göre sıralı şekilde getirin. ASC
8.18-22 yas arasında kaç öğrenci var? Bunu bulan criteria yazılacak.
9.Adı A ile başlayan öğrencileri listeleyin.
10.Adı E ile başlayan ve yasi 20'den küçük olan öğrencileri listeleyin.