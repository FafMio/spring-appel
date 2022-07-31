package fr.humanbooster.sroux.appels.initialisation;

import fr.humanbooster.sroux.appels.business.*;
import fr.humanbooster.sroux.appels.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInit implements CommandLineRunner {

    private EmployeDao employeDao;
    private TypeAppelantDao typeAppelantDao;
    private SupportPublicitaireDao supportPublicitaireDao;
    private StatutDao statutDao;
    private AppelDao appelDao;
    private Employe employe;

    @Override
    public void run(String... args) throws Exception {
        addEmployeInit();
        addTypeAppelantInit();
        addSupportPublicitaireInit();
        addStatutInit();
    }

    private void addEmployeInit() {
        if(employeDao.count() == 0) {
            employeDao.save(employe);
            employeDao.save(new Employe("jean-rachid@hb.com", "password"));
            employeDao.save(new Employe("jean-kevin@hb.com", "password"));
            employeDao.save(new Employe("jean-michel@hb.com", "password"));
        }
    }

    private void addTypeAppelantInit() {
        if(typeAppelantDao.count() == 0) {
            typeAppelantDao.save(new TypeAppelant("vendeur"));
            typeAppelantDao.save(new TypeAppelant("acquéreur"));
        }
    }

    private void addSupportPublicitaireInit() {
        if(supportPublicitaireDao.count() == 0) {
            supportPublicitaireDao.save(new SupportPublicitaire("Logic-Immo"));
            supportPublicitaireDao.save(new SupportPublicitaire("SeLoger"));
        }
    }

    private void addStatutInit() {
        if(statutDao.count() == 0) {
            statutDao.save(new Statut("Statut 1"));
            statutDao.save(new Statut("Statut 2"));
            statutDao.save(new Statut("Statut 3"));
        }
    }

    @SuppressWarnings("unused")
	private void addAppelInit() {
        if(appelDao.count() == 0) {
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
            appelDao.save(new Appel(employe));
        }
    }

}
