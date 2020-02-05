package jeu.app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ExterieurHerbe")
public class TerrainExterieurHerbe extends Terrain {
    public TerrainExterieurHerbe() {
    }

    public TerrainExterieurHerbe(Long terrainId, String terrainName, boolean isTerrainDisponible) {
        super(terrainId, terrainName, isTerrainDisponible);
    }
}
