package jeu.app.repository;

import jeu.app.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//    public Reservation findByRefReservation(String ref_Reservation);
}
