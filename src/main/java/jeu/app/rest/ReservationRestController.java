package jeu.app.rest;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import jeu.app.forms.JoueurForm;
import jeu.app.forms.WrapperFirstNameAndReservation;
import jeu.app.models.*;
import jeu.app.repository.JoueurRepository;
import jeu.app.repository.ReservationRepository;
import jeu.app.repository.TerrainRepository;
import jeu.app.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
public class ReservationRestController {
    @Autowired
    private TerrainRepository terrainRepository;
    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/saveTerrain")
    public ResponseEntity<?> saveTerrain(@RequestBody Terrain terrain) {
        terrainRepository.save(terrain);
        return ResponseEntity.ok(terrain);
    }

//    @PostMapping("/saveJour")
//    public ResponseEntity<?> saveJoueur(@RequestBody Joueur joueur) {
//        joueurRepository.save(joueur);
//        return ResponseEntity.ok(joueur);
//    }
//
//    @GetMapping("/findAllTerrains")
//    public List<Terrain> findAllTerrain() {
//        return terrainRepository.findAll();
//    }

    @PostMapping("/saveReservation")
    public Reservation saveReservation(@RequestBody WrapperFirstNameAndReservation firstNameAndReservation) {
        return accountService.saveReservation(firstNameAndReservation.getTerrainId(), firstNameAndReservation.getFirstname(), firstNameAndReservation.getReservation());
    }

    @PostMapping("/registration")
    public Joueur registration(@RequestBody JoueurForm joueur) {
        return accountService.saveJoueur(joueur.getFirstname(), joueur.getLastname(), joueur.getUsername(), joueur.getPassword(), joueur.getConfirmPassword());
    }

}
