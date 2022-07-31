package fr.humanbooster.sroux.appels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.sroux.appels.business.TypeAppelant;

public interface TypeAppelantDao extends JpaRepository<TypeAppelant, Long> {

}
