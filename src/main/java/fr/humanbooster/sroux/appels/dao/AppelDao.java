package fr.humanbooster.sroux.appels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sroux.appels.business.Appel;

public interface AppelDao extends JpaRepository<Appel, Long> {

}
