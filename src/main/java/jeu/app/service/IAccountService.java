package jeu.app.service;

import jeu.app.models.Joueur;
import jeu.app.models.Reservation;
import org.springframework.stereotype.Service;

/**
 * Interface for declaring methods which is use in our service class
 */
@Service
public interface IAccountService {
    /**
     *
     *
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param confirmPassword
     * @return Joueur
     */
    Joueur saveJoueur(String firstname, String lastname, String username, String password, String confirmPassword);

    /**
     * method to get a Joueur by his username
     *
     * @param username
     * @return
     */
    Joueur loadJoueurByUsername(String username);

    /**
     * save a reservation
     *
     * @param terrainId
     * @param firstname
     * @param reservation
     * @return Reservation
     */
    Reservation saveReservation(Long terrainId, String firstname, Reservation reservation);
}
