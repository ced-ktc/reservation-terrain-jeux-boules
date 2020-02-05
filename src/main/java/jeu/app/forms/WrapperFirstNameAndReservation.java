/**
 * Class to wrap Reservation entity and firstname to save a reservation
 */

package jeu.app.forms;

import jeu.app.models.Reservation;

public class WrapperFirstNameAndReservation {
    private Long terrainId;
    private String firstname;
    private Reservation reservation;

    public Long getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(Long terrainId) {
        this.terrainId = terrainId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
