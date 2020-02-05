package jeu.app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ExterieurNaturel")
public class TerrainExterieurNaturel extends Terrain {
    public TerrainExterieurNaturel() {
    }

    public TerrainExterieurNaturel(Long terrainId, String terrainName, boolean isTerrainDisponible) {
        super(terrainId, terrainName, isTerrainDisponible);
    }
}
