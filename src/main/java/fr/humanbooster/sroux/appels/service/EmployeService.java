package fr.humanbooster.sroux.appels.service;

import fr.humanbooster.sroux.appels.business.Employe;
import fr.humanbooster.sroux.appels.dao.EmployeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeService {

    private EmployeDao employeDao;

    public Employe recupererEmploye(String email, String motDePasse) {
        return employeDao.findByEmailAndMotDePasse(email, motDePasse);
    }

    public List<Employe> recupererEmployes() {
        return employeDao.findAll();
    }

    public long compterEmployes() {
        return employeDao.count();
    }

    public Employe enregistrerEmploye(Employe employe) {
        return employeDao.save(employe);
    }

}
