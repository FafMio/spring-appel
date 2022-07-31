package fr.humanbooster.sroux.appels.dao;

import fr.humanbooster.sroux.appels.business.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeDao extends JpaRepository<Employe, Long> {

    Employe findByEmailAndMotDePasse(String email, String motDePasse);

}
