package haydikodlayalim.dto;
import haydikodlayalim.entity.Kisi;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class KisiDto extends Kisi {

    private Long id; //Long ve Boolean değerlerde Column'da boyut(lenght) belirtilmez.Çünkü zaten boyut bellidir.
    private String adi;
    private String soyadi;
    private List<String> adresler; //Adresleri kendi kafamıza göre yöneticeğimiz için AdresDto'ya gerek kalmadı.

}
