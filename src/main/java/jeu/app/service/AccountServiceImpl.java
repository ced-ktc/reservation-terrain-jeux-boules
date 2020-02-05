/**
 * Class Service permettant d'ajouter
 */

package jeu.app.service;

import jeu.app.models.*;
import jeu.app.repository.JoueurRepository;
import jeu.app.repository.ReservationRepository;
import jeu.app.repository.TerrainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    private static final double OCCURRENCE = 0.05;
    private static final double PRICE_ONE = 8.0;
    private static final int NOMBRE_JOUEURS_MIN = 2;
    private static final int NOMBRE_JOUEURS_MAX = 8;

    private JoueurRepository joueurRepository;
    private ReservationRepository reservationRepository;
    private TerrainRepository terrainRepository;


    public AccountServiceImpl(JoueurRepository joueurRepository, ReservationRepository reservationRepository, TerrainRepository terrainRepository) {
        this.joueurRepository = joueurRepository;
        this.reservationRepository = reservationRepository;
        this.terrainRepository = terrainRepository;
    }

    /**
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param confirmPassword
     * @return
     */
    @Override
    public Joueur saveJoueur(String firstname, String lastname, String username, String password, String confirmPassword) {
        Joueur joueur = joueurRepository.findByUsername(username);
        if (joueur != null) throw new RuntimeException("Joueur " + username + " already exists");
        if (!password.equals(confirmPassword)) throw new RuntimeException("Please confirm your password");
        Joueur jjouer = new Joueur();
        jjouer.setFirstname(firstname);
        jjouer.setLastname(lastname);
        jjouer.setUsername(username);
        jjouer.setPassword(passwordEncoder().encode(password));
        joueurRepository.save(jjouer);
        return jjouer;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Joueur loadJoueurByUsername(String username) {
        return joueurRepository.findByUsername(username);
    }

    /**
     * @param terrainId
     * @param firstname
     * @param reservation
     * @return
     */
    @Override
    public Reservation saveReservation(Long terrainId, String firstname, Reservation reservation) {
        //recupère tous les terrains disponibles
        Terrain terrain = terrainRepository.getOne(terrainId);
        List<Joueur> joueurs = joueurRepository.findByFirstname(firstname);
        int dureeReservation = reservation.getDureeReservation();
        //Calcul du prix en décrémentant de 1/5
        double sommePrice = 0;
        if (dureeReservation == 1) reservation.setPrixReservation(PRICE_ONE);
        else {
            sommePrice = PRICE_ONE;
            for (int i = 2; i <= dureeReservation; i++) {
                sommePrice = sommePrice + (double) (PRICE_ONE - (PRICE_ONE * (double) 1 / (double) (i * 5)));
            }
            sommePrice = (double) Math.round(sommePrice * 100) / 100;
            reservation.setPrixReservation(sommePrice);
        }
        reservation.setJoueurs(joueurs);
        if (reservation.getJoueurs().size() < NOMBRE_JOUEURS_MIN || reservation.getJoueurs().size() > NOMBRE_JOUEURS_MAX)
            throw new RuntimeException("Incompatible number of players");

        if (terrain instanceof TerrainInterneBitume) {
            reservation.setTerrain(terrain);
        }
        //while the weather API does not work, use the ramdom to evaluate
        Random random=new Random();
        boolean conditionWeather = random.nextBoolean();
        if (terrain instanceof TerrainExterieurHerbe || terrain instanceof TerrainExterieurNaturel) {
            if (!conditionWeather) throw new RuntimeException("You cannot reserve the field");
            reservation.setTerrain(terrain);
        }
        terrain.setTerrainDisponible(false);
        reservationRepository.save(reservation);

        return reservation;
    }

}
