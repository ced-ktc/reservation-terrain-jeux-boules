/**
 * Class parent of different kind of field(terrain)
 */
package jeu.app.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_terrain", discriminatorType = DiscriminatorType.STRING)
public abstract class Terrain {
    @Id
    @GeneratedValue
    private Long terrainId;
    private String terrainName;
    private boolean isTerrainDisponible;

    public Terrain() {
    }

    public Terrain(Long terrainId, String terrainName, boolean isTerrainDisponible) {
        this.terrainId = terrainId;
        this.terrainName = terrainName;
        this.isTerrainDisponible = isTerrainDisponible;
    }

    public Long getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(Long terrainId) {
        this.terrainId = terrainId;
    }

    public String getTerrainName() {
        return terrainName;
    }

    public void setTerrainName(String terrainName) {
        this.terrainName = terrainName;
    }

    public boolean isTerrainDisponible() {
        return isTerrainDisponible;
    }

    public void setTerrainDisponible(boolean terrainDisponible) {
        isTerrainDisponible = terrainDisponible;
    }
}
