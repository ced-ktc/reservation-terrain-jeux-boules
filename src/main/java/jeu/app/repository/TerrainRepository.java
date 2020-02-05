package jeu.app.repository;

import jeu.app.models.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TerrainRepository extends JpaRepository<Terrain, Long> {

//    @Query("select t from Terrain t where t.terrainDisponible =true and t.terrainId= :terrainId")
//    public Terrain findByIDAndDisponible(@Param("terrainId") Long terrainId);
}
