package fr.humanbooster.sroux.appels.dao;

import fr.humanbooster.sroux.appels.business.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutDao extends JpaRepository<Statut, Long> {

}
