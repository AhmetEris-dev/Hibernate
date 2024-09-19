# User - Pc - Components
Bir User'ın birden fazla PC'si olabilir Bir PC'nin bir User'ı olabilir. (One-to-Many)
Bir PC'de birden fazla component olabilir Bir component bir PC'ye aittir (One-to-Many)

entity -> User,Pc,Component(id,ad,,tur)
enum -> ComponentType (CPU,RAM,HARDDISK,MAINBOARD,POWERSUPPLY,GRAPHICCARD,MONITOR,WEBCAM,MOUSE,KEYBOARD,MICROPHONE,SPEAKER )

## Sorular
### Soru 1.  id'si verilen kullanıcının bilgisayarlarını getir.
### Soru 2.  id'si verilen kullanıcının bilgisayarlarını ve o bilgisayara ait componentleri getir.
### Soru 3.  Tüm kullanıcların bilgisayarlarını ve o bilgisayara ait componentleri getir.
### soru 4.  aradıgımız bir component hangi pc lerde var ?
### soru 5.  aradıgımız bir componente sahip userlar kimlerdir ? nativeQuery ile yap
### soru 6. en cok kullanılan component hangisi ? nativeQuery ile yap