package fr.humanbooster.sroux.appels.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    @NonNull
    private String email;
    
    @Size(min=4)
    @NonNull
    private String motDePasse;

    @ToString.Exclude
    @OneToMany(mappedBy="operateur")
    private List<Appel> appelsRecus;

    @ToString.Exclude
    @ManyToMany(mappedBy="employesConcernes")
    private List<Appel> appelsConcernes;

    public Employe(String email, String password) {
        this.email = email;
        this.motDePasse = password;
    }
    
}