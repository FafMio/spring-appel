package fr.humanbooster.sroux.appels.service;

import fr.humanbooster.sroux.appels.business.SupportPublicitaire;
import fr.humanbooster.sroux.appels.dao.SupportPublicitaireDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupportPublicitaireService {

    private SupportPublicitaireDao supportPublicitaireDao;

    public List<SupportPublicitaire> recupererSupportPublicitaire() {
        return supportPublicitaireDao.findAll();
    }
}
