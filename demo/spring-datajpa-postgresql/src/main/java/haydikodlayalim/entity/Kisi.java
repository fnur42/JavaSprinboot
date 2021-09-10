package haydikodlayalim.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity //Veri tabanında tutulacağı yeri belirtir.
@Table(name = "kisi") //Veri tabanı tablosuna denk geleceği için belirtilir.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //İki ifadenin id değerleri eşitse eşitlerdir.
@ToString //String ise sadece Id değerini basar.

public class Kisi {

    @Id //Tablo belirtiliyorsa Id belirtilmelidir.
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1) //Artış miktarı 1 olarak belirlendi.Fonks. belirtir.
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE) // id'nin değeri otomatik atandığında kullanılır. Sequence'den değeri alır.
    private Long id; //Long ve Boolean değerlerde Column'da boyut(lenght) belirtilmez.Çünkü zaten boyut bellidir.

    @Column(length = 100, name = "adi") //Sütun değeri belirtilir.
    private String adi;

    public String getAdi()
    {
        return this.adi;
    }

    public void setAdi(String adi)
    {
        this.adi = adi;
    }

    @Column(length = 100, name = "soyadi") //Sütun değeri belirtilir.
    private String soyadi;

    public String getSoyadi()
    {
        return this.soyadi;
    }

    public void setSoyadi(String soyadi)
    {
        this.soyadi = soyadi;
    }

    @OneToMany //Bir kişi birçok adrese atanabilir.
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresler;

    public List<Adres> getAdresler()
    {
        return this.adresler;
    }

    public void setAdresler(List<Adres> adresler)
    {
        this.adresler = adresler;
    }

}
