package haydikodlayalim.servise.impl;

import haydikodlayalim.dto.KisiDto;
import haydikodlayalim.entity.Adres;
import haydikodlayalim.entity.Kisi;
import haydikodlayalim.repo.AdresRepository;
import haydikodlayalim.repo.KisiRepository;
import haydikodlayalim.servise.KisiServise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KisiServiseImpl implements KisiServise {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    public KisiServiseImpl(KisiRepository kisiRepository, AdresRepository adresRepository) {
        this.kisiRepository = kisiRepository;
        this.adresRepository = adresRepository;
    }

    @Override
    public KisiDto save(KisiDto kisiDto) {
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        kisi = kisiRepository.save(kisi); //Bu kişiyi repositorye kaydediyoruz.

        kisiDto.getAdresler().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);

        });
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public KisiDto getAll(KisiDto kisiDto) {
        return null;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
