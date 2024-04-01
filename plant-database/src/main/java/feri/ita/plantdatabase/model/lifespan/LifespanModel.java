package feri.ita.plantdatabase.model.lifespan;

import feri.ita.plantdatabase.model.part_color.ColorModel;
import feri.ita.plantdatabase.model.plant.PlantModel;
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
    @Column(name = "lifespan_name", nullable = false)
    private String lifespanName;
    @ManyToMany(mappedBy = "plantLifespans")
    private Set<ColorModel> plants = new HashSet<>();
}
