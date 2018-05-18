package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;

@Entity
@Table(name="world_cups")
public class WorldCup extends Competition {

    public WorldCup() {
    }

    public WorldCup(String name) {
        super(name);
    }
}
