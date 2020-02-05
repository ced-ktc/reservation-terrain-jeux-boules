package jeu.app.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationId;
    @Column(unique = true)
    private String refReservation;
    private int dureeReservation;
    private double prixReservation;
    @ManyToOne
    private Terrain terrain;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "joueurs_id")
    private List<Joueur> joueurs = new ArrayList<>();


    public Reservation() {
    }

    public Reservation(String refReservation, int dureeReservation) {
        this.refReservation = refReservation;
        this.dureeReservation = dureeReservation;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getRefReservation() {
        return refReservation;
    }

    public void setRefReservation(String refReservation) {
        this.refReservation = refReservation;
    }


    public int getDureeReservation() {
        return dureeReservation;
    }

    public void setDureeReservation(int dureeReservation) {
        this.dureeReservation = dureeReservation;
    }

    public double getPrixReservation() {
        return prixReservation;
    }

    public void setPrixReservation(double prixReservation) {
        this.prixReservation = prixReservation;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
