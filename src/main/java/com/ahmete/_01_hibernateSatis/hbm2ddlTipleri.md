hbm2ddl nedir?
Hibernate Mapping to data defination language

create: Başlangıçta eğer daha önceden vt'de tablolar varsa drop eder ve tekrar oluşturur. Bu sadece test aşamasında, tablo yapısında çokca değişiklik yaparken kullanılabilir. Proje kapandığında tablolar kalır.

create-drop: create mod gibidir. Farkı proje kapandığında tabloları drop eder.

update: Var olan tablolarda güncelleme yaparak devam eder. Tabloları veya içindeki verileri silmez.

validate: Veritabanındaki yapı ile projenizdeki entity yapısı uyumlu mu kontrolünü yapmak için kullanılabilir. Caused by: org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing column [ad] in table [tblmusteri]