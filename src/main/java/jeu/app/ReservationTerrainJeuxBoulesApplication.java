package jeu.app;

import jeu.app.models.*;
import jeu.app.repository.JoueurRepository;
import jeu.app.repository.ReservationRepository;
import jeu.app.repository.TerrainRepository;
import jeu.app.service.AccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ReservationTerrainJeuxBoulesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationTerrainJeuxBoulesApplication.class, args);
    }
//To mocking data to the test database for test
//    @Bean
//    CommandLineRunner startRunner(JoueurRepository joueurRepository, TerrainRepository terrainRepository, ReservationRepository reservationRepository, AccountServiceImpl accountService) {
//        return args -> {

//            Joueur joueur4 = accountService.saveJoueur("Ced", "ced1", "ced4", "ced4", "ced4");
//            Joueur joueur2 = accountService.saveJoueur("Ced", "ced2", "ced2", "ced2", "ced2");
//            Joueur joueur3 = accountService.saveJoueur("Ced", "ced3", "ced3", "ced3", "ced3");
//            Joueur joueur1 = accountService.saveJoueur("Ced1", "ced1", "ced1", "ced1", "ced1");
//            Joueur joueur5 = accountService.saveJoueur("Ced1", "ced5", "ced5", "ced5", "ced5");
//            List<Joueur> joueurs = new ArrayList<>();
//            joueurs.add(joueur4);
//            joueurs.add(joueur2);
//            joueurs.add(joueur3);
//            joueurs.add(joueur1);
//            joueurs.add(joueur5);
//            joueurRepository.saveAll(joueurs);

//            Terrain terrainNaturel = new TerrainExterieurNaturel(1, "naturel", true);
//            Terrain terrainBitume = new TerrainInterneBitume(2, "bitume", false);
//            Terrain terrainHerbe = new TerrainExterieurHerbe(3, "herbe", true);
//            List<Terrain> terrains = new ArrayList<>();
//            terrains.add(terrainBitume);
//            terrains.add(terrainHerbe);
//            terrains.add(terrainNaturel);
//            terrainRepository.saveAll(terrains);
//
//            Reservation reservation1 = accountService.saveReservation(1,"Ced", new Reservation("ref_resa1", 5));
//            Reservation reservation2 = accountService.saveReservation(2,"Ced1", new Reservation("ref_resa2", 4));
//            reservationRepository.save(reservation1);
//        };
//    }

    ;

}
