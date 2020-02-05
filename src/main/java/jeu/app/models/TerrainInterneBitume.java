package jeu.app.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("InterneBitume")
public class TerrainInterneBitume extends Terrain {
    public TerrainInterneBitume() {
    }

    public TerrainInterneBitume(Long terrainId, String terrainName, boolean isTerrainDisponible) {
        super(terrainId, terrainName, isTerrainDisponible);
    }
}
