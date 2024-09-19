1:
@Id // PK yapmak için kullanılır. @GeneratedValue(strategy = GenerationType.IDENTITY)

strategy = GenerationType.IDENTITY
Her bir tablo için ayrı ayrı seq dosyası oluşturur. 1'den başlayaran 1'er 1'er artış sağlar. postgresql'de serial nasıl davranıyorsa aynı şekilde davranır.

strategy = GenerationType.AUTO
Tüm tablolar için 1 tane seq dosyası oluşturur. Örnek olarak: bir musteri eklediğinizde o dosyada 1 değeri üretilir ve musteri id'si 1 olur. sonra satış eklediğinizde 2 değeri satis id olur. eklenen her yeni değer hangi tabloya eklendiği farketmeksizin eşsiz olur.

strategy = GenerationType.SEQUENCE
Bu stratejide elle SEQ oluşturulur.

initialValue: başlangıç değeri allocationSize: artış miktarıdır. @SequenceGenerator(name = "seq_musteri_id", sequenceName = "seq_musteri_id", initialValue = 100,allocationSize = 5) @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_musteri_id")

strategy = GenerationType.UUID
Bu stratejide UUID formatında rastgele değerler oluşturur.

strategy = GenerationType.TABLE
Bu stratejide seq tablosunu otomatik oluşturamayan databaselerde yeni tablo oluşturması için kullanılır.