package feri.ita.plantdb.model.lifespan;

import feri.ita.plantdb.model.plant.PlantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lifespan")
public class LifespanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lifespan_id", nullable = false)
    private Long lifespanId;
    @Column(name = "name", nullable = false)
    private String lifespanName;
    @ManyToMany(mappedBy = "plantLifespans")
    private Set<PlantModel> plants = new HashSet<>();
}
