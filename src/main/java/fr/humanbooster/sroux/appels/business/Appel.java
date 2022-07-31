package fr.humanbooster.sroux.appels.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Appel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateHeureDebut;

    @NotBlank(message="Merci de renseigner l''objet de l''appel")
    @Lob
    private String objet;

    @ManyToMany(fetch=FetchType.EAGER)
    @NotEmpty(message="Merci de sélectionner le ou les employés concernés")
    private List<Employe> employesConcernes;

    @ManyToOne
    @NotNull(message="Merci de préciser l''employé ayant saisi cet appel")
    private Employe operateur;

    @ManyToOne
    private SupportPublicitaire supportPublicitaire;

    @ManyToOne
    @NotNull(message="Merci de préciser le type d''appelant")
    private TypeAppelant typeAppelant;

    @NotBlank(message="Merci de préciser le nom de l''appelant")
    private String nomAppelant;
    
    @NotBlank(message="Merci de préciser le prénom de l''appelant")
    private String prenomAppelant;
    
    @Pattern(regexp="^[0-9]+$", message="Merci de saisir uniquement des chiffres")
    private String numeroDeTelephoneAppelant;

    @OneToMany(mappedBy="appel", cascade=CascadeType.REMOVE)
    @ToString.Exclude
    private List<HistoriqueStatut> historiqueStatuts;

    public Appel() {
    	dateHeureDebut = LocalDateTime.now();
	}

	public Appel(Employe operateur) {
		this();
		this.operateur = operateur;
	}
}