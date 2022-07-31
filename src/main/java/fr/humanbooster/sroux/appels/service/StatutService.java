package fr.humanbooster.sroux.appels.service;

import fr.humanbooster.sroux.appels.business.Statut;
import fr.humanbooster.sroux.appels.dao.StatutDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatutService {

    private StatutDao statutDao;

    public List<Statut> recupererStatus() {
        return statutDao.findAll();
    }
}
