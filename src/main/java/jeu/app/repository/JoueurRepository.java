package jeu.app.repository;

import jeu.app.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    public Joueur findByUsername(String username);
    public List<Joueur> findByFirstname(String firstname);
}
