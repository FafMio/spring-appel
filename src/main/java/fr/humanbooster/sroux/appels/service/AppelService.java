package fr.humanbooster.sroux.appels.service;

import fr.humanbooster.sroux.appels.business.Appel;
import fr.humanbooster.sroux.appels.dao.AppelDao;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppelService {

    private AppelDao appelDao;

    public Page<Appel> recupererAppels(Pageable pageable) {
        return appelDao.findAll(pageable);
    }

    public Appel enregistrerAppel(Appel appel) {
        return appelDao.save(appel);
    }
}
