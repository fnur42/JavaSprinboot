package haydikodlayalim.servise;

import haydikodlayalim.dto.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KisiServise  {

    KisiDto save(KisiDto kisiDto);
    void delete(Long id); //id değerine göre silme yapıyor.
    KisiDto getAll(KisiDto kisiDto); //service sadece Dto'lar ile çalışır.
    Page<KisiDto> getAll(Pageable pageable);
}
