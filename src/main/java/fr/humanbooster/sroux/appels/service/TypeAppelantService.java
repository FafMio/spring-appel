package fr.humanbooster.sroux.appels.service;

import fr.humanbooster.sroux.appels.business.TypeAppelant;
import fr.humanbooster.sroux.appels.dao.TypeAppelantDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeAppelantService {

    private TypeAppelantDao typeAppelantDao;

    public List<TypeAppelant> recupererTypeAppelant() {
        return typeAppelantDao.findAll();
    }

}
