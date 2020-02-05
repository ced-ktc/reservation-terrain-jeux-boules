package jeu.app;


import jeu.app.models.Joueur;
import jeu.app.models.Reservation;
import jeu.app.repository.JoueurRepository;
import jeu.app.repository.ReservationRepository;
import jeu.app.repository.TerrainRepository;
import jeu.app.security.JWTAuthorizationFilter;
import jeu.app.service.AccountServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationTerrainJeuxBoulesApplicationTests {

    static final Logger LOGGER = Logger.getLogger(ReservationTerrainJeuxBoulesApplicationTests.class);


    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private TerrainRepository terrainRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void loadJoueurByUsernameTest() {
        String username = "ted";
        Joueur found = accountService.loadJoueurByUsername(username);
        assertTrue("ted", found.getUsername().equals("ted"));
    }

    @Test
    public void registrationTest() {
        String username = RandomStringUtils.randomAlphanumeric(12);
        Joueur joueur = new Joueur("test", "test", username, "test");
        Joueur save = accountService.saveJoueur("test", "test", username, "test", "test");
        assertEquals(joueur.getUsername(), joueurRepository.findByUsername(username).getUsername());
        LOGGER.info("Username= " + username);
    }

    @Test
    public void saveReservationTest() {
        String reference = RandomStringUtils.randomAlphanumeric(12);
        Reservation reservation = new Reservation(reference, 5);
        Reservation save = accountService.saveReservation(8L, "test", reservation);
        assertEquals(reservation.getRefReservation().equals(reference), save.getRefReservation().equals(reference));
        LOGGER.info("Reference= " + reference);
    }

}
