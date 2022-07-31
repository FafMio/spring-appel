package fr.humanbooster.sroux.appels.dao;

import fr.humanbooster.sroux.appels.business.HistoriqueStatut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueStatutDao extends JpaRepository<HistoriqueStatut, Long> {

}
