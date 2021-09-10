package haydikodlayalim.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity //Veri tabanında tutulacağı yeri belirtir.
@Table(name = "kisi_adres") //Veri tabanı tablosuna denk geleceği için belirtilir.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //İki ifadenin id değerleri eşitse eşitlerdir.
@ToString //String ise sadece Id değerini basar.
//@Data yukarıdakilerin hepsini kapsar.
//Id ve Entity zorunlu diğerleri zorunlu değildir.

public class Adres implements Serializable{

    @Id //Tablo belirtiliyorsa Id belirtilmelidir.
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1) //Artış miktarı 1 olarak belirlendi.Fonks. belirtir.
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE) // id'nin değeri otomatik atandığında kullanılır. Sequence'den değeri alır.
    private Long id; //Long ve Boolean değerlerde Column'da boyut(lenght) belirtilmez.Çünkü zaten boyut bellidir.

    @Column(length = 500, name = "adres") //Sütun değeri belirtilir.
    private String adres;

    public String getAdres()
    {
        return this.adres;
    }

    public void setAdres(String adres)
    {
        this.adres = adres;
    }

    @Enumerated
    private AdresTip adresTip;

    public AdresTip getAdresTip()
    {
        return this.adresTip;
    }

    public void setAdresTip(AdresTip adresTip)
    {
        this.adresTip = adresTip;
    }

    @Column(name = "aktif")
    private Boolean aktif;

    public Boolean getAktif()
    {
        return this.aktif;
    }

    public void setAktif(boolean aktif)
    {
        this.aktif = aktif;
    }

    @ManyToOne //Birçok adrese bir kişi atanır.
    @JoinColumn(name = "kisi_adres_id") //Bir kişiye istediğimiz kadar adres atamamızı sağlar ve iki tabloyu birbirine bağlar.
    private Kisi kisi; //Belirtilen adres bir kişiye atanmıştır.

    public enum AdresTip{
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
}
